package de.gematik.ti.epa.fdv.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.cert.X509Certificate;

import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.jcajce.JcaX509CertificateConverter;
import org.spongycastle.openssl.PEMParser;

public class AuthnTestUtils {
    public static String readInputStreamToString(final InputStream inputStream) {
        String xmlString = null;

        final InputStreamReader isReader = new InputStreamReader(inputStream);
        // Creating a BufferedReader object
        final BufferedReader reader = new BufferedReader(isReader);
        final StringBuilder sb = new StringBuilder();
        try {
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
        } catch (final IOException e) {
            throw new RuntimeException("Error on reading inputStream: " + e.getMessage());
        }
        xmlString = sb.toString();

        return xmlString;
    }

    public static X509Certificate readCert(final String s) {
        X509Certificate cert = null;
        try {
            final InputStream inputStream = ClassLoader.getSystemResourceAsStream(s);
            final PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
            final Object object = parser.readObject();
            if (object != null) {
                cert = new JcaX509CertificateConverter().getCertificate((X509CertificateHolder) object);
            }
        } catch (final Exception e) {
            throw new RuntimeException("Error on reading X509-Certificate from String: " + e.getMessage());

        }
        return cert;
    }
}
