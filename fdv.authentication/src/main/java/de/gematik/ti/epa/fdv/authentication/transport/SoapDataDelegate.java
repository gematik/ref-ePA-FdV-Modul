package de.gematik.ti.epa.fdv.authentication.transport;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.transport.ServiceConnection;
import org.ksoap2.transport.Transport;
import org.xmlpull.v1.XmlSerializer;

import de.gematik.ti.epa.fdv.authentication.serialization.KxmlSerializerWithPreMarshalledXmlWriter;
import de.gematik.ti.epa.fdv.gen.authentication.ExtendedSoapSerializationEnvelope;

/**
 * Expanse the Transport class to add further parameters to the soap requests
 */
public class SoapDataDelegate extends Transport {

    private static final int DEFAULT_CONTENT_LENGTH = 262144;
    private static final int BUFFER_LENGTH = 256;

    private String xmlVersionTag;
    private String responseString;

    /**
     * Constructor
     */
    public SoapDataDelegate() {
        xmlVersionTag = "";
    }

    @Override
    public void setXmlVersionTag(final String tag) {
        xmlVersionTag = tag;
    }

    @Override
    public List call(final String s, final SoapEnvelope soapEnvelope, final List list) {
        return null; // NOCS(SAB): instances of this class are using not all implemented methods from super class
    }

    @Override
    public List call(final String s, final SoapEnvelope soapEnvelope, final List list, final File file) { // NOCS(SAB): overrides super method
        return null; // NOCS(SAB): instances of this class are using not all implemented methods from super class
    }

    @Override
    public ServiceConnection getServiceConnection() {
        return null;
    }

    byte[] createRequestData(final SoapEnvelope envelope, final String encoding, final Map prefixes) throws IOException {
        try (final ByteArrayOutputStream bos = new ByteArrayOutputStream(DEFAULT_CONTENT_LENGTH)) {
            bos.write(xmlVersionTag.getBytes());
            final XmlSerializer xw = new KxmlSerializerWithPreMarshalledXmlWriter();
            final Iterator keysIter = prefixes.keySet().iterator();
            xw.setOutput(bos, encoding);

            while (keysIter.hasNext()) {
                final String key = (String) keysIter.next();
                xw.setPrefix(key, (String) prefixes.get(key));
            }

            envelope.write(xw);
            xw.flush();
            bos.write(0x0D);
            bos.write(0x0A);
            bos.flush();
            return bos.toByteArray();
        }
    }

    InputStream parseResponse(final InputStream is, final List returnedHeaders) throws IOException {
        responseString = null;
        final Charset charset;
        charset = getCharset(returnedHeaders);
        final int contentLength = getContentLength(returnedHeaders);
        return readInput(is, contentLength, charset);
    }

    private Charset getCharset(final List returnedHeaders) {
        Charset charset = null;
        if (!returnedHeaders.isEmpty()) {
            for (final Object returnedHeader : returnedHeaders) {
                final HeaderProperty hp = (HeaderProperty) returnedHeader;
                if (hp.getKey() != null && "Content-Type".equalsIgnoreCase(hp.getKey())) {
                    final String contentType = hp.getValue().toLowerCase();
                    if (contentType.contains("utf-8")) {
                        charset = StandardCharsets.UTF_8;
                    } else if (contentType.contains("utf-16")) {
                        charset = StandardCharsets.UTF_16;
                    }
                }
            }
        }
        return charset;
    }

    private int getContentLength(final List returnedHeaders) {
        int contentLength = 0;
        if (!returnedHeaders.isEmpty()) {
            for (final Object returnedHeader : returnedHeaders) {
                final HeaderProperty hp = (HeaderProperty) returnedHeader;
                if (hp.getKey() != null && "content-length".equalsIgnoreCase(hp.getKey())) {
                    contentLength = Integer.parseInt(hp.getValue());
                }
            }
        }
        return contentLength;
    }

    private InputStream readInput(final InputStream is, final int contentLength, final Charset charset) throws IOException {
        byte[] buf = new byte[BUFFER_LENGTH];

        try (final ByteArrayOutputStream bos = new ByteArrayOutputStream(contentLength > 0 ? contentLength : DEFAULT_CONTENT_LENGTH)) {
            while (true) {
                final int rd = is.read(buf, 0, BUFFER_LENGTH);
                if (rd == -1) {
                    bos.flush();
                    buf = bos.toByteArray();
                    readEncodedResponseString(charset, buf);
                    is.close();
                    return new ByteArrayInputStream(buf);
                }
                bos.write(buf, 0, rd);
            }
        }
    }

    private void readEncodedResponseString(final Charset charset, final byte[] buf) {
        if (charset != null) {
            responseString = new String(buf, charset);
        } else {
            responseString = new String(buf);
        }
    }

    public String getResponseString() {
        return responseString;
    }

    public byte[] generateRequestData(final ExtendedSoapSerializationEnvelope envelope) throws IOException {
        return super.createRequestData(envelope, "UTF-8");
    }
}
