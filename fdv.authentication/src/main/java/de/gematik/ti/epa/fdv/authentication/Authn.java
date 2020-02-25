/*
 * Copyright (c) 2020 gematik GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.gematik.ti.epa.fdv.authentication;

import java.net.URL;
import java.security.cert.X509Certificate;

import org.w3c.dom.Document;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.authentication.security.CertificateUtil;
import de.gematik.ti.epa.fdv.authentication.serialization.AuthnSerializationUtils;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;
import de.gematik.ti.epa.fdv.authentication.soap.SignatureInfoSignature;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenResponseType;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenType;
import de.gematik.ti.epa.fdv.gen.authentication.SignChallengeType;
import de.gematik.ti.healthcardaccess.operation.ResultOperation;
import de.gematik.ti.healthcardaccess.operation.Subscriber;

/**
 * Enforces required operations (login create challenge / login create token / renew token / logout token) according to ws-Trust to authenticate the user
 * Login create challenge / login create token / renew token / logout token according to ws-Trust
 */
public final class Authn {

    private static Authn instance;

    private Subscriber<IAuthenticator> authnProviderSubscriber;

    private final URL url;
    private AuthenticationBindingSoap service;
    private IAuthenticator authenticationProvider;

    private Authn(final URL url) {
        this.url = url;
        initAuthService();
        initProviderSubscriber();

        final ResultOperation<IAuthenticator> authenticatorResult = getAuthnProvider();
        if (authenticatorResult != null) {
            authenticatorResult.subscribe(authnProviderSubscriber);
        }
    }

    /**
     * Returns an instance of authn to use the operations to authenticate the user
     * @param url Url of authentication module
     * @return instance of authn           
     */
    public static Authn getInstance(final URL url) {
        if (instance == null) {
            instance = new Authn(url);
            return instance;
        } else {
            return instance;
        }
    }

    /**
     * Login part 1: Create challenge
     * @return challengeResult
     */
    public ResultOperation<String> loginCreateChallenge() {
        service.setIsLoginTokenRequest(false);
        final RequestSecurityTokenResponseType createChallengeResponse;
        try {
            createChallengeResponse = service
                    .LoginCreateChallenge(new RequestSecurityTokenType());
        } catch (final Exception e) {
            throw new AuthenticateException("LoginCreateChallenge failed: " + e);
        }
        final String challenge = ((SignChallengeType) createChallengeResponse.any.get(0).getValue()).Challenge;
        return ResultOperation.unitRo(challenge);
    }

    /**
     * * Login part 2: Create token
     * @param challenge String
     * @return ResultOperation assertion
     */
    public ResultOperation<String> loginCreateToken(final String challenge) {
        final RequestSecurityTokenResponseType rstr = AuthnSerializationUtils.createRstrForLoginCreateToken(challenge);
        final byte[] certificate = authenticationProvider.getCertificateValue();
        final X509Certificate x509Cert = CertificateUtil.getCertificate(certificate);
        final String signatureAlgorithm = x509Cert.getPublicKey().getAlgorithm();
        final Document docToSign = AuthnSerializationUtils.createDocFromRstr(rstr, service);
        final String uuid = service.getUuid().toString();
        final SignatureInfoSignature sig = AuthnSerializationUtils.signDocument(docToSign, authenticationProvider, signatureAlgorithm, uuid);

        try {
            service.setSecurityHeader(AuthnSerializationUtils.createSecurityHeader(sig, certificate));
            service.setShouldSendRequest(true);
            service.setIsLoginTokenRequest(true);
            service.setRenewTokenRequest(false);
            service.LoginCreateToken(rstr);
        } catch (final Exception e) {
            throw new AuthenticateException("LoginCreateToken failed: " + e);
        }

        final String assertion = service.getAssertion();
        return ResultOperation.unitRo(assertion);
    }

    /**
     * Login part 3: Renew token
     * @param assertion String
     * @return ResultOperation assertion
     */
    public ResultOperation<String> renewToken(final String assertion) {
        final RequestSecurityTokenType rst = new RequestSecurityTokenType();

        service.setShouldSendRequest(true);
        service.setIsLoginTokenRequest(false);
        service.setRenewTokenRequest(true);

        if (assertion != null) {
            AuthnSerializationUtils.createRenewingRequest(rst, assertion);
            try {
                service.RenewToken(rst);

            } catch (final Exception e) {
                throw new AuthenticateException("RenewToken failed: " + e);
            }
        }

        final String newAssertion = service.getAssertion();
        return ResultOperation.unitRo(newAssertion);
    }

    /**
     * Login part 4: Logout token
     * @param assertion String
     * @return ResultOperation
     */
    public ResultOperation<RequestSecurityTokenResponseType> logoutToken(final String assertion) {
        final RequestSecurityTokenType rst = new RequestSecurityTokenType();
        RequestSecurityTokenResponseType rstr = null;
        service.setShouldSendRequest(true);
        service.setIsLoginTokenRequest(false);
        service.setRenewTokenRequest(false);

        if (assertion != null) {
            AuthnSerializationUtils.createLogoutRequest(rst, assertion);
            try {
                rstr = service.LogoutToken(rst);
            } catch (final Exception e) {
                throw new AuthenticateException("LogoutToken failed" + e);
            }
        }
        return ResultOperation.unitRo(rstr);
    }

    private void initProviderSubscriber() {
        authnProviderSubscriber = new Subscriber<IAuthenticator>() {
            @Override
            public void onSuccess(final IAuthenticator value) {
                authenticationProvider = value;
            }

            @Override
            public void onError(final Throwable t) throws AuthenticateException {
                throw new AuthenticateException("Failed to load authentication provider: " + t);
            }
        };
    }

    private void initAuthService() {
        service = new AuthenticationBindingSoap(url.toString());
        service.enableLogging = false;
        service.createClassesForAny = true;
    }


    private ResultOperation<IAuthenticator> getAuthnProvider() {
        final AuthnService authServiceLoader = new AuthnService();
        authenticationProvider = authServiceLoader.getAuthenticationProvider();
        if (authenticationProvider != null) {
            return ResultOperation.unitRo(authenticationProvider);
        }
        return null;
    }
}
