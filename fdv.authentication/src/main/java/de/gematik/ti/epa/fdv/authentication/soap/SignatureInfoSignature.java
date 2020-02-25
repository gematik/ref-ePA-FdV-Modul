package de.gematik.ti.epa.fdv.authentication.soap;

/**
 * Signature object with signed info and digest value
 */
public class SignatureInfoSignature {
    private final String signedInfoString;
    private final byte[] signatureInfoDigest;

    public SignatureInfoSignature(final String signedInfoString, final byte[] signatureInfoDigest) {
        this.signedInfoString = signedInfoString;
        this.signatureInfoDigest = signatureInfoDigest;
    }

    public byte[] getSignatureInfoDigest() {
        return signatureInfoDigest;
    }

    public String getSignedInfoString() {
        return signedInfoString;
    }
}
