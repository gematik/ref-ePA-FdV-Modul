package de.gematik.ti.epa.fdv.authentication.states;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Enum for create token states
 */
public enum CreateTokenState {
    LOGIN_CREATE_TOKEN_SUCCESS,
    LOGIN_CREATE_TOKEN_FAILED;

    /**
     * Returns the actual state of login create token response
     *
     * @param result String
     * @return state of login create token response
     */
    public static CreateTokenState getState(final String result) {

        if (result.contains("Assertion")) {
            return CreateTokenState.LOGIN_CREATE_TOKEN_SUCCESS;
        } else {
            return CreateTokenState.LOGIN_CREATE_TOKEN_FAILED;
        }
    }

    /**
     * Validates the passed state
     *
     * @param state CreateTokenState
     * @return result of validation
     */
    public Result<CreateTokenState> validateState(final CreateTokenState state) {
        if (this == state) {
            return Result.success(state);
        } else {
            return Result.failure(new AuthenticateException(String.format("CreateTokenState: expected state: %s, but was: %s", this, state)));
        }
    }
}
