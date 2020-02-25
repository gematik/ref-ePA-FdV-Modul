package de.gematik.ti.epa.fdv.authentication.transport;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

import com.easywsdl.exksoap2.ws_specifications.addressing.WSAddressingImplementation;
import com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile;

/**
 * Expanse the AdvancedHttpsTransportSE class to add further parameters to the soap requests
 */
public class AdvancedHttpsTransportSe extends com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE {
    private final SoapDataDelegate delegate;
    private final WSAddressingImplementation wsAddressingImplementation = new WSAddressingImplementation();

    /**
     * Constructor
     * @param delegate SoapDataDelegate
     * @param host String
     * @param port int
     * @param path String
     * @param timeOut int
     */
    public AdvancedHttpsTransportSe(final SoapDataDelegate delegate, final String host, final int port, final String path, final int timeOut) { // NOCS(SAB):
        super(host, port, path, timeOut);
        this.delegate = delegate;
    }

    @Override
    protected byte[] createRequestData(final SoapEnvelope envelope, final String encoding) throws IOException { // NOCS(SAB): overrides super method
        wsAddressingImplementation.Apply(envelope);
        return delegate.createRequestData(envelope, encoding, super.getPrefixes());
    }

    @Override
    public void setXmlVersionTag(final String tag) { // NOCS(SAB): overrides super method
        delegate.setXmlVersionTag(tag);
        super.setXmlVersionTag(tag);
    }

    @Override
    public List call(final String soapAction, final SoapEnvelope envelope, final List headers, final File outputFile, final WS_Profile profile)
            throws IOException, XmlPullParserException { // NOCS(SAB): overrides super method
        wsAddressingImplementation.setWSProfile(profile);

        try {
            if (envelope.version == 120 && soapAction != null) {
                headers.add(new HeaderProperty("Content-Type", "application/soap+xml;charset=utf-8;" + "action=\"" + soapAction + "\""));
            }

            return super.call(soapAction, envelope, headers, outputFile);
        } finally {
            wsAddressingImplementation.setWSProfile(null);
        }
    }

    @Override
    protected void parseResponse(final SoapEnvelope envelope, final InputStream is, final List returnedHeaders) throws XmlPullParserException, IOException { // NOCS(SAB):
        final InputStream decodedInputStream = delegate.parseResponse(is, returnedHeaders);
        super.parseResponse(envelope, decodedInputStream);
    }
}
