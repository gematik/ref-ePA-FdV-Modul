package de.gematik.ti.epa.fdv.authentication.exceptions;

/**
 * Special exception on handling with authentication
 *
 */
public class AuthenticateException extends RuntimeException {
    private static final long serialVersionUID = -6852755085833726801L;

    public AuthenticateException(final String error) {
        super(error);
    }

    public AuthenticateException(final Exception e) {
        super(e);
    }
}
