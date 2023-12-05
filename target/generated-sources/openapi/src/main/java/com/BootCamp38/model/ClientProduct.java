package com.BootCamp38.model;

import java.net.URI;
import java.util.Objects;
import com.BootCamp38.model.HolderAndSigner;
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
 * ClientProduct
 */
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T16:37:41.514380-05:00[America/Lima]")
public class ClientProduct {

  @JsonProperty("clientProductId")
  private String clientProductId;

  /**
   * Gets or Sets typeProduct
   */
  public enum TypeProductEnum {
    SAVINGS("savings"),
    
    CHECKING("checking"),
    
    FIXEDTERM("fixedTerm"),
    
    INDIVIDUAL("individual"),
    
    BUSINESS("business"),
    
    CREDITCARD("creditCard");

    private String value;

    TypeProductEnum(String value) {
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
    public static TypeProductEnum fromValue(String value) {
      for (TypeProductEnum b : TypeProductEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("typeProduct")
  private TypeProductEnum typeProduct;

  @JsonProperty("accountNumber")
  private String accountNumber;

  @JsonProperty("accountHolders")
  @Valid
  private List<HolderAndSigner> accountHolders = null;

  @JsonProperty("authorizedSignatories")
  @Valid
  private List<HolderAndSigner> authorizedSignatories = null;

  @JsonProperty("accountBalance")
  private Double accountBalance;

  public ClientProduct clientProductId(String clientProductId) {
    this.clientProductId = clientProductId;
    return this;
  }

  /**
   * Get clientProductId
   * @return clientProductId
  */
  
  @Schema(name = "clientProductId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getClientProductId() {
    return clientProductId;
  }

  public void setClientProductId(String clientProductId) {
    this.clientProductId = clientProductId;
  }

  public ClientProduct typeProduct(TypeProductEnum typeProduct) {
    this.typeProduct = typeProduct;
    return this;
  }

  /**
   * Get typeProduct
   * @return typeProduct
  */
  
  @Schema(name = "typeProduct", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public TypeProductEnum getTypeProduct() {
    return typeProduct;
  }

  public void setTypeProduct(TypeProductEnum typeProduct) {
    this.typeProduct = typeProduct;
  }

  public ClientProduct accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  */
  @NotNull 
  @Schema(name = "accountNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public ClientProduct accountHolders(List<HolderAndSigner> accountHolders) {
    this.accountHolders = accountHolders;
    return this;
  }

  public ClientProduct addAccountHoldersItem(HolderAndSigner accountHoldersItem) {
    if (this.accountHolders == null) {
      this.accountHolders = new ArrayList<>();
    }
    this.accountHolders.add(accountHoldersItem);
    return this;
  }

  /**
   * Get accountHolders
   * @return accountHolders
  */
  @Valid 
  @Schema(name = "accountHolders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<HolderAndSigner> getAccountHolders() {
    return accountHolders;
  }

  public void setAccountHolders(List<HolderAndSigner> accountHolders) {
    this.accountHolders = accountHolders;
  }

  public ClientProduct authorizedSignatories(List<HolderAndSigner> authorizedSignatories) {
    this.authorizedSignatories = authorizedSignatories;
    return this;
  }

  public ClientProduct addAuthorizedSignatoriesItem(HolderAndSigner authorizedSignatoriesItem) {
    if (this.authorizedSignatories == null) {
      this.authorizedSignatories = new ArrayList<>();
    }
    this.authorizedSignatories.add(authorizedSignatoriesItem);
    return this;
  }

  /**
   * Get authorizedSignatories
   * @return authorizedSignatories
  */
  @Valid 
  @Schema(name = "authorizedSignatories", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<HolderAndSigner> getAuthorizedSignatories() {
    return authorizedSignatories;
  }

  public void setAuthorizedSignatories(List<HolderAndSigner> authorizedSignatories) {
    this.authorizedSignatories = authorizedSignatories;
  }

  public ClientProduct accountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  /**
   * Get accountBalance
   * @return accountBalance
  */
  @NotNull 
  @Schema(name = "accountBalance", requiredMode = Schema.RequiredMode.REQUIRED)
  public Double getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientProduct clientProduct = (ClientProduct) o;
    return Objects.equals(this.clientProductId, clientProduct.clientProductId) &&
        Objects.equals(this.typeProduct, clientProduct.typeProduct) &&
        Objects.equals(this.accountNumber, clientProduct.accountNumber) &&
        Objects.equals(this.accountHolders, clientProduct.accountHolders) &&
        Objects.equals(this.authorizedSignatories, clientProduct.authorizedSignatories) &&
        Objects.equals(this.accountBalance, clientProduct.accountBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientProductId, typeProduct, accountNumber, accountHolders, authorizedSignatories, accountBalance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientProduct {\n");
    sb.append("    clientProductId: ").append(toIndentedString(clientProductId)).append("\n");
    sb.append("    typeProduct: ").append(toIndentedString(typeProduct)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountHolders: ").append(toIndentedString(accountHolders)).append("\n");
    sb.append("    authorizedSignatories: ").append(toIndentedString(authorizedSignatories)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
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

