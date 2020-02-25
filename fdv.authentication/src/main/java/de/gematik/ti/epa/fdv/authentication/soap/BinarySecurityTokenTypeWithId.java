package de.gematik.ti.epa.fdv.authentication.soap;

import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.SoapPrimitive;

import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.gen.authentication.BinarySecurityTokenType;

/**
 * A security token supplemented by wsu:id
 */
public class BinarySecurityTokenTypeWithId extends BinarySecurityTokenType {
    private static final long serialVersionUID = 1597866559707010207L;

    private String id;

    @Override
    public Object getSimpleValue() {
        final SoapPrimitive primitive = (SoapPrimitive) super.getSimpleValue();

        if (id != null) {
            final AttributeInfo attrInfo = new AttributeInfo();
            attrInfo.setName("Id");
            attrInfo.setValue(id);
            attrInfo.setNamespace(Namespaces.WSU.getNamespaceUrl());
            primitive.addAttribute(attrInfo);
        }
        return primitive;
    }

    public void setId(final String tokenIdString) {
        id = tokenIdString;
    }
}
