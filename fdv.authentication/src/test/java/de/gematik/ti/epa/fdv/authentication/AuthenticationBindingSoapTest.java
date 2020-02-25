package de.gematik.ti.epa.fdv.authentication;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ksoap2.transport.Transport;
import org.kxml2.kdom.Element;

import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.authentication.serialization.AuthnSerializationUtils;
import de.gematik.ti.epa.fdv.authentication.soap.SignatureInfoSignature;
import de.gematik.ti.epa.fdv.authentication.transport.AdvancedHttpTransportSe;
import de.gematik.ti.epa.fdv.authentication.transport.AdvancedHttpsTransportSe;
import de.gematik.ti.epa.fdv.gen.authentication.ExtendedSoapSerializationEnvelope;
import de.gematik.ti.epa.fdv.gen.authentication.SecurityHeaderType;

public class AuthenticationBindingSoapTest {

    private static final int EXPECTED_HTTP_PORT = -1;
    private static final int EXPECTED_HTTPS_PORT = 443;
    private static final String HTTP_URL = "http://testUrl.de";
    private static final String HTTPS_URL = "https://testUrl.de";
    private AuthenticationBindingSoap service;

    @Before
    public void init() {
        service = new AuthenticationBindingSoap(HTTPS_URL);
    }

    @Test
    public void testCreateTransportHttp() throws MalformedURLException {
        service = new AuthenticationBindingSoap(HTTP_URL);
        final Transport transport = service.createTransport();
        Assert.assertTrue(transport instanceof AdvancedHttpTransportSe);
        final int port = transport.getPort();
        Assert.assertEquals(EXPECTED_HTTP_PORT, port);
    }

    @Test
    public void testCreateTransportHttps() throws MalformedURLException {
        final Transport transport = service.createTransport();
        Assert.assertTrue(transport instanceof AdvancedHttpsTransportSe);
        final int port = transport.getPort();
        Assert.assertEquals(EXPECTED_HTTPS_PORT, port);
    }

    @Test
    public void testCreateEnvelopeWithoutSecurityHeader() {
        service.createClassesForAny = true;
        service.setSecurityHeader(null);
        service.setIsLoginTokenRequest(false);
        final ExtendedSoapSerializationEnvelope envelope = service.createEnvelope();
        final Element[] headers = envelope.headerOut;
        Assert.assertNull(headers);
    }

    @Test
    public void testCreateEnvelopeWithSecurityHeader() {
        final SecurityHeaderType securityHeader = AuthnSerializationUtils
                .createSecurityHeader(new SignatureInfoSignature("", new byte[] {}), new byte[] {});
        service.setSecurityHeader(securityHeader);
        service.setIsLoginTokenRequest(true);
        final ExtendedSoapSerializationEnvelope envelope = service.createEnvelope();
        final Element[] headers = envelope.headerOut;
        Assert.assertNotNull(headers);

        final Element headerElement = headers[0];
        Assert.assertEquals(Namespaces.WSSE.getNamespaceUrl(), headerElement.getNamespace());

        final String name = headerElement.getName();
        Assert.assertEquals("Security", name);

        final int nrOfChildElements = headerElement.getRoot().getChildCount();
        Assert.assertEquals(2, nrOfChildElements);
        testBinarySecurityTokenElement((Element) headerElement.getRoot().getChild(0));
    }

    private void testBinarySecurityTokenElement(final Element binarySecurityTokenElement) {
        Assert.assertEquals("BinarySecurityToken", binarySecurityTokenElement.getName());
        Assert.assertEquals(Namespaces.WSSE.getNamespaceUrl(), binarySecurityTokenElement.getNamespace());
        Assert.assertEquals(3, binarySecurityTokenElement.getAttributeCount());

        final String encodingTypeAttributeName = binarySecurityTokenElement.getAttributeName(0);
        Assert.assertEquals("EncodingType", encodingTypeAttributeName);
        final String encoding = binarySecurityTokenElement.getAttributeValue(0);
        Assert.assertEquals(Namespaces.BASE_64_ENCODING.getNamespaceUrl(), encoding);

        final String valueTypeAttributeName = binarySecurityTokenElement.getAttributeName(1);
        Assert.assertEquals("ValueType", valueTypeAttributeName);
        final String valueTypeValue = binarySecurityTokenElement.getAttributeValue(1);
        Assert.assertEquals(Namespaces.X_509_TOKEN_PROFILE.getNamespaceUrl(), valueTypeValue);

        final String iDAttributeName = binarySecurityTokenElement.getAttributeName(2);
        Assert.assertEquals("Id", iDAttributeName);
        final String iDAttributeNamespace = binarySecurityTokenElement.getAttributeNamespace(2);
        Assert.assertEquals(Namespaces.WSU.getNamespaceUrl(), iDAttributeNamespace);
        final int iDValueLenght = binarySecurityTokenElement.getAttributeValue(2).length();
        Assert.assertEquals(41, iDValueLenght);
    }

}
