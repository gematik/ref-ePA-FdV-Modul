package de.gematik.ti.epa.fdv.authentication.soap;

import de.gematik.ti.epa.fdv.authentication.serialization.IPreMarshalledXmlSerializable;
import de.gematik.ti.epa.fdv.gen.authentication.SignatureType;

/**
 * Extends signatureType class with premarshalled signedInfo string
 */
public class SignatureTypeWithSignedInfoString extends SignatureType {
    private static final long serialVersionUID = -2008435096362254931L;
    private String signedInfoString = null;

    static class PreMarshalledSignedInfo implements IPreMarshalledXmlSerializable {
        private final String preMarshalledSignedInfoString;

        PreMarshalledSignedInfo(final String signedInfo) {
            preMarshalledSignedInfoString = signedInfo;
        }

        @Override
        public String toString() {
            return preMarshalledSignedInfoString;
        }
    }

    @Override
    public java.lang.Object getProperty(final int propertyIndex) {
        if (propertyIndex == 0 && signedInfoString != null) {
            return new PreMarshalledSignedInfo(signedInfoString);
        } else {
            return super.getProperty(propertyIndex);
        }
    }

    public void setSignedInfoString(final String signedInfoString) {
        this.signedInfoString = signedInfoString;
    }
}
