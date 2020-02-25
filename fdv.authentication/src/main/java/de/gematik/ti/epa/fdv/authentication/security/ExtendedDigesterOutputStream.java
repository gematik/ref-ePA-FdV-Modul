package de.gematik.ti.epa.fdv.authentication.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.utils.DigesterOutputStream;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;

/**
 * Extends the class {@link DigesterOutputStream} to get the output stream
 */
public class ExtendedDigesterOutputStream extends DigesterOutputStream {

    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    /**
     * Constructor
     * @param algorithm MessageDigestAlgorithm
     */
    public ExtendedDigesterOutputStream(final MessageDigestAlgorithm algorithm) {
        super(algorithm);
    }

    @Override
    public void write(final int messageLength) {
        bos.write(messageLength);
        super.write(messageLength);
    }

    @Override
    public void write(final byte[] message, final int from, final int to) {
        try {
            final byte[] bytes = Arrays.copyOfRange(message, from, from + to);
            bos.write(bytes);
            super.write(message, from, to);
        } catch (final IOException e) {
            throw new AuthenticateException("Error on writing DigesterOutputStream" + e);
        }
    }

    public ByteArrayOutputStream getBos() {
        return bos;
    }
}
