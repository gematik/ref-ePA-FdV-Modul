package de.gematik.ti.epa.fdv.authentication.serialization;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.ksoap2.serialization.PropertyInfo;
import org.mockito.Mockito;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.gematik.ti.epa.fdv.authentication.AuthenticationBindingSoap;
import de.gematik.ti.epa.fdv.authentication.AuthnTestUtils;
import de.gematik.ti.epa.fdv.authentication.security.ExtendedDigesterOutputStream;
import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.entities.AuthenticationResult;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.entities.AuthenticationState;
import de.gematik.ti.epa.fdv.authentication.soap.SignatureInfoSignature;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenResponseType;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenType;
import de.gematik.ti.epa.fdv.gen.authentication.SecurityHeaderType;
import de.gematik.ti.epa.fdv.gen.authentication.SignChallengeType;
import de.gematik.ti.utils.codec.Hex;

/**
 * Test {@link AuthnSerializationUtils}
 */
public class AuthnSerializationUtilsTest {

    private static AuthenticationBindingSoap service;
    private static final String HTTP_URL = "http://testUrl.de";
    private static final String DIGEST = "12345";
    private static String assertion;

    private static final String CHALLENGE = "jXCWG_MYz4-91rrb3mTOQkA6A6SyJGW0k14RX7IofvcXtGPpXPBiIg8BGOVyotJ4yaAgiLIh-SBW_dqtItMZSk_sx7FaiRktZG-2PQgYXpD9DoFP7jgf23OwJj39Wk6nUTKi7jOKTL-1CTOZ6st6AshFB0wE4qXUS8_T0yuIBjxL26RJKfYpzsNHK2K_8w6B3sVzXnMvqS5Lem3sJHaBkiU8Ab-FJISMG86FsG8kZjeYqYfK-mKCZo9M3b0OahGO0hnePuatVicvdiYTOXGggobnNydiCLtglUDp80kqt_UxSF-fKPXc1YIeYghj1rVTbOuTUHo4eqvj3S7UXytNvA==";

    private static final IAuthenticator authenticator = Mockito.mock(IAuthenticator.class);
    private static final ExtendedDigesterOutputStream digesterOutputStream = Mockito.mock(ExtendedDigesterOutputStream.class);

    private static final byte[] hashValue = new byte[] {};

    private static RequestSecurityTokenResponseType getChallengeResponse;

