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

package de.gematik.ti.epa.fdv.service.localization.spi;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.gematik.ti.epa.fdv.service.localization.api.LookupStatus;
import de.gematik.ti.epa.fdv.service.localization.spi.IServiceLocalizer;

public class ServiceLocalizerTest {

    private final de.gematik.ti.epa.fdv.service.localization.spi.IServiceLocalizer serviceLocalizer = Mockito.mock(IServiceLocalizer.class);

    @Test
    public void getLookupStatus() {
        Mockito.when(serviceLocalizer.getLookupStatus()).thenReturn(LookupStatus.ERROR);
        Assert.assertEquals(LookupStatus.ERROR, serviceLocalizer.getLookupStatus());
    }
}
