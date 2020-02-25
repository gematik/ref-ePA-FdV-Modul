package de.gematik.ti.epa.fdv.authentication.security;

public enum Namespaces {
    WSU("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"),
    WSSE("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
    DS("http://www.w3.org/2000/09/xmldsig#"),
    TRUST("http://docs.oasis-open.org/ws-sx/ws-trust/200512"),
    SAML_2("urn:oasis:names:tc:SAML:2.0:assertion"),
    XML("http://www.w3.org/XML/1998/namespace"),
    XSI("http://www.w3.org/2001/XMLSchema-instance"),
    XSD("http://www.w3.org/2001/XMLSchema"),
    ENC("http://schemas.xmlsoap.org/soap/encoding/"),
    SAML_2_TOKEN_PROFILE("http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0"),
    CREATE_TOKEN("http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue"),
    RENEW_TOKEN("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew"),
    CANCEL_TOKEN("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Cancel"),
    BASE_64_ENCODING("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary"),
    X_509_TOKEN_PROFILE("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3"),
    BINARY_SECURITY_TOKEN_PROFILE("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
    RSA_MFG_1("http://www.w3.org/2007/05/xmldsig-more#sha256-rsa-MGF1"),
    ECDSA("http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256");

    private final String url;

    Namespaces(final String url) {
        this.url = url;
    }

    public static String getSignatureAlgorithmNamespace(final String signatureAlgorithm) {

        if ("RSA".equals(signatureAlgorithm)) {
            return RSA_MFG_1.getNamespaceUrl();
        } else {
            return ECDSA.getNamespaceUrl();
        }
    }

    public String getNamespaceUrl() {
        return url;
    }
}
