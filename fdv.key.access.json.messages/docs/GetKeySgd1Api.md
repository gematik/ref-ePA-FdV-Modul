# GetKeySgd1Api

All URIs are relative to *http://gltu1119.mgm1.telematik-test:9099/#*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listEciesKeySgd1**](GetKeySgd1Api.md#listEciesKeySgd1) | **POST** /sgd1 | List all from aktorServer/SGD1 inclusive PublicEciesKey


<a name="listEciesKeySgd1"></a>
# **listEciesKeySgd1**
> SgdResponse listEciesKeySgd1(requestBody)

List all from aktorServer/SGD1 inclusive PublicEciesKey

### Example
```java
// Import classes:
import de.gematik.ti.epa.fdv.key.access.gen.invoker.ApiClient;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.ApiException;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.Configuration;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.models.*;
import de.gematik.ti.epa.fdv.key.access.gen.api.GetKeySgd1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://gltu1119.mgm1.telematik-test:9099/#");

    GetKeySgd1Api apiInstance = new GetKeySgd1Api(defaultClient);
    RequestBody requestBody = new RequestBody(); // RequestBody | 
    try {
      SgdResponse result = apiInstance.listEciesKeySgd1(requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GetKeySgd1Api#listEciesKeySgd1");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestBody** | [**RequestBody**](RequestBody.md)|  | [optional]

### Return type

[**SgdResponse**](SgdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**0** | default response |  -  |

