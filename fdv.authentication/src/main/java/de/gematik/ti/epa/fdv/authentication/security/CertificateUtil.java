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

package de.gematik.ti.epa.fdv.authentication.security;

import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utils for {@link X509Certificate}
 */
public final class CertificateUtil {
    private static final Logger LOG = LoggerFactory.getLogger(CertificateUtil.class);

    private CertificateUtil() {
    }

    /**
     * Get X509Certificate from byte array
     * @param certBytes byte[]
     * @return X509Certificate
     */
    public static X509Certificate getCertificate(final byte[] certBytes) {
        try {
            final CertificateFactory cf = CertificateFactory.getInstance("X.509");
            final ByteArrayInputStream bis = new ByteArrayInputStream(certBytes);
            final Certificate certificate = cf.generateCertificate(bis);
            return (X509Certificate) certificate;
        } catch (final Exception e) {
            throw new IllegalArgumentException("Can not load certificate: " + e.getLocalizedMessage(), e);
        }
    }

    /**
     * ActorName :: (SN, GN) for ProtocolEntry
     * @param certificate X509Certificate
     * @return String
     */
    public static String getSurnameGivenName(final X509Certificate certificate) {
        final String names = certificate.getSubjectDN().getName();
        LOG.debug("names:" + names);
        final String[] spliter = names.split("[,+]");
        String givenName = "";
        for (final String spl : spliter) {
            final String temp = spl.trim();
            if (temp.toUpperCase().startsWith("GIVENNAME=")) {
                givenName = temp.substring("GIVENNAME=".length());
                LOG.debug("gn:" + givenName);
            }
        }

        String surName = "";
        for (final String spl : spliter) {
            String temp = spl.trim();
            temp = temp.trim();
            if (temp.toUpperCase().startsWith("SURNAME=")) {
                surName = temp.substring("SURNAME=".length());
                LOG.debug("surName:" + surName);
            }
        }
        return "(" + surName + ", " + givenName + ")";

    }

    /**
     * Returns the first field found in the X509Certificate with the specified field name
     * @param fieldName String
     * @param certX509 X509Certificate
     * @return String
     */
    private static String getFirstFieldFormCertificate(final String fieldName, final X509Certificate certX509) {
        final String[] fields = getFieldsFormCertificate(fieldName, certX509);
        if (fields.length > 0) {
            return fields[0];
        } else {
            return "";
        }
    }

    /**
     * Returns String array with fields found in the X509Certificate with the specified field name
     * @param fieldName String
     * @param certX509 X509Certificate
     * @return String array
     */
    private static String[] getFieldsFormCertificate(final String fieldName, final X509Certificate certX509) {
        final String x500Principal = certX509.getIssuerX500Principal().getName();
        final StringBuilder fields = new StringBuilder();
        final java.util.StringTokenizer st = new java.util.StringTokenizer(x500Principal, ",");

        while (st.hasMoreTokens()) {
            final String token = st.nextToken().trim();
            final int idx = token.indexOf('=');

            if (idx < 0 || !fieldName.equals(token.substring(0, idx))) {
                continue;
            }
            if (fields.length() > 0) {
                fields.append(",");
            }
            fields.append(token.substring(idx + 1));

        }
        return fields.toString().split(",");
    }

    /**
     * Returns String with common name found in  the X509Certificate
     * @param certificate X509Certificate
     * @return String
     */
    public static String getCommonName(final X509Certificate certificate) {
        return getFirstFieldFormCertificate("CN", certificate);
    }
}
