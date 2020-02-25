package de.gematik.ti.epa.fdv.service.localization.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class ServiceLocatorExceptionTest {

    private final String myErrorMessage = "My Error Message";

    @Test
    public void testServiceLocatorException() {
        final ServiceLocatorException exception = new ServiceLocatorException(myErrorMessage);
        Assert.assertEquals(myErrorMessage, exception.getMessage());
    }

    @Test
    public void testServiceLocatorException2() {
        final Exception e = new RuntimeException();
        final ServiceLocatorException exception = new ServiceLocatorException(myErrorMessage, e);
        Assert.assertEquals(myErrorMessage, exception.getMessage());
        Assert.assertEquals(e, exception.getCause());
    }
}
