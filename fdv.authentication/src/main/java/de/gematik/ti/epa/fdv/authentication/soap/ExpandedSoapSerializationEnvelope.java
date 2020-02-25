package de.gematik.ti.epa.fdv.authentication.soap;

import java.io.IOException;
import java.util.UUID;

import org.xmlpull.v1.XmlSerializer;

import de.gematik.ti.epa.fdv.authentication.security.Namespaces;
import de.gematik.ti.epa.fdv.gen.authentication.ExtendedSoapSerializationEnvelope;

/**
 * Expanse the soap envelope with the namespaces used and add the wsu id attribute to the body element
 */
public class ExpandedSoapSerializationEnvelope extends ExtendedSoapSerializationEnvelope {
    private static final String XSI_URL = Namespaces.XSI.getNamespaceUrl();
    private static final String XSD_URL = Namespaces.XSD.getNamespaceUrl();
    private static final String ENC_URL = Namespaces.ENC.getNamespaceUrl();
    private static final String XML_URL = Namespaces.XML.getNamespaceUrl();
    private static final String SAML2_URL = Namespaces.SAML_2.getNamespaceUrl();
    private static final String WSU_URL = Namespaces.WSU.getNamespaceUrl();
    private static final String ENVELOPE = "Envelope";
    private static final String HEADER = "Header";
    private static final String BODY = "Body";

    private UUID uuid = null;

    /**
     * Constructor
     * @param version soap version
     */
    public ExpandedSoapSerializationEnvelope(final int version) {
        super(version);
        createClassesForAny = true;
        implicitTypes = true;
    }

    @Override
    public void write(final XmlSerializer writer) throws IOException {
        writer.setPrefix("xsi", XSI_URL);
        writer.setPrefix("xsd", XSD_URL);
        writer.setPrefix("enc", ENC_URL);
        writer.setPrefix("soap", env);
        writer.setPrefix("xml", XML_URL);
        writer.setPrefix("saml2", SAML2_URL);

        setNSPrefix(writer, Namespaces.WSU);
        setNSPrefix(writer, Namespaces.DS);
        setNSPrefix(writer, Namespaces.WSSE);
        setNSPrefix(writer, Namespaces.TRUST);
        setNSPrefix(writer, Namespaces.SAML_2);

        writer.startTag(env, ENVELOPE);
        writer.startTag(env, HEADER);
        writeHeader(writer);
        writer.endTag(env, HEADER);
        writer.startTag(env, BODY);
        if (uuid != null) {
            writer.attribute(WSU_URL, "Id", "id-" + uuid.toString());
        }
        writeBody(writer);
        writer.endTag(env, BODY);
        writer.endTag(env, ENVELOPE);
    }

    private void setNSPrefix(final XmlSerializer writer, final Namespaces ns) throws IOException {
        writer.setPrefix(ns.name(), ns.getNamespaceUrl());
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }
}
