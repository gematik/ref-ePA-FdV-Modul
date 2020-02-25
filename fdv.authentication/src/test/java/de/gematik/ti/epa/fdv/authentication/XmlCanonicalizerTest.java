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

package de.gematik.ti.epa.fdv.authentication;;

import org.junit.Assert;
import org.junit.Test;

/**
 * Testclass of {@link XmlCanonicalizer}
 */
public class XmlCanonicalizerTest {
    public final static String INCLUSIVE_XML_CANONICALIZATION = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    public final static String INCLUSIVE_XML_CANONICALIZATION_WITH_COMMENTS = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments";
    public final static String EXCLUSIVE_XML_CANONICALIZATION = "http://www.w3.org/2001/10/xml-exc-c14n#";
    public final static String EXCLUSIVE_XML_CANONICALIZATION_WITH_COMMENTS = "http://www.w3.org/2001/10/xml-exc-c14n#WithComments";

    final String xmlSource = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"><soap:Header><Action     " +
            "xmlns=\"http://www.w3.org/2005/08/addressing\">http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Challenge</Action>" +
            "<MessageID xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:55723135-807d-43b3-a7d6-f61bbb2b1290</MessageID>" +
            "<To xmlns=\"http://www.w3.org/2005/08/addressing\">http://www.w3.org/2005/08/addressing/anonymous</To>" +
            "<RelatesTo xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:f23604b2-56e9-4eb2-9fe0-d74af73d683f</RelatesTo>" +
            "</soap:Header><soap:Body><RequestSecurityTokenResponse xmlns=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\" " +
            "xmlns:ns2=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" " +
            "xmlns:ns3=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" " +
            "xmlns:ns4=\"http://www.w3.org/2005/08/addressing\" xmlns:ns5=\"http://ws.gematik.de/fa/phrext/v1.0\" " +
            "xmlns:ns6=\"http://ws.gematik.de/tel/error/v2.0\" xmlns:ns7=\"http://ws.gematik.de/fd/phrs/I_Authentication_Insurant/v1.1\" " +
            "xmlns:ns8=\"http://www.w3.org/2001/04/xmlenc#\" xmlns:ns9=\"http://www.w3.org/2000/09/xmldsig#\" " +
            "xmlns:ns10=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:ns11=\"urn:oasis:names:tc:SAML:2.0:assertion\" " +
            "xmlns:ns12=\"http://www.w3.org/2006/05/addressing/wsdl\">" +
            "<SignChallenge>" +
            "<Challenge>CAmxL6qzQI01mcyBKQ4r0D4TjsjnBYTHLOkFz_JE9LXFX2ufOAdME2HMADAygn6phAym6mazA22Zjpa-9_dAKCSVvT5xRtL2yIaqv5-oxKThBs" +
            "uNX3a14VDKnxDC78Hopsoz--WAy9D73HdMMkVZG2bNGZuzDmNKc_CScwDzQ4eDekViwDIK54wl9Zuvhy7a1mf8zEZhhEZutb6DkjMwVk5UuHNKLER74XUrw3Va-" +
            "vGVeFGWxpQwDCKAtV3xW7x_Fe-N02bOml08Q8Xc_0r_0TZ0hZcTpvQIBKMwOdp2ygXMO1k5ggG56DtpTLoHhvd6yBOmQ3KDhYuN5aRpL-cR2g==" +
            "</Challenge></SignChallenge></RequestSecurityTokenResponse></soap:Body></soap:Envelope>";

    final String expected = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">" +
            "<soap:Header><Action xmlns=\"http://www.w3.org/2005/08/addressing\">" +
            "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Challenge</Action><MessageID " +
            "xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:55723135-807d-43b3-a7d6-f61bbb2b1290</MessageID>" +
            "<To xmlns=\"http://www.w3.org/2005/08/addressing\">http://www.w3.org/2005/08/addressing/anonymous</To>" +
            "<RelatesTo xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:f23604b2-56e9-4eb2-9fe0-d74af73d683f" +
            "</RelatesTo></soap:Header><soap:Body><RequestSecurityTokenResponse xmlns=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\">" +
            "<SignChallenge>" +
            "<Challenge>CAmxL6qzQI01mcyBKQ4r0D4TjsjnBYTHLOkFz_JE9LXFX2ufOAdME2HMADAygn6phAym6mazA22Zjpa-9_dAKCSVvT5xRtL2yIaqv5-oxKThBsuN" +
            "X3a14VDKnxDC78Hopsoz--WAy9D73HdMMkVZG2bNGZuzDmNKc_CScwDzQ4eDekViwDIK54wl9Zuvhy7a1mf8zEZhhEZutb6DkjMwVk5UuHNKLER74XUrw3Va-vGV" +
            "eFGWxpQwDCKAtV3xW7x_Fe-N02bOml08Q8Xc_0r_0TZ0hZcTpvQIBKMwOdp2ygXMO1k5ggG56DtpTLoHhvd6yBOmQ3KDhYuN5aRpL-cR2g==</Challenge>" +
            "</SignChallenge></RequestSecurityTokenResponse></soap:Body></soap:Envelope>";

