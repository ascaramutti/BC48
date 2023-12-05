package com.BootCamp38.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Transaction
 */
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T16:37:41.514380-05:00[America/Lima]")
public class Transaction {

  @JsonProperty("transactionId")
  private String transactionId;

  /**
   * Gets or Sets typeTransaction
   */
  public enum TypeTransactionEnum {
    CREDIT("credit"),
    
    DEBIT("debit");

    private String value;

    TypeTransactionEnum(String value) {
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
    public static TypeTransactionEnum fromValue(String value) {
      for (TypeTransactionEnum b : TypeTransactionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("typeTransaction")
  private TypeTransactionEnum typeTransaction;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  @JsonProperty("productId")
  private String productId;

  public Transaction transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Get transactionId
   * @return transactionId
  */
  
  @Schema(name = "transactionId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public Transaction typeTransaction(TypeTransactionEnum typeTransaction) {
    this.typeTransaction = typeTransaction;
    return this;
  }

  /**
   * Get typeTransaction
   * @return typeTransaction
  */
  @NotNull 
  @Schema(name = "typeTransaction", requiredMode = Schema.RequiredMode.REQUIRED)
  public TypeTransactionEnum getTypeTransaction() {
    return typeTransaction;
  }

  public void setTypeTransaction(TypeTransactionEnum typeTransaction) {
    this.typeTransaction = typeTransaction;
  }

  public Transaction amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.REQUIRED)
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Transaction date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.REQUIRED)
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Transaction productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @NotNull 
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionId, transaction.transactionId) &&
        Objects.equals(this.typeTransaction, transaction.typeTransaction) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.date, transaction.date) &&
        Objects.equals(this.productId, transaction.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, typeTransaction, amount, date, productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    typeTransaction: ").append(toIndentedString(typeTransaction)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

