package com.BootCamp38.model;

import java.net.URI;
import java.util.Objects;
import com.BootCamp38.model.ClientProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T16:37:41.514380-05:00[America/Lima]")
public class Client {

  @JsonProperty("clientId")
  private String clientId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("documentNumber")
  private String documentNumber;

  /**
   * Gets or Sets clientType
   */
  public enum ClientTypeEnum {
    NATURALPERSON("naturalPerson"),
    
    COMPANY("company");

    private String value;

    ClientTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ClientTypeEnum fromValue(String value) {
      for (ClientTypeEnum b : ClientTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("clientType")
  private ClientTypeEnum clientType;

  @JsonProperty("clientProduct")
  @Valid
  private List<ClientProduct> clientProduct = null;

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

  public Client clientType(ClientTypeEnum clientType) {
    this.clientType = clientType;
    return this;
  }

  /**
   * Get clientType
   * @return clientType
  */
  @NotNull 
  @Schema(name = "clientType", requiredMode = Schema.RequiredMode.REQUIRED)
  public ClientTypeEnum getClientType() {
    return clientType;
  }

  public void setClientType(ClientTypeEnum clientType) {
    this.clientType = clientType;
  }

  public Client clientProduct(List<ClientProduct> clientProduct) {
    this.clientProduct = clientProduct;
    return this;
  }

  public Client addClientProductItem(ClientProduct clientProductItem) {
    if (this.clientProduct == null) {
      this.clientProduct = new ArrayList<>();
    }
    this.clientProduct.add(clientProductItem);
    return this;
  }

  /**
   * Get clientProduct
   * @return clientProduct
  */
  @Valid 
  @Schema(name = "clientProduct", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<ClientProduct> getClientProduct() {
    return clientProduct;
  }

  public void setClientProduct(List<ClientProduct> clientProduct) {
    this.clientProduct = clientProduct;
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
        Objects.equals(this.clientProduct, client.clientProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, name, documentNumber, clientType, clientProduct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Client {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    documentNumber: ").append(toIndentedString(documentNumber)).append("\n");
    sb.append("    clientType: ").append(toIndentedString(clientType)).append("\n");
    sb.append("    clientProduct: ").append(toIndentedString(clientProduct)).append("\n");
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

