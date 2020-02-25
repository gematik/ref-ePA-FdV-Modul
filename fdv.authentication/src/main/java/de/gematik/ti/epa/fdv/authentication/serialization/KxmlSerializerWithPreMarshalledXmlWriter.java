package de.gematik.ti.epa.fdv.authentication.serialization;

import java.io.IOException;
import java.io.Writer;

import org.kxml2.io.KXmlSerializer;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;

/**
 * Serializer for premarshalled xml output
 */
public class KxmlSerializerWithPreMarshalledXmlWriter extends KXmlSerializer {
    private Writer writer;

    @Override
    public void setOutput(final Writer writer) {
        this.writer = writer;
        super.setOutput(writer);
    }

    void writePreMarshalledXML(final String preMarshalledXml) {
        try {
            text("");
            writer.write(preMarshalledXml);
        } catch (final IOException e) {
            throw new AuthenticateException("Error on writing premarshalled xml: " + e);
        }
    }
}
