package de.gematik.ti.epa.fdv.authentication.states;

import org.ksoap2.serialization.PropertyInfo;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenResponseType;
import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Enum for logout token states
 */
public enum LogoutTokenState {
    LOGOUT_TOKEN_SUCCESS,
    LOGOUT_TOKEN_FAILED;

    /**
     * Returns the actual state of LogoutToken response
     * @param response RequestSecurityTokenResponseType
     * @return state of LogoutToken response
     */
    public static LogoutTokenState getState(final RequestSecurityTokenResponseType response) {
        try {
            final PropertyInfo canceledPi = response.any.get(0);
            final String piName = canceledPi.name;
            if ("RequestedTokenCancelled".equals(piName)) {
                return LOGOUT_TOKEN_SUCCESS;
            }

        } catch (final Exception e) {
            throw new AuthenticateException("Logout token failed" + e);
        }
        return LOGOUT_TOKEN_FAILED;
    }

    /**
     * Validates the passed state
     *
     * @param state LogoutTokenState
     * @return result of validation
     */
    public Result<LogoutTokenState> validateState(final LogoutTokenState state) {
        if (this == state) {
            return Result.success(state);
        } else {
            return Result.failure(new AuthenticateException(String.format("LogoutTokenState: expected state: %s, but was: %s", this, state)));
        }
    }
}
