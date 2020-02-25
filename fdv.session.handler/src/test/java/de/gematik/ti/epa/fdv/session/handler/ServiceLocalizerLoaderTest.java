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

package de.gematik.ti.epa.fdv.session.handler;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import de.gematik.ti.epa.fdv.service.localization.spi.IServiceLocalizer;

/**
 * Test {@link ServiceLocalizerLoader}
 */
public class ServiceLocalizerLoaderTest {

    @Test
    public void testGetLocalizerLoaderInstance() {
        final ServiceLocalizerLoader loader = ServiceLocalizerLoader.getInstance();
        Assert.assertNotNull(loader);
    }

    @Test
    public void testGetServices() {
        final ServiceLocalizerLoader loader = ServiceLocalizerLoader.getInstance();
        final Collection<IServiceLocalizer> services = loader.getServices();
        Assert.assertNotNull(services);
    }
}
