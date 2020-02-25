package de.gematik.ti.epa.fdv.authentication.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.signature.SignedInfo;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.resolver.implementations.ResolverXPointer;
import org.ksoap2.serialization.PropertyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import de.gematik.ti.epa.fdv.authentication.AuthenticationBindingSoap;
import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.authentication.security.ExtendedDigesterOutputStream;
import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticationResult;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;
import de.gematik.ti.epa.fdv.authentication.soap.*;
import de.gematik.ti.epa.fdv.gen.authentication.*;
import de.gematik.ti.utils.codec.Hex;

/**
 * Utils class to create soap valid requests included security headers to authenticate the insured
 */
public final class AuthnSerializationUtils {

    private static final Logger LOG = LoggerFactory.getLogger(AuthnSerializationUtils.class);

    private static final String BEGIN_ASSERTION = "<saml2:Assertion";
    private static final String END_ASSERTION = "</saml2:Assertion>";

    private AuthnSerializationUtils() {
    }

    /**
     * creates RequestSecurityTokenResponse for login crate token request
     * @param challenge String
     * @return RequestSecurityTokenResponseType
     */
    public static RequestSecurityTokenResponseType createRstrForLoginCreateToken(final String challenge) {
        final RequestSecurityTokenResponseType rstr = new RequestSecurityTokenResponseType();
        final SignChallengeType signChallengeType = new SignChallengeType();
        signChallengeType.Challenge = challenge;
        final PropertyInfo signChallengeResponse = createPropertyInfo("SignChallengeResponse", Namespaces.TRUST.getNamespaceUrl(), signChallengeType);
        rstr.any.add(signChallengeResponse);
        return rstr;
    }

    /**
     * creates w3c.dom.document for login create token which which will then be signed
     * @param rstr RequestSecurityTokenResponseType
     * @param service AuthenticationBindingSoap
     * @return w3c.dom.document
     */
    public static Document createDocFromRstr(final RequestSecurityTokenResponseType rstr, final AuthenticationBindingSoap service) {
        service.setShouldSendRequest(false);
        final ExpandedSoapSerializationEnvelope envelope = (ExpandedSoapSerializationEnvelope) service.createEnvelope();
        envelope.addMapping(Namespaces.TRUST.getNamespaceUrl(), "RequestSecurityTokenResponse",
                RequestSecurityTokenResponseType.class);
        envelope.bodyOut = rstr;
        envelope.setOutputSoapObject(rstr);
        service.setShouldSendRequest(false);
        service.sendRequest(Namespaces.CREATE_TOKEN.getNamespaceUrl(), envelope, null, null);
        final String request = new String(service.getRequestData());
        return createDocumentFromString(request);
    }

    /**
     * Creates security header for login create token request
     * @param signature SignatureInfoSignature
     * @param certificate byte array
     * @return SecurityHeaderType
     */
    public static SecurityHeaderType createSecurityHeader(final SignatureInfoSignature signature, final byte[] certificate) {
        final String tokenIdString = "x509-" + UUID.randomUUID().toString();
        final SecurityHeaderType securityHeader = new SecurityHeaderType();
        final PropertyInfo binarySecurityTokenProperty = createBinarySecurityTokenProperty(certificate, tokenIdString);
        securityHeader.any.add(binarySecurityTokenProperty);
        final PropertyInfo signatureProperty = createSignatureProperty(signature.getSignedInfoString(), signature.getSignatureInfoDigest(), tokenIdString);
        securityHeader.any.add(signatureProperty);
        return securityHeader;
    }

    /**
     * extracts challenge string from RequestSecurityTokenResponse
     * @param requestSecurityTokenResponseType RequestSecurityTokenResponseType
     * @return String
     */
    public static String extractChallengeValue(final RequestSecurityTokenResponseType requestSecurityTokenResponseType) {
        final PropertyInfo propertyInfo = requestSecurityTokenResponseType.any.get(0);
        final SignChallengeType signChallengeType = (SignChallengeType) propertyInfo.getValue();
        return signChallengeType.Challenge;
    }

