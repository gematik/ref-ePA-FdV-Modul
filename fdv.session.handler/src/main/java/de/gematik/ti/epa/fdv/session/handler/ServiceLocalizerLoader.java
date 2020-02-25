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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;

import de.gematik.ti.epa.fdv.service.localization.spi.IServiceLocalizer;

/**
 * ServiceLocalizerLoader for localization services
 */
public final class ServiceLocalizerLoader {

    private static ServiceLocalizerLoader instance;

    private ServiceLocalizerLoader() {
    }

    /**
     * Get the singleton instance
     * @return singleton instance of ServiceLocalizerLoader
     */
    public static synchronized ServiceLocalizerLoader getInstance() {
        if (instance == null) {
            instance = new ServiceLocalizerLoader();
        }
        return instance;
    }

    /**
     * Create a collection with localization services
     * @return collection of localization services
     */
    public synchronized Collection<IServiceLocalizer> getServices() {
        final List<IServiceLocalizer> services = new ArrayList<>();

        final ServiceLoader<IServiceLocalizer> loader = ServiceLoader.load(IServiceLocalizer.class);
        loader.forEach(services::add);

        return services;
    }

    /**
     * Check if service localizer found by the service loader
     * @return service localizer found
     */
    public synchronized boolean serviceLocalizerAvailable() {
        return !getServices().isEmpty();
    }
}
