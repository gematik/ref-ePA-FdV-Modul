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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.canonical.Canonicalizer;

/**
 * Writes XML in the format XML Canonicalization Version 1.0
 */
public class XmlCanonicalizer {

    /**
     * Returns a canonicalized xml String
     * @param xml String
     * @param canonicalizationMethod String
     * @return canonicalized xml String
     */
    public String canonicalizeXml(final String xml, final String canonicalizationMethod) {
        final byte[] inputBytes = xml.getBytes();
        return canonicalizeXml(inputBytes, canonicalizationMethod);
    }

    /**
     * Returns a canonicalized xml String
     * @param inputBytes xml byteArray 
     * @param canonicalizationMethod String 
     * @return canonicalized xml String
     */
    public String canonicalizeXml(final byte[] inputBytes, final String canonicalizationMethod) {
        final byte[] canonXmlBytes = canonicalizeXml(canonicalizationMethod, inputBytes);
        return new String(canonXmlBytes);
    }

    /**
     * Returns a canonicalized xml byteArray
     * @param canonicalizationMethod String
     * @param inputBytes xml byteArray
     * @return canonicalized xml byteArray
     */
    public byte[] canonicalizeXml(final String canonicalizationMethod, final byte[] inputBytes) {
        final ByteArrayInputStream bis = new ByteArrayInputStream(inputBytes);
        try {
            final Builder parser = new Builder();
            final Document doc = parser.build(bis);
            final ByteArrayOutputStream canonicalOs = new ByteArrayOutputStream();
            final Canonicalizer canonicalizer = new Canonicalizer(canonicalOs, canonicalizationMethod);
            canonicalizer.write(doc);
            return canonicalOs.toByteArray();
        } catch (final Exception e) {
            throw new AuthenticateException(e);
        }
    }
}
