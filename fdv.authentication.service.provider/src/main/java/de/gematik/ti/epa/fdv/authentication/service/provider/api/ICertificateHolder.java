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

package de.gematik.ti.epa.fdv.authentication.service.provider.api;

/**
 * A abstraction of object with required certificate and keys
 * Required is a random-generator in T-type. (for instance, challenge in case of healthCard).
 *
 * @param <T>
 * 
 */
public interface ICertificateHolder<T> {

    /**
     * Type T could be a IHealthCard or any other object which has the required certificate and keys for purpose of authentication.
     */
    T getAuthRenderer();
}
