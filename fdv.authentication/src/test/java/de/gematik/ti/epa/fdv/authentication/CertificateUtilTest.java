package de.gematik.ti.epa.fdv.authentication;

import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gematik.ti.epa.fdv.authentication.security.CertificateUtil;
import de.gematik.ti.epa.fdv.authentication.serialization.AuthnSerializationUtilsTest;

/**
 * Test {@link de.gematik.ti.epa.fdv.authentication.security.CertificateUtil}
 */
public class CertificateUtilTest {

    private static final Logger LOG = LoggerFactory.getLogger(AuthnSerializationUtilsTest.class);

    static byte[] certificateBytes;
    static X509Certificate cert;

    @BeforeClass
    public static void init() throws CertificateEncodingException {
        cert = AuthnTestUtils.readCert("X509Cert.pem");
        certificateBytes = cert.getEncoded();
        Assert.assertNotNull(certificateBytes);
    }

    @Test
    public void testGetCertificateFromByteArray() {
        final X509Certificate certificate = CertificateUtil.getCertificate(certificateBytes);
        Assert.assertEquals(cert.getIssuerDN(), certificate.getIssuerDN());
        Assert.assertEquals(cert.getPublicKey(), certificate.getPublicKey());
    }

    @Test
    public void testGetSurnameGivenName() throws UnsupportedEncodingException {
        final String surnameGivenName = de.gematik.ti.epa.fdv.authentication.security.CertificateUtil.getSurnameGivenName(cert);
        Assert.assertEquals(new String("(Tínman, Rudolf)".getBytes(), "UTF-8"), surnameGivenName);
    }

    @Test
    public void testGetCommonName() {
        final String commonName = de.gematik.ti.epa.fdv.authentication.security.CertificateUtil.getCommonName(cert);
        Assert.assertEquals("GEM.EGK-CA08 TEST-ONLY", commonName);
    }
}
