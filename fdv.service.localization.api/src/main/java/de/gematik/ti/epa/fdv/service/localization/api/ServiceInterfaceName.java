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

package de.gematik.ti.epa.fdv.service.localization.api;

/**
 * include::{userguide}/FDVMODUL_Overview.adoc[tag=IServiceLocalizer]
 *
 */
public enum ServiceInterfaceName {
    I_AUTHENTICATION_INSURANT("I_Authentication_Insurant", "authn"),
    I_AUTHORIZATION_INSURANT("I_Authorization_Insurant", "authz"),
    I_AUTHORIZATION_MANAGEMENT_INSURANT("I_Authorization_Management_Insurant", "authz"),
    I_ACCOUNT_MANAGEMENT_INSURANT("I_Account_Management_Insurant", "docv"),
    I_DOCUMENT_MANAGEMENT_CONNECT("I_Document_Management_Connect", "docv"),
    I_DOCUMENT_MANAGEMENT_INSURANT("I_Document_Management_Insurant", "docv"),
    IOCSP_STATUS_INFORMATION("I_OCSP_Status_Information", "ocspf"),
    I_PROXY_DIRECTORY_QUERY("I_Proxy_Directory_Query", "avzd"),
    I_GET_KEY_SGD_1("", "sgd1"),
    I_GET_KEY_SGD_2("", "sgd2");

    private final String serviceLocatorName;
    private final String moduleName;

    ServiceInterfaceName(final String serviceLocatorName, final String moduleName) {
        this.serviceLocatorName = serviceLocatorName;
        this.moduleName = moduleName;
    }

    /**
     * Getter for service interface name
     * @return service interface name
     */
    public String getServiceLocatorName() {
        return serviceLocatorName;
    }

    /**
     * Getter for module name
     * @return module name
     */
    public String getModuleName() {
        return moduleName;
    }
}
