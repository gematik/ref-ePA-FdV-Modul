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

import java.util.List;

import de.gematik.ti.epa.fdv.authentication.service.provider.api.IAuthenticator;

/**
 * a event for EventBus to post
 */
public class RequestSelectAuthenticatorEvent {

    private final List<IAuthenticator> listAuthn;
    private IAuthnProviderSelectionListener listner;

    public RequestSelectAuthenticatorEvent(final List<IAuthenticator> list) {
        listAuthn = list;
    }

    public RequestSelectAuthenticatorEvent(final IAuthnProviderSelectionListener authnProviderSelectionProvider,
            final List<IAuthenticator> listAuthn) {
        listner = authnProviderSelectionProvider;
        this.listAuthn = listAuthn;
    }

    public List<IAuthenticator> getListAuthn() {
        return listAuthn;
    }

    public IAuthnProviderSelectionListener getListener() {
        return listner;
    }
}
