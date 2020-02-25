package de.gematik.ti.epa.fdv.authentication.states;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Enum for renew token states
 */
public enum RenewTokenState {
    RENEW_TOKEN_SUCCESS,
    UNABLE_TO_RENEW;

    /**
     * Returns the actual state of RenewToken response
     * @param assertion String
     * @return state of RenewToken response
     */
    public static RenewTokenState getState(final String assertion) {

        if (assertion.contains("Assertion")) {
            return RenewTokenState.RENEW_TOKEN_SUCCESS;
        }
        return RenewTokenState.UNABLE_TO_RENEW;
    }

    /**
     * Validates the passed state
     *
     * @param state RenewTokenState
     * @return result of validation
     */
    public Result<RenewTokenState> validateState(final RenewTokenState state) {
        if (this == state) {
            return Result.success(state);
        } else {
            return Result.failure(new AuthenticateException(String.format("RenewTokenState: expected state: %s, but was: %s", this, state)));
        }
    }

}
