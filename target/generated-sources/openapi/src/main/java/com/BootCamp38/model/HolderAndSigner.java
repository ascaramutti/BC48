package com.BootCamp38.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * HolderAndSigner
 */
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-07T15:54:48.392513-05:00[America/Lima]")
public class HolderAndSigner {

  @JsonProperty("holderAndSignerId")
  private String holderAndSignerId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("documentNumber")
  private String documentNumber;

  public HolderAndSigner holderAndSignerId(String holderAndSignerId) {
    this.holderAndSignerId = holderAndSignerId;
    return this;
  }

  /**
   * Get holderAndSignerId
   * @return holderAndSignerId
  */
  
  @Schema(name = "holderAndSignerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getHolderAndSignerId() {
    return holderAndSignerId;
  }

  public void setHolderAndSignerId(String holderAndSignerId) {
    this.holderAndSignerId = holderAndSignerId;
  }

  public HolderAndSigner name(String name) {
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

  public HolderAndSigner documentNumber(String documentNumber) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HolderAndSigner holderAndSigner = (HolderAndSigner) o;
    return Objects.equals(this.holderAndSignerId, holderAndSigner.holderAndSignerId) &&
        Objects.equals(this.name, holderAndSigner.name) &&
        Objects.equals(this.documentNumber, holderAndSigner.documentNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holderAndSignerId, name, documentNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HolderAndSigner {\n");
    sb.append("    holderAndSignerId: ").append(toIndentedString(holderAndSignerId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    documentNumber: ").append(toIndentedString(documentNumber)).append("\n");
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

