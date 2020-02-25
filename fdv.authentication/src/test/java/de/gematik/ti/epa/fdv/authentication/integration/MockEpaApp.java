package de.gematik.ti.epa.fdv.authentication.integration;

import java.util.List;

import org.greenrobot.eventbus.Subscribe;

import de.gematik.ti.epa.fdv.authentication.event.RequestSelectAuthenticatorEvent;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;

/**
 * simulate epaApp to react to coming event
 */
public class MockEpaApp {

    private static final int MY_SELECTION = 0;

    @Subscribe
    public void handleSelectAuthnProvider(final RequestSelectAuthenticatorEvent requestSelectAuthenticatorEvent) {
        final List<IAuthenticator> listAuthn = requestSelectAuthenticatorEvent.getListAuthn();
        requestSelectAuthenticatorEvent.getListener().handleSelectedAuthnProvider(listAuthn.get(MY_SELECTION));
    }
}
