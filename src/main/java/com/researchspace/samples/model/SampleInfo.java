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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Basic information about RSpace Inventory Sample.
 */
@ApiModel(description = "Basic information about RSpace Inventory Sample.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-10-23T10:46:11.180Z")
public class SampleInfo extends InventoryRecordInfo {
  @SerializedName("templateId")
  private BigDecimal templateId = null;

  @SerializedName("owner")
  private User owner = null;

  @SerializedName("subSampleAlias")
  private String subSampleAlias = null;

  @SerializedName("storageTempMin")
  private Quantity storageTempMin = null;

  @SerializedName("storageTempMax")
  private Quantity storageTempMax = null;

  /**
   * The source of the sample
   */
  @JsonAdapter(SampleSourceEnum.Adapter.class)
  public enum SampleSourceEnum {
    LAB_CREATED("LAB_CREATED"),
    
    VENDOR_SUPPLIED("VENDOR_SUPPLIED"),
    
    OTHER("OTHER");

    private String value;

    SampleSourceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SampleSourceEnum fromValue(String text) {
      for (SampleSourceEnum b : SampleSourceEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SampleSourceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SampleSourceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SampleSourceEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SampleSourceEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("sampleSource")
  private SampleSourceEnum sampleSource = null;

  @SerializedName("expiryDate")
  private String expiryDate = null;

  @SerializedName("_links")
  private LinkItemList links = null;

  public SampleInfo templateId(BigDecimal templateId) {
    this.templateId = templateId;
    return this;
  }

   /**
   * Identifier of the template used to create this sample. May be unset if this sample was not created from  a Template
   * @return templateId
  **/
  @ApiModelProperty(value = "Identifier of the template used to create this sample. May be unset if this sample was not created from  a Template")
  public BigDecimal getTemplateId() {
    return templateId;
  }

  public void setTemplateId(BigDecimal templateId) {
    this.templateId = templateId;
  }

  public SampleInfo owner(User owner) {
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(value = "")
  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public SampleInfo subSampleAlias(String subSampleAlias) {
    this.subSampleAlias = subSampleAlias;
    return this;
  }

   /**
   * How the individual SubSample should be called, e.g. aliquot, unit, etc. Defaults to &#39;subsample&#39;.
   * @return subSampleAlias
  **/
  @ApiModelProperty(value = "How the individual SubSample should be called, e.g. aliquot, unit, etc. Defaults to 'subsample'.")
  public String getSubSampleAlias() {
    return subSampleAlias;
  }

  public void setSubSampleAlias(String subSampleAlias) {
    this.subSampleAlias = subSampleAlias;
  }

  public SampleInfo storageTempMin(Quantity storageTempMin) {
    this.storageTempMin = storageTempMin;
    return this;
  }

   /**
   * Get storageTempMin
   * @return storageTempMin
  **/
  @ApiModelProperty(value = "")
  public Quantity getStorageTempMin() {
    return storageTempMin;
  }

  public void setStorageTempMin(Quantity storageTempMin) {
    this.storageTempMin = storageTempMin;
  }

  public SampleInfo storageTempMax(Quantity storageTempMax) {
    this.storageTempMax = storageTempMax;
    return this;
  }

   /**
   * Get storageTempMax
   * @return storageTempMax
  **/
  @ApiModelProperty(value = "")
  public Quantity getStorageTempMax() {
    return storageTempMax;
  }

  public void setStorageTempMax(Quantity storageTempMax) {
    this.storageTempMax = storageTempMax;
  }

  public SampleInfo sampleSource(SampleSourceEnum sampleSource) {
    this.sampleSource = sampleSource;
    return this;
  }

   /**
   * The source of the sample
   * @return sampleSource
  **/
  @ApiModelProperty(value = "The source of the sample")
  public SampleSourceEnum getSampleSource() {
    return sampleSource;
  }

  public void setSampleSource(SampleSourceEnum sampleSource) {
    this.sampleSource = sampleSource;
  }

  public SampleInfo expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

   /**
   * Optional date at which a sample expires, in ISO-8601 format
   * @return expiryDate
  **/
  @ApiModelProperty(value = "Optional date at which a sample expires, in ISO-8601 format")
  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public SampleInfo links(LinkItemList links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public LinkItemList getLinks() {
    return links;
  }

  public void setLinks(LinkItemList links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleInfo sampleInfo = (SampleInfo) o;
    return Objects.equals(this.templateId, sampleInfo.templateId) &&
        Objects.equals(this.owner, sampleInfo.owner) &&
        Objects.equals(this.subSampleAlias, sampleInfo.subSampleAlias) &&
        Objects.equals(this.storageTempMin, sampleInfo.storageTempMin) &&
        Objects.equals(this.storageTempMax, sampleInfo.storageTempMax) &&
        Objects.equals(this.sampleSource, sampleInfo.sampleSource) &&
        Objects.equals(this.expiryDate, sampleInfo.expiryDate) &&
        Objects.equals(this.links, sampleInfo.links) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateId, owner, subSampleAlias, storageTempMin, storageTempMax, sampleSource, expiryDate, links, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleInfo {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    subSampleAlias: ").append(toIndentedString(subSampleAlias)).append("\n");
    sb.append("    storageTempMin: ").append(toIndentedString(storageTempMin)).append("\n");
    sb.append("    storageTempMax: ").append(toIndentedString(storageTempMax)).append("\n");
    sb.append("    sampleSource: ").append(toIndentedString(sampleSource)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
