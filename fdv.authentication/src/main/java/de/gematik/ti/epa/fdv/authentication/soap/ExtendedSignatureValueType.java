package de.gematik.ti.epa.fdv.authentication.soap;

import java.util.Base64;

import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.SoapPrimitive;

import de.gematik.ti.epa.fdv.authentication.security.Namespaces;

/**
 * Extends the signature value by the Id attribute and ds namespace
 */
public class ExtendedSignatureValueType extends de.gematik.ti.epa.fdv.gen.authentication.SignatureValueType {
    private static final long serialVersionUID = -3187047296238803820L;

    @Override
    public Object getSimpleValue() {
        Object encodedValue = "";
        if (value != null) {
            encodedValue = Base64.getEncoder().encodeToString(value);
        }
        final SoapPrimitive primitive = new SoapPrimitive(Namespaces.DS.getNamespaceUrl(), "value", encodedValue);

        if (Id != null) {
            final AttributeInfo attrInfo = new AttributeInfo();
            attrInfo.setName("Id");
            attrInfo.setValue(Id);
            attrInfo.setNamespace("");
            primitive.addAttribute(attrInfo);
        }
        return primitive;
    }
}