    @BeforeClass
    public static void init() {
        service = new AuthenticationBindingSoap(HTTP_URL);
        final InputStream assertionInput = ClassLoader.getSystemResourceAsStream("assertion.xml");
        assertion = AuthnTestUtils.readInputStreamToString(assertionInput);
        Mockito.when(digesterOutputStream.getDigestValue()).thenReturn(hashValue);
        Mockito.when(authenticator.signData(hashValue)).thenReturn(new AuthenticationResult(AuthenticationState.AUTH_SUCCEED, new byte[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void testCreateRstrForLoginCreateToken() {
        final RequestSecurityTokenResponseType rstr = AuthnSerializationUtils.createRstrForLoginCreateToken(CHALLENGE);
        final PropertyInfo pi = rstr.any.get(0);
        Assert.assertEquals("SignChallengeResponse", pi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), pi.getNamespace());
        final SignChallengeType sc = (SignChallengeType) pi.getValue();
        final String challenge = sc.Challenge;
        Assert.assertEquals(CHALLENGE, challenge);
    }

    @Test
    public void testCreateDocFromRstr() {
        final RequestSecurityTokenResponseType rstr = AuthnSerializationUtils.createRstrForLoginCreateToken(CHALLENGE);
        final Document doc = AuthnSerializationUtils.createDocFromRstr(rstr, service);
        final NodeList bodyList = doc.getElementsByTagName("Body");
        final Node bodyNode = bodyList.item(0);
        final String bodyString = AuthnSerializationUtils.nodeToString(bodyNode);
        Assert.assertNotNull(bodyString);
    }

    @Test
    public void testCreateSecurityHeader() {
        final SecurityHeaderType securityHeader = AuthnSerializationUtils
                .createSecurityHeader(new SignatureInfoSignature("", new byte[] {}), new byte[] {});
        final PropertyInfo binarySecurityTokenPi = securityHeader.any.get(0);
        Assert.assertEquals("BinarySecurityToken", binarySecurityTokenPi.getName());
        final PropertyInfo signaturePi = securityHeader.any.get(1);
        Assert.assertEquals("Signature", signaturePi.getName());
    }

    @Ignore
    @Test
    public void testSignDocument() {
        final RequestSecurityTokenResponseType rstr = AuthnSerializationUtils.createRstrForLoginCreateToken(CHALLENGE);
        final Document doc = AuthnSerializationUtils.createDocFromRstr(rstr, service);
        final SignatureInfoSignature signatureInfoSignature = AuthnSerializationUtils.signDocument(doc, authenticator, "EC", service.getUuid().toString());
        final byte[] digest = signatureInfoSignature.getSignatureInfoDigest();
        Assert.assertEquals(Hex.decode(DIGEST), digest);
        signatureInfoSignature.getSignedInfoString();
    }

    @Test
    public void testCreateRenewingRequest() {
        final RequestSecurityTokenType rst = new RequestSecurityTokenType();

        AuthnSerializationUtils.createRenewingRequest(rst, assertion);
        final PropertyInfo tokenTypePi = rst.any.get(0);
        Assert.assertEquals("TokenType", tokenTypePi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), tokenTypePi.getNamespace());

        final PropertyInfo requestTypePi = rst.any.get(1);
        Assert.assertEquals("RequestType", requestTypePi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), requestTypePi.getNamespace());

        final PropertyInfo renewTargetPi = rst.any.get(2);
        Assert.assertEquals("RenewTarget", renewTargetPi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), renewTargetPi.getNamespace());

        final PreMarshalledPrimitive targetAssertion = (PreMarshalledPrimitive) renewTargetPi.getValue();
        final String targetAssertionString = (String) targetAssertion.getValue();
        Assert.assertEquals(assertion, targetAssertionString);
    }

    @Test
    public void testCreateLogoutRequest() {
        final RequestSecurityTokenType rst = new RequestSecurityTokenType();
        AuthnSerializationUtils.createLogoutRequest(rst, assertion);

        final PropertyInfo requestTypePi = rst.any.get(0);
        Assert.assertEquals("RequestType", requestTypePi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), requestTypePi.getNamespace());

        final PropertyInfo cancelTargetPi = rst.any.get(1);
        Assert.assertEquals("CancelTarget", cancelTargetPi.getName());
        Assert.assertEquals(Namespaces.TRUST.getNamespaceUrl(), cancelTargetPi.getNamespace());

        final PreMarshalledPrimitive targetAssertion = (PreMarshalledPrimitive) cancelTargetPi.getValue();
        final String targetAssertionString = (String) targetAssertion.getValue();
        Assert.assertEquals(assertion, targetAssertionString);
    }

    @Test
    public void testExtractChallengeValue() {
        getChallengeResponse = new RequestSecurityTokenResponseType();
        final PropertyInfo challengePi = new PropertyInfo();
        final SignChallengeType signChallenge = new SignChallengeType();
        signChallenge.Challenge = CHALLENGE;
        challengePi.setName("SignChallenge");
        challengePi.setValue(signChallenge);
        getChallengeResponse.any.add(challengePi);

        final String extractedChallenge = AuthnSerializationUtils.extractChallengeValue(getChallengeResponse);
        Assert.assertEquals(CHALLENGE, extractedChallenge);
    }

    @Test
    public void testExtractAssertion() {
        final InputStream responseInput = ClassLoader.getSystemResourceAsStream("loginTokenResponse.xml");
        final String response = AuthnTestUtils.readInputStreamToString(responseInput);
        final String extractedAssertion = AuthnSerializationUtils.extractAssertion(response);
        Assert.assertNotNull(extractedAssertion);
    }

}