    final String expectedInclusive = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"><soap:Header>" +
            "<Action xmlns=\"http://www.w3.org/2005/08/addressing\">http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Challenge" +
            "</Action><MessageID xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:55723135-807d-43b3-a7d6-f61bbb2b1290</MessageID>" +
            "<To xmlns=\"http://www.w3.org/2005/08/addressing\">http://www.w3.org/2005/08/addressing/anonymous</To><RelatesTo " +
            "xmlns=\"http://www.w3.org/2005/08/addressing\">urn:uuid:f23604b2-56e9-4eb2-9fe0-d74af73d683f</RelatesTo></soap:Header>" +
            "<soap:Body><RequestSecurityTokenResponse xmlns=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\" xmlns:ns10=\"" +
            "http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:ns11=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:ns12=\"" +
            "http://www.w3.org/2006/05/addressing/wsdl\" xmlns:ns2=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-" +
            "wss-wssecurity-utility-1.0.xsd\" xmlns:ns3=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" " +
            "xmlns:ns4=\"http://www.w3.org/2005/08/addressing\" xmlns:ns5=\"http://ws.gematik.de/fa/phrext/v1.0\" xmlns:ns6=\"" +
            "http://ws.gematik.de/tel/error/v2.0\" xmlns:ns7=\"http://ws.gematik.de/fd/phrs/I_Authentication_Insurant/v1.1\" xmlns:ns8=\"" +
            "http://www.w3.org/2001/04/xmlenc#\" xmlns:ns9=\"http://www.w3.org/2000/09/xmldsig#\"><SignChallenge><Challenge>CAmxL6qzQI01mcyBK" +
            "Q4r0D4TjsjnBYTHLOkFz_JE9LXFX2ufOAdME2HMADAygn6phAym6mazA22Zjpa-9_dAKCSVvT5xRtL2yIaqv5-oxKThBsuNX3a14VDKnxDC78Hopsoz--WAy9D73HdM" +
            "MkVZG2bNGZuzDmNKc_CScwDzQ4eDekViwDIK54wl9Zuvhy7a1mf8zEZhhEZutb6DkjMwVk5UuHNKLER74XUrw3Va-vGVeFGWxpQwDCKAtV3xW7x_Fe-N02bOml08Q8Xc_0r" +
            "_0TZ0hZcTpvQIBKMwOdp2ygXMO1k5ggG56DtpTLoHhvd6yBOmQ3KDhYuN5aRpL-cR2g==</Challenge></SignChallenge></RequestSecurityTokenResponse></s" +
            "oap:Body></soap:Envelope>";

    @Test
    public void testCanonicalizeXmlExclusive() {
        final XmlCanonicalizer xmlCanonicalizer = new XmlCanonicalizer();
        final String xmlCanon = xmlCanonicalizer.canonicalizeXml(xmlSource, EXCLUSIVE_XML_CANONICALIZATION);
        Assert.assertEquals(expected, xmlCanon);

    }

    @Test
    public void testCanonicalizeXmlExclusiveWithComments() {
        final XmlCanonicalizer xmlCanonicalizer = new XmlCanonicalizer();
        final String xmlCanon = xmlCanonicalizer.canonicalizeXml(xmlSource, EXCLUSIVE_XML_CANONICALIZATION_WITH_COMMENTS);
        Assert.assertEquals(expected, xmlCanon);
    }

    @Test
    public void testCanonicalizeXmlInclusive() {
        final XmlCanonicalizer xmlCanonicalizer = new XmlCanonicalizer();
        final String xmlCanon = xmlCanonicalizer.canonicalizeXml(xmlSource, INCLUSIVE_XML_CANONICALIZATION);
        Assert.assertEquals(expectedInclusive, xmlCanon);
    }

    @Test
    public void testCanonicalizeXmlInclusiveWithComments() {
        final XmlCanonicalizer xmlCanonicalizer = new XmlCanonicalizer();
        final String xmlCanon = xmlCanonicalizer.canonicalizeXml(xmlSource, INCLUSIVE_XML_CANONICALIZATION_WITH_COMMENTS);
        Assert.assertEquals(expectedInclusive, xmlCanon);
    }
}
