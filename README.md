# FdV Module Java Libraries

## Introduction

This part describes the ePA FdV Modul functionalities and structure.

## API Documentation

Generated API docs are available at <https://gematik.github.io/ref-FdVModul>.

## License

Licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Overview

The FdV module bundles libraries that provide the functions (service localization, authentication, authorization, session handling, key access) necessary for the use of the electronic patient record.

![FdV Modul overview](docs/images/generated/ref-epa-fdv-modul.png)

  

### FdV Authentication

The authentication module provides the functionalities for authenticating the user to use the electronic patient record.
All available IAuthenticator and the selected one will be returned by the AuthnService.
The Authn class enforces required operations (login create challenge / login create token / renew token / logout token) according to ws-Trust to authenticate the user.
The AuthenticationBindingSoap class forms the entry point for establishing the connection to the authentication web service.

![FdV Authentication structure](docs/images/authn/generated/authentication.png)

  

### FdV Authorization

The authorization module is not yet implemented

![ePA Authorization structure](docs/images/authz/generated/authorization.png)

  

### FdV Key Access

The key access module is not yet implemented

![ePA Key Access structure](docs/images/eka/generated/access.png)

  

### FdV Session Handler

The FdV SessionHandler module provides a ServiceLocalizerLoader for available service localization services.

![FdV Session Handler structure](docs/images/esh/generated/handler.png)

  

### Service Localization API

![ePA Service Localization API](docs/images/elsapi/generated/api.png)

  

#### IService Localizer

Interface to be implemented by service localizer as entry point to localize ePA service components.
Start lookup DNS for retrieving endpoint URLs of various ePA gateway services.
Once lookup has been done successfully, endpoint URLs for interfaces in ServiceInterfaceName can be retrieved.

![IServiceLocalizer](docs/images/elsapi/generated/spi.png)

  

The specific service localization needs a descriptor behind `YOUR.service.localization\src\main\resources\META-INF\services` with filename
`de.gematik.ti.fdv.epa.service.localization.spi.IServiceLocalizer` and the content of the package and class which implements the service localizer interface e.g. `de.gematik.ti.fdv.epa.service.localization.ServiceLocator`

![File META-INF services](docs/images/eslapi/generated/MetaInfServices.png)

#### ServiceInterfaceName

Description of the service interfaces and assignments of paths to the ePA file system components

#### LookupStatus

Status of service lookup in DNS - As long as the Service lookup is running, thus it might still in progress after ServiceLocatorType object has been initialized, or lookup was not successful for some reason, e.g. DNS was not accessible

![ServiceInterfaceName / LookupStatus](docs/images/eslapi/generated/api.png)

  

### Authentication Service Provider

![ePA Authentication Service Provider](docs/images/AUTHNSPI/generated/fdv.authentication.service.provider.png)

  

### Authentication Service Provider Interface

The entry point for the ServiceLoader is the Authentication Service Provider Interface.
This Interface returns the specific authentication provider implementation and a provider description.

![IAuthenticationProvider](docs/images/AUTHNSPI/generated/spi.png)

  

The specific authentication.provider needs a descriptor behind `YOUR.PROVIDER\src\main\resources\META-INF\services` with filename
`de.gematik.ti.fdv.authentication.service.provider.api.IAuthenticator` and the content of the package and class which implements the service provider interface e.g. `de.gematik.ti.epa.fdv.healthcard.authentication.Authenticator`

![File META-INF services](docs/images/AUTHNSPI/MetaInfServices.png)

## Getting Started

### Build setup FdV Module

To use ePA FdV Modul library in a project, you need just to include following dependency:

**Gradle dependency settings to use ePA FdV Modul library.**

    dependencies {
        implementation group: 'de.gematik.ti.epa', name: 'fdv.authentication', version: '1.0.1'
    }

**Maven dependency settings to use ePA FdV Modul library.**

    <dependencies>
        <dependency>
            <groupId>de.gematik.ti.epa</groupId>
            <artifactId>fdv.authentication</artifactId>
            <version>1.0.1</version>
        </dependency>
    </dependencies>
