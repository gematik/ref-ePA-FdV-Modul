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

package de.gematik.ti.epa.fdv.authentication.event;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;

/**
 * a listener for handling selectedAuth
 */
public class AuthnProviderSelectionProvider implements Callable<IAuthenticator>, IAuthnProviderSelectionListener {
    private static final Logger LOG = LoggerFactory.getLogger(AuthnProviderSelectionProvider.class);

    private final ArrayBlockingQueue<IAuthenticator> queue = new ArrayBlockingQueue<>(1);

    @Override
    public IAuthenticator call() throws Exception {
        return queue.take();
    }

    @Override
    public void handleSelectedAuthnProvider(final IAuthenticator authnSelect) {
        try {
            queue.put(authnSelect);
        } catch (final InterruptedException e) {
            LOG.error("Error on handling selected authentication provider" + e);
            Thread.currentThread().interrupt();
        }
    }
}
