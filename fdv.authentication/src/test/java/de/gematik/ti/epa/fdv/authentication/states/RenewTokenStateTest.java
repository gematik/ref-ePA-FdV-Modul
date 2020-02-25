package de.gematik.ti.epa.fdv.authentication.states;

import org.junit.Assert;
import org.junit.Test;

import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Test {@link RenewTokenState}
 */
public class RenewTokenStateTest {

    @Test
    public void renewTokenStateShouldBeSuccess() {
        final String assertion = "Assertion";
        final RenewTokenState state = RenewTokenState.getState(assertion);
        final Result<RenewTokenState> result = state.validateState(RenewTokenState.RENEW_TOKEN_SUCCESS);
        Assert.assertEquals(RenewTokenState.RENEW_TOKEN_SUCCESS, result.getOrNull());
    }

    @Test
    public void renewTokenStateShouldFail() {
        final RenewTokenState state = RenewTokenState.getState("");
        final Result<RenewTokenState> result = state.validateState(RenewTokenState.UNABLE_TO_RENEW);
        Assert.assertEquals(RenewTokenState.UNABLE_TO_RENEW, result.getOrNull());
    }
}
