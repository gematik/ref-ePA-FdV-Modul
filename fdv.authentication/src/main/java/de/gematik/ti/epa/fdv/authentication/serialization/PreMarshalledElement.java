package de.gematik.ti.epa.fdv.authentication.serialization;

import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlSerializer;

/**
 * Class to encapsulate premarshalled xml output
 */
public class PreMarshalledElement extends Element {
    private String preMarshalledXml = null;

    @Override
    public void write(final XmlSerializer writer) {
        if (preMarshalledXml != null && writer instanceof KxmlSerializerWithPreMarshalledXmlWriter) {
            ((KxmlSerializerWithPreMarshalledXmlWriter) writer).writePreMarshalledXML(preMarshalledXml);
        }
    }

    public void setPreMarshalledXml(final String preMarshalledXml) {
        this.preMarshalledXml = preMarshalledXml;
    }
}
