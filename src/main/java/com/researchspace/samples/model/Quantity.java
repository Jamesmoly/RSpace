/*
 * 
 * Modified class files generated by swagger code generation from
 * 
 * RSpace Inventory API
 * Welcome to the RSpace Inventory API.  | Api version | Required minimum RSpace version| | --- | --- | | 1.7.0 | 1.70 | | 1.7.1 | 1.71 | 
 *
 * OpenAPI spec version: 1.7.1
 * Contact: support@researchspace.com
 *
 */


package com.researchspace.samples.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * A quantity of something, described as a decimal value and a unit.
 */
@ApiModel(description = "A quantity of something, described as a decimal value and a unit.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-10-23T10:46:11.180Z")
public class Quantity {
  @SerializedName("numericValue")
  private BigDecimal numericValue = null;

  @SerializedName("unitId")
  private Integer unitId = null;

  public Quantity numericValue(BigDecimal numericValue) {
    this.numericValue = numericValue;
    return this;
  }

   /**
   * decimal number of any precision
   * @return numericValue
  **/
  @ApiModelProperty(value = "decimal number of any precision")
  public BigDecimal getNumericValue() {
    return numericValue;
  }

  public void setNumericValue(BigDecimal numericValue) {
    this.numericValue = numericValue;
  }

  public Quantity unitId(Integer unitId) {
    this.unitId = unitId;
    return this;
  }

   /**
   * id of a quantity unit
   * @return unitId
  **/
  @ApiModelProperty(value = "id of a quantity unit")
  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quantity quantity = (Quantity) o;
    return Objects.equals(this.numericValue, quantity.numericValue) &&
        Objects.equals(this.unitId, quantity.unitId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numericValue, unitId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quantity {\n");
    
    sb.append("    numericValue: ").append(toIndentedString(numericValue)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
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