    /**
     * Creates a signature via the signatureInfo using the AuthenticationProvider
     * @param docToSign Document
     * @param authenticationProvider {@link IAuthenticator}
     * @param sigAlgorithm String
     * @param uuid String
     * @return SignatureInfoSignature
     */
    public static SignatureInfoSignature signDocument(final Document docToSign, final IAuthenticator authenticationProvider, final String sigAlgorithm,
            final String uuid) {
        System.setProperty("org.apache.xml.security.ignoreLineBreaks", "true");
        org.apache.xml.security.Init.init();
        final SignatureInfoSignature signedSignatureInfo;

        try {
            ((Element) docToSign.getElementsByTagName("soap:Body").item(0)).setIdAttribute("wsu:Id", true);
            final XMLSignature sig = new XMLSignature(docToSign, "", XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256,
                    Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
            docToSign.getElementsByTagName("soap:Header").item(0).appendChild(sig.getElement());

            final SignedInfo signedInfo = sig.getSignedInfo();
            final SignatureAlgorithm signatureAlgorithm = setupSignatureAlgorithm(sig, signedInfo, sigAlgorithm, uuid);

            final MessageDigestAlgorithm digestAlgorithm = MessageDigestAlgorithm.getInstance(docToSign, MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA256);

            try (final ExtendedDigesterOutputStream digesterOutputStream = new ExtendedDigesterOutputStream(digestAlgorithm)) {
                signedInfo.generateDigestValues();
                final KeyPair dummyKeyPair = getDummyKeyPair();
                signatureAlgorithm.initSign(dummyKeyPair.getPrivate());
                signedInfo.signInOctetStream(digesterOutputStream);

                final String signedSignatureInfoString = new String(digesterOutputStream.getBos().toByteArray());

                final byte[] digest = digesterOutputStream.getDigestValue();
                LOG.debug("Digest:" + Hex.encodeHexString(digest));

                final IAuthenticationResult authenticationResult = authenticationProvider.signData(digest);
                final byte[] signedDigestValue = authenticationResult.getHashValue();

                signedSignatureInfo = new SignatureInfoSignature(signedSignatureInfoString, signedDigestValue);
            }
        } catch (final Exception e) {
            throw new AuthenticateException("Error on signing document: " + e);
        }

        return signedSignatureInfo;
    }

    /**
     * create {@link RequestedSecurityTokenType} for renew token request
     * @param rst RequestedSecurityTokenType
     * @param assertion String
     */
    public static void createRenewingRequest(final RequestSecurityTokenType rst, final String assertion) {
        final PropertyInfo tokenTypePi = createPropertyInfo("TokenType", Namespaces.TRUST.getNamespaceUrl(),
                Namespaces.SAML_2_TOKEN_PROFILE.getNamespaceUrl());
        final PropertyInfo requestTypePi = createPropertyInfo("RequestType", Namespaces.TRUST.getNamespaceUrl(),
                Namespaces.RENEW_TOKEN.getNamespaceUrl());
        final PropertyInfo renewTargetPi = createPropertyInfo("RenewTarget", Namespaces.TRUST.getNamespaceUrl(),
                new PreMarshalledPrimitive(Namespaces.TRUST.getNamespaceUrl(), "Assertion", assertion));

        rst.any.add(tokenTypePi);
        rst.any.add(requestTypePi);
        rst.any.add(renewTargetPi);
    }

    /**
     * create {@link RequestedSecurityTokenType} for logout token request
     * @param rst RequestedSecurityTokenType
     * @param assertion String
     */
    public static void createLogoutRequest(final RequestSecurityTokenType rst, final String assertion) {
        final PropertyInfo requestTypePi = createPropertyInfo("RequestType", Namespaces.TRUST.getNamespaceUrl(),
                Namespaces.CANCEL_TOKEN.getNamespaceUrl());
        final PropertyInfo cancelTargetPi = createPropertyInfo("CancelTarget", Namespaces.TRUST.getNamespaceUrl(),
                new PreMarshalledPrimitive(Namespaces.TRUST.getNamespaceUrl(), "Assertion", assertion));
        rst.any.add(requestTypePi);
        rst.any.add(cancelTargetPi);
    }

    /**
     * extracts assertion from response
     * @param responseString String
     * @return String with assertion
     */
    public static String extractAssertion(final String responseString) {
        LOG.debug("ResponseString: " + responseString);
        final String assertion;
        if (responseString.contains(BEGIN_ASSERTION) && responseString.contains(END_ASSERTION)) {
            final int beginIndex = responseString.indexOf(BEGIN_ASSERTION);
            final int endIndex = responseString.indexOf(END_ASSERTION) + END_ASSERTION.length();
            assertion = responseString.substring(beginIndex, endIndex);
            LOG.debug("Assertion: " + assertion);
            return assertion;
        }
        return null;
    }

    /**
     * creates PropertyInfo object with parameters
     * @param name String
     * @param nameSpace String
     * @param value Object
     * @return PropertyInfo
     */
    private static PropertyInfo createPropertyInfo(final String name, final String nameSpace, final Object value) {
        final PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.setName(name);
        propertyInfo.setNamespace(nameSpace);
        propertyInfo.setValue(value);
        return propertyInfo;
    }

    /**
     * create w3c.dom.document from xml string
     * @param xml String
     * @return Document
     */
    private static Document createDocumentFromString(final String xml) {
        final Document doc;
        final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        final DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            final InputStream is = new ByteArrayInputStream(xml.getBytes());
            org.apache.xml.security.Init.init();
            doc = dBuilder.parse(is);
        } catch (final ParserConfigurationException | SAXException | IOException e) {
            throw new AuthenticateException("Error on creating w3c.dom document from String: " + e);
        }
        return doc;
    }

