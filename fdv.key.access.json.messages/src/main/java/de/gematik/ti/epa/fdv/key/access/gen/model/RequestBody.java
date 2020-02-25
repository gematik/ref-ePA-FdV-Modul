/*
 * ePA KeyAccess
 * REST Schnittstelle der SGD Server für den Keyaccess
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.gematik.ti.epa.fdv.key.access.gen.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RequestBody
 */

public class RequestBody {
  public static final String SERIALIZED_NAME_COMMAND = "Command";
  @SerializedName(SERIALIZED_NAME_COMMAND)
  private String command;

  public static final String SERIALIZED_NAME_CERTIFICATE = "Certificate";
  @SerializedName(SERIALIZED_NAME_CERTIFICATE)
  private String certificate;

  public static final String SERIALIZED_NAME_OC_S_P_RESPONSE = "OCSPResponse";
  @SerializedName(SERIALIZED_NAME_OC_S_P_RESPONSE)
  private String ocSPResponse;


  public RequestBody command(String command) {
    
    this.command = command;
    return this;
  }

   /**
   * Get command
   * @return command
  **/
  @ApiModelProperty(required = true, value = "")

  public String getCommand() {
    return command;
  }



  public void setCommand(String command) {
    this.command = command;
  }


  public RequestBody certificate(String certificate) {
    
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @ApiModelProperty(required = true, value = "")

  public String getCertificate() {
    return certificate;
  }



  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }


  public RequestBody ocSPResponse(String ocSPResponse) {
    
    this.ocSPResponse = ocSPResponse;
    return this;
  }

   /**
   * Get ocSPResponse
   * @return ocSPResponse
  **/
  @ApiModelProperty(required = true, value = "")

  public String getOcSPResponse() {
    return ocSPResponse;
  }



  public void setOcSPResponse(String ocSPResponse) {
    this.ocSPResponse = ocSPResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestBody requestBody = (RequestBody) o;
    return Objects.equals(this.command, requestBody.command) &&
        Objects.equals(this.certificate, requestBody.certificate) &&
        Objects.equals(this.ocSPResponse, requestBody.ocSPResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, certificate, ocSPResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestBody {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    ocSPResponse: ").append(toIndentedString(ocSPResponse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

