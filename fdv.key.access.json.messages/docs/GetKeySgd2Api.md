# GetKeySgd2Api

All URIs are relative to *http://gltu1119.mgm1.telematik-test:9099/#*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listEciesKeySgd2**](GetKeySgd2Api.md#listEciesKeySgd2) | **POST** /sgd2 | List all response from aktorServer/SGD2 inclusive PublicEciesKey


<a name="listEciesKeySgd2"></a>
# **listEciesKeySgd2**
> SgdResponse listEciesKeySgd2(requestBody)

List all response from aktorServer/SGD2 inclusive PublicEciesKey

### Example
```java
// Import classes:
import de.gematik.ti.epa.fdv.key.access.gen.invoker.ApiClient;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.ApiException;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.Configuration;
import de.gematik.ti.epa.fdv.key.access.gen.invoker.models.*;
import de.gematik.ti.epa.fdv.key.access.gen.api.GetKeySgd2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://gltu1119.mgm1.telematik-test:9099/#");

    GetKeySgd2Api apiInstance = new GetKeySgd2Api(defaultClient);
    RequestBody requestBody = new RequestBody(); // RequestBody | 
    try {
      SgdResponse result = apiInstance.listEciesKeySgd2(requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GetKeySgd2Api#listEciesKeySgd2");
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

