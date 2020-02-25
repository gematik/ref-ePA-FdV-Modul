package de.gematik.ti.epa.fdv.authentication.serialization;

import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.ValueWriter;
import org.xmlpull.v1.XmlSerializer;

/**
 * Class to encapsulate premarshalled xml output
 */
public class PreMarshalledPrimitive extends SoapPrimitive implements ValueWriter {

    public PreMarshalledPrimitive(final String namespace, final String name, final Object value) {
        super(namespace, name, value);
    }

    @Override
    public void write(final XmlSerializer xmlSerializer) {
        if (value instanceof String && xmlSerializer instanceof KxmlSerializerWithPreMarshalledXmlWriter) {
            ((KxmlSerializerWithPreMarshalledXmlWriter) xmlSerializer).writePreMarshalledXML((String) value);
        }
    }
}
