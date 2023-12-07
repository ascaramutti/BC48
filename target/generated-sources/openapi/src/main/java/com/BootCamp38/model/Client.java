package com.BootCamp38.model;

import java.net.URI;
import java.util.Objects;
import com.BootCamp38.model.ClientProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Client
 */
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-07T15:54:48.392513-05:00[America/Lima]")
public class Client {

  @JsonProperty("clientId")
  private String clientId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("documentNumber")
  private String documentNumber;

  @JsonProperty("clientType")
  private String clientType;

  @JsonProperty("clientProducts")
  @Valid
  private List<ClientProduct> clientProducts = null;

  public Client clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Get clientId
   * @return clientId
  */
  
  @Schema(name = "clientId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public Client name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Client documentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  /**
   * Get documentNumber
   * @return documentNumber
  */
  @NotNull 
  @Schema(name = "documentNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public Client clientType(String clientType) {
    this.clientType = clientType;
    return this;
  }

  /**
   * Get clientType
   * @return clientType
  */
  @NotNull 
  @Schema(name = "clientType", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getClientType() {
    return clientType;
  }

  public void setClientType(String clientType) {
    this.clientType = clientType;
  }

  public Client clientProducts(List<ClientProduct> clientProducts) {
    this.clientProducts = clientProducts;
    return this;
  }

  public Client addClientProductsItem(ClientProduct clientProductsItem) {
    if (this.clientProducts == null) {
      this.clientProducts = new ArrayList<>();
    }
    this.clientProducts.add(clientProductsItem);
    return this;
  }

  /**
   * Get clientProducts
   * @return clientProducts
  */
  @Valid 
  @Schema(name = "clientProducts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<ClientProduct> getClientProducts() {
    return clientProducts;
  }

  public void setClientProducts(List<ClientProduct> clientProducts) {
    this.clientProducts = clientProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(this.clientId, client.clientId) &&
        Objects.equals(this.name, client.name) &&
        Objects.equals(this.documentNumber, client.documentNumber) &&
        Objects.equals(this.clientType, client.clientType) &&
        Objects.equals(this.clientProducts, client.clientProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, name, documentNumber, clientType, clientProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Client {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    documentNumber: ").append(toIndentedString(documentNumber)).append("\n");
    sb.append("    clientType: ").append(toIndentedString(clientType)).append("\n");
    sb.append("    clientProducts: ").append(toIndentedString(clientProducts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

