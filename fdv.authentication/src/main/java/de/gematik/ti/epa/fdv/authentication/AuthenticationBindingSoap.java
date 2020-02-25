package de.gematik.ti.epa.fdv.authentication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.ksoap2.transport.Transport;
import org.kxml2.kdom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.authentication.serialization.AuthnSerializationUtils;
import de.gematik.ti.epa.fdv.authentication.serialization.HeaderConverter;
import de.gematik.ti.epa.fdv.authentication.soap.ExpandedSoapSerializationEnvelope;
import de.gematik.ti.epa.fdv.authentication.transport.AdvancedHttpTransportSe;
import de.gematik.ti.epa.fdv.authentication.transport.AdvancedHttpsTransportSe;
import de.gematik.ti.epa.fdv.authentication.transport.SoapDataDelegate;
import de.gematik.ti.epa.fdv.gen.authentication.ExtendedSoapSerializationEnvelope;
import de.gematik.ti.epa.fdv.gen.authentication.I_Authentication_Insurant_Binding_Soap12;
import de.gematik.ti.epa.fdv.gen.authentication.SecurityHeaderType;

/**
 * Main class which connect to authentication web service
 */
public class AuthenticationBindingSoap extends I_Authentication_Insurant_Binding_Soap12 {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationBindingSoap.class);

    private static final int CONTINUATION = 60000;
    private static final int PORT = 443;
    private SecurityHeaderType securityHeader = null;
    private boolean shouldSendRequest = true;
    private boolean isLoginTokenRequest = false;
    private boolean isRenewTokenRequest = false;
    private final UUID uuid;
    private final String address;
    private final java.net.URI uri;
    private String assertion;
    private final SoapDataDelegate delegate;

    private byte[] requestData;

    /**
     * Contructor
     * @param url String
     */
    public AuthenticationBindingSoap(final String url) {
        super(url);
        address = url;
        uuid = UUID.randomUUID();
        try {
            uri = new java.net.URI(url);
        } catch (final URISyntaxException e) {
            throw new AuthenticateException(e);
        }
        delegate = new SoapDataDelegate();
    }

    /**
     * Overrides sendRequest method for generating and supplementing the request data
     * @param methodName String
     * @param envelope Soap envelope
     * @param transport {@link Transport}
     * @param profile ws addressing profile
     * @return List with response
     */
    @Override
    public List sendRequest(final String methodName, final ExtendedSoapSerializationEnvelope envelope, final Transport transport,
            final com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile) { // NOCS(SAB): Method overrides parent method with 4 parameters
        final SoapDataDelegate soapTransport = new SoapDataDelegate();
        List response = null;
        if (!shouldSendRequest) {
            try {
                requestData = soapTransport.generateRequestData(envelope);
            } catch (final IOException e) {
                throw new AuthenticateException(e);
            }
        } else {
            try {
                response = super.sendRequest(methodName, envelope, transport, profile);
            } catch (final Exception e) {
                throw new AuthenticateException(e);
            } finally {
                final String responseString;
                responseString = delegate.getResponseString();
                LOG.debug("Response: " + responseString);
                if (isLoginTokenRequest || isRenewTokenRequest) {
                    assertion = null;
                    assertion = AuthnSerializationUtils.extractAssertion(responseString);
                    LOG.debug("Request: " + transport.requestDump);
                }
            }
        }
        return response;
    }

    /**
     * Overrides createEnvelope() method - if is login token request a security header element will be added 
     * @return soap envelope
     */
    @Override
    public ExtendedSoapSerializationEnvelope createEnvelope() {
        final ExpandedSoapSerializationEnvelope envelope = new ExpandedSoapSerializationEnvelope(ExtendedSoapSerializationEnvelope.VER12);
        envelope.createClassesForAny = createClassesForAny;
        envelope.implicitTypes = true;
        envelope.setUuid(uuid);
        if (securityHeader != null && isLoginTokenRequest) {
            final Element headerElement = HeaderConverter.convertToHeader(securityHeader, Namespaces.WSSE.getNamespaceUrl(), "Security");
            envelope.headerOut = new Element[1];
            envelope.headerOut[0] = headerElement;
        }
        return envelope;
    }

    /**
     * Extends the createTransport method to adapt to the uri scheme
     * @return Transport
     */
    @Override
    protected org.ksoap2.transport.Transport createTransport() {
        final Transport transport;
        if ("https".equalsIgnoreCase(uri.getScheme())) {
            final int port = uri.getPort() > 0 ? uri.getPort() : PORT;
            transport = new AdvancedHttpsTransportSe(delegate, uri.getHost(), port, uri.getPath(), CONTINUATION);
            return transport;
        } else {
            transport = new AdvancedHttpTransportSe(delegate, address, CONTINUATION);
            return transport;
        }
    }

    void setSecurityHeader(final SecurityHeaderType securityHeader) {
        this.securityHeader = securityHeader;
    }

    public void setShouldSendRequest(final boolean shouldSendRequest) {
        this.shouldSendRequest = shouldSendRequest;
    }

    void setIsLoginTokenRequest(final boolean loginTokenRequest) {
        isLoginTokenRequest = loginTokenRequest;
    }

    void setRenewTokenRequest(final boolean renewTokenRequest) {
        isRenewTokenRequest = renewTokenRequest;
    }

    public UUID getUuid() {
        return uuid;
    }

    String getAssertion() {
        return assertion;
    }

    public byte[] getRequestData() {
        return requestData;
    }

}
