package de.gematik.ti.epa.fdv.authentication.states;

import org.junit.Assert;
import org.junit.Test;

import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Test {@link CreateTokenState}
 */
public class CreateTokenStateTest {

    @Test
    public void createTokenStateShouldBeSuccess() {
        final String assertion = "Assertion";
        final CreateTokenState state = CreateTokenState.getState(assertion);
        final Result<CreateTokenState> validationResult = state.validateState(CreateTokenState.LOGIN_CREATE_TOKEN_SUCCESS);
        Assert.assertEquals(CreateTokenState.LOGIN_CREATE_TOKEN_SUCCESS, validationResult.getOrNull());
    }

    @Test
    public void createTokenStateShouldFail() {
        final CreateTokenState state = CreateTokenState.getState("");
        final Result<CreateTokenState> validationResult = state.validateState(CreateTokenState.LOGIN_CREATE_TOKEN_FAILED);
        Assert.assertEquals(CreateTokenState.LOGIN_CREATE_TOKEN_FAILED, validationResult.getOrNull());
    }
}
