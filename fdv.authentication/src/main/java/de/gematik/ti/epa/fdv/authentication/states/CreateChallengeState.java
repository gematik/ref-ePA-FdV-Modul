package de.gematik.ti.epa.fdv.authentication.states;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Enum for create challenge states
 */
public enum CreateChallengeState {
    LOGIN_CREATE_CHALLENGE_SUCCESS,
    LOGIN_CREATE_CHALLENGE_FAILED;

    /**
     * Returns the actual state of login create challenge response
     * @param challenge extracted challenge value
     * @return state of login create challenge response
     */
    public static CreateChallengeState getState(final String challenge) {

        if (challenge != null) {
            return CreateChallengeState.LOGIN_CREATE_CHALLENGE_SUCCESS;
        } else {
            return CreateChallengeState.LOGIN_CREATE_CHALLENGE_FAILED;
        }
    }

    /**
     * Validates the passed state
     * @param state CreateChallengeState
     * @return result of validation
     */
    public Result<CreateChallengeState> validateState(final CreateChallengeState state) {
        if (this == state) {
            return Result.success(state);
        } else {
            return Result.failure(new AuthenticateException(String.format("CreateChallengeState: expected state: %s, but was: %s", this, state)));
        }
    }
}
