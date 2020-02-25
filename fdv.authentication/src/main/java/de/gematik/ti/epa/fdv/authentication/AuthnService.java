/*
 * Copyright (c) 2020 gematik GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.gematik.ti.epa.fdv.authentication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.*;

import org.greenrobot.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gematik.ti.epa.fdv.authentication.event.AuthnProviderSelectionProvider;
import de.gematik.ti.epa.fdv.authentication.event.RequestSelectAuthenticatorEvent;
import de.gematik.ti.epa.fdv.authentication.exceptions.AuthenticateException;
import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;

/**
 * supply all available {@link IAuthenticator} and the selected one.
 */
public class AuthnService {

    private static final long TIMEOUT = 30;
    private static final Logger LOG = LoggerFactory.getLogger(AuthnService.class);
    /**
     * save the selected authenticator for use next time
     */
    private IAuthenticator selectedAuthnProvider = null;

    private final List<IAuthenticator> listAuthn = new ArrayList<>();

    /**
     * Constructor
     */
    public AuthnService() {
        final Iterator<IAuthenticator> iterator = ServiceLoader.load(IAuthenticator.class).iterator();
        iterator.forEachRemaining(listAuthn::add);
    }

    /**
     * available authenticator
     * @return List
     */
    public List<IAuthenticator> getAvailableAuthenticationProvider() {
        return listAuthn;
    }

    public IAuthenticator getAuthenticationProvider() {
        if (selectedAuthnProvider != null) {
            LOG.debug("Found selectedAuthnProvider: " + selectedAuthnProvider);
            return selectedAuthnProvider;
        }
        LOG.debug("Found listAuthn: " + listAuthn + " and selectedAuthnProvider: " + selectedAuthnProvider);

        if (selectedAuthnProvider == null && listAuthn.size() > 1) {
            final ExecutorService executor = Executors.newSingleThreadExecutor();
            final AuthnProviderSelectionProvider authnProviderSelectionProvider = new AuthnProviderSelectionProvider();
            EventBus.getDefault().post(new RequestSelectAuthenticatorEvent(authnProviderSelectionProvider, listAuthn));
            final Future<IAuthenticator> future = executor.submit(authnProviderSelectionProvider);
            executor.shutdown();
            try {
                selectedAuthnProvider = future.get(TIMEOUT, TimeUnit.SECONDS);
            } catch (final TimeoutException | InterruptedException | ExecutionException e) {
                future.cancel(true);
                throw new AuthenticateException(e);
            }
        }
        if (selectedAuthnProvider == null && listAuthn.size() == 1) {
            selectedAuthnProvider = listAuthn.get(0);
            return selectedAuthnProvider;
        }
        throw new AuthenticateException("No authenticator available.");
    }

    /**
     * a listener for handling selectedAuth
     */
    // private class AuthnProviderSelectionProvider implements IAuthnProviderSelectionListener{
    // @Override
    // public void handleSelectedAuthnProvider(IAuthenticator authnSelect) {
    // AuthnService.this.selectedAuthnProvider = authnSelect;
    // }
    // }
}