    /**
     * transforms w3c.dom.Node to string
     * @param bodyNode Node
     * @return String
     */
    public static String nodeToString(final org.w3c.dom.Node bodyNode) {
        final StringWriter sw = new StringWriter();
        try {
            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(bodyNode), new StreamResult(sw));
        } catch (final TransformerException e) {
            throw new AuthenticateException("nodeToString Transformer Exception" + e);
        }
        return sw.toString();
    }

    private static KeyPair getDummyKeyPair() throws NoSuchAlgorithmException {
        final KeyPairGenerator kgen = KeyPairGenerator.getInstance("RSA");
        kgen.initialize(2048);
        return kgen.generateKeyPair();
    }

    private static SignatureAlgorithm setupSignatureAlgorithm(final XMLSignature sig, final SignedInfo signedInfo, final String signatureAlgorithm,
            final String uuid)
            throws TransformationException, XMLSignatureException {
        final String signatureAlgorithmNamespace = Namespaces.getSignatureAlgorithmNamespace(signatureAlgorithm);
        signedInfo.getElement().getElementsByTagName("ds:SignatureMethod").item(0).getAttributes().item(0)
                .setNodeValue(signatureAlgorithmNamespace);
        signedInfo.addResourceResolver(new ResolverXPointer());

        final Transforms transforms = new Transforms(sig.getDocument());
        transforms.addTransform(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS);
        final Set<String> inclusiveNameSpacePrefixes = new HashSet<>();
        inclusiveNameSpacePrefixes.add("soap");
        final InclusiveNamespaces inclusiveNamespaces = new InclusiveNamespaces(sig.getDocument(), inclusiveNameSpacePrefixes);

        signedInfo.getElement().getElementsByTagName("ds:CanonicalizationMethod").item(0)
                .appendChild(inclusiveNamespaces.getElement());

        sig.addDocument("#id-" + uuid, transforms, MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA256);
        return signedInfo.getSignatureAlgorithm();
    }

    private static PropertyInfo createSignatureProperty(final String signedInfoString, final byte[] signedDigestValue, final String tokenIdString) {
        final SignatureTypeWithSignedInfoString xmlSignature = new SignatureTypeWithSignedInfoString();
        xmlSignature.Id = "SIG-" + UUID.randomUUID().toString();
        xmlSignature.setSignedInfoString(signedInfoString);
        xmlSignature.SignatureValue = new ExtendedSignatureValueType();
        xmlSignature.SignatureValue.value = signedDigestValue;
        xmlSignature.KeyInfo = new KeyInfoType();
        xmlSignature.KeyInfo.Id = UUID.randomUUID().toString();

        final SecurityTokenReferenceType securityTokenReference = new SecurityTokenReferenceType();
        final ReferenceType_2 reference = new ReferenceType_2();
        reference.URI = "#" + tokenIdString;
        reference.ValueType = Namespaces.X_509_TOKEN_PROFILE.getNamespaceUrl();

        final PropertyInfo referenceProperty = createPropertyInfo("Reference", Namespaces.WSSE.getNamespaceUrl(), reference);
        securityTokenReference.any.add(referenceProperty);

        final PropertyInfo securityTokenReferenceProperty = createPropertyInfo("SecurityTokenReference", Namespaces.WSSE.getNamespaceUrl(),
                securityTokenReference);

        xmlSignature.KeyInfo.any.add(securityTokenReferenceProperty);

        return createPropertyInfo("Signature", Namespaces.DS.getNamespaceUrl(), xmlSignature);
    }

    private static PropertyInfo createBinarySecurityTokenProperty(final byte[] certificate, final String tokenIdString) {
        final byte[] certificateValueEncoded = Base64.getEncoder().encode(certificate);

        final BinarySecurityTokenTypeWithId securityToken = new BinarySecurityTokenTypeWithId();
        securityToken.value = new String(certificateValueEncoded);
        securityToken.EncodingType = Namespaces.BASE_64_ENCODING.getNamespaceUrl();
        securityToken.ValueType = Namespaces.X_509_TOKEN_PROFILE.getNamespaceUrl();
        securityToken.setId(tokenIdString);

        final PropertyInfo securityTokenPi = createPropertyInfo("BinarySecurityToken",
                Namespaces.BINARY_SECURITY_TOKEN_PROFILE.getNamespaceUrl(),
                securityToken.getSimpleValue());

        securityTokenPi.type = BinarySecurityTokenTypeWithId.class;
        return securityTokenPi;
    }
}
