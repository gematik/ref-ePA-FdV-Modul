package de.gematik.ti.epa.fdv.authentication.states;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ksoap2.serialization.PropertyInfo;

import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.gen.authentication.RequestSecurityTokenResponseType;
import de.gematik.ti.epa.fdv.gen.authentication.RequestedTokenCancelledType;
import de.gematik.ti.healthcardaccess.operation.Result;

/**
 * Test {@link LogoutTokenState}
 */
public class LogoutTokenStateTest {
    RequestSecurityTokenResponseType response;

    @Before
    public void fillResponse() {
        response = new RequestSecurityTokenResponseType();
        final PropertyInfo property = new PropertyInfo();
        final RequestedTokenCancelledType cancelled = new RequestedTokenCancelledType();
        property.setName("RequestedTokenCancelled");
        property.setValue(cancelled);
        response.any.add(property);
    }

    @Test
    public void logoutTokenStateShouldBeSuccess() {
        final LogoutTokenState state = LogoutTokenState.getState(response);
        final Result<LogoutTokenState> result = state.validateState(LogoutTokenState.LOGOUT_TOKEN_SUCCESS);
        Assert.assertEquals(LogoutTokenState.LOGOUT_TOKEN_SUCCESS, result.getOrNull());
    }

    @Test(expected = AuthenticateException.class)
    public void logoutTokenStateShouldFail() {
        response.any.clear();
        final LogoutTokenState state = LogoutTokenState.getState(response);
        final Result<LogoutTokenState> result = state.validateState(LogoutTokenState.LOGOUT_TOKEN_SUCCESS);
        Assert.assertEquals(LogoutTokenState.LOGOUT_TOKEN_FAILED, result.getOrNull());
    }
}
