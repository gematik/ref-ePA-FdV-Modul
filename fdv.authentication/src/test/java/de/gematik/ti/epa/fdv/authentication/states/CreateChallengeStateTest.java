package de.gematik.ti.epa.fdv.authentication.states;

import org.junit.Assert;
import org.junit.Test;

import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Test {@link CreateChallengeState}
 */
public class CreateChallengeStateTest {

    @Test
    public void createChallengeStateShouldBeSuccess() {
        final CreateChallengeState state = CreateChallengeState.getState("Challenge");
        final Result<CreateChallengeState> result = state.validateState(CreateChallengeState.LOGIN_CREATE_CHALLENGE_SUCCESS);
        Assert.assertEquals(CreateChallengeState.LOGIN_CREATE_CHALLENGE_SUCCESS, result.getOrNull());

    }

    @Test
    public void createChallengeStateShouldFail() {
        final CreateChallengeState state = CreateChallengeState.getState(null);
        final Result<CreateChallengeState> result = state.validateState(CreateChallengeState.LOGIN_CREATE_CHALLENGE_FAILED);
        Assert.assertEquals(CreateChallengeState.LOGIN_CREATE_CHALLENGE_FAILED, result.getOrNull());
    }
}
