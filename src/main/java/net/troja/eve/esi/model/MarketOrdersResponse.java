/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * The version of the OpenAPI document: 1.24
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package net.troja.eve.esi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.troja.eve.esi.JSON;

/**
 * 200 ok object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MarketOrdersResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_DURATION = "duration";
    @SerializedName(SERIALIZED_NAME_DURATION)
    private Integer duration;

    public static final String SERIALIZED_NAME_IS_BUY_ORDER = "is_buy_order";
    @SerializedName(SERIALIZED_NAME_IS_BUY_ORDER)
    private Boolean isBuyOrder;

    public static final String SERIALIZED_NAME_ISSUED = "issued";
    @SerializedName(SERIALIZED_NAME_ISSUED)
    private OffsetDateTime issued;

    public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
    @SerializedName(SERIALIZED_NAME_LOCATION_ID)
    private Long locationId;

    public static final String SERIALIZED_NAME_MIN_VOLUME = "min_volume";
    @SerializedName(SERIALIZED_NAME_MIN_VOLUME)
    private Integer minVolume;

    public static final String SERIALIZED_NAME_ORDER_ID = "order_id";
    @SerializedName(SERIALIZED_NAME_ORDER_ID)
    private Long orderId;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private Double price;

    /**
     * range string
     */
    @JsonAdapter(RangeEnum.Adapter.class)
    public enum RangeEnum {
        STATION("station"),

        REGION("region"),

        SOLARSYSTEM("solarsystem"),

        _1("1"),

        _2("2"),

        _3("3"),

        _4("4"),

        _5("5"),

        _10("10"),

        _20("20"),

        _30("30"),

        _40("40");

        private String value;

        RangeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RangeEnum fromValue(String value) {
            for (RangeEnum b : RangeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<RangeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RangeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RangeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RangeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_RANGE = "range";
    @SerializedName(SERIALIZED_NAME_RANGE)
    private String range;
    private RangeEnum rangeEnum;

    public static final String SERIALIZED_NAME_SYSTEM_ID = "system_id";
    @SerializedName(SERIALIZED_NAME_SYSTEM_ID)
    private Integer systemId;

    public static final String SERIALIZED_NAME_TYPE_ID = "type_id";
    @SerializedName(SERIALIZED_NAME_TYPE_ID)
    private Integer typeId;

    public static final String SERIALIZED_NAME_VOLUME_REMAIN = "volume_remain";
    @SerializedName(SERIALIZED_NAME_VOLUME_REMAIN)
    private Integer volumeRemain;

    public static final String SERIALIZED_NAME_VOLUME_TOTAL = "volume_total";
    @SerializedName(SERIALIZED_NAME_VOLUME_TOTAL)
    private Integer volumeTotal;

    public MarketOrdersResponse() {
    }

    public MarketOrdersResponse duration(Integer duration) {

        this.duration = duration;
        return this;
    }

    /**
     * duration integer
     * 
     * @return duration
     **/
    @javax.annotation.Nonnull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public MarketOrdersResponse isBuyOrder(Boolean isBuyOrder) {

        this.isBuyOrder = isBuyOrder;
        return this;
    }

    /**
     * is_buy_order boolean
     * 
     * @return isBuyOrder
     **/
    @javax.annotation.Nonnull
    public Boolean getIsBuyOrder() {
        return isBuyOrder;
    }

    public void setIsBuyOrder(Boolean isBuyOrder) {
        this.isBuyOrder = isBuyOrder;
    }

    public MarketOrdersResponse issued(OffsetDateTime issued) {

        this.issued = issued;
        return this;
    }

    /**
     * issued string
     * 
     * @return issued
     **/
    @javax.annotation.Nonnull
    public OffsetDateTime getIssued() {
        return issued;
    }

    public void setIssued(OffsetDateTime issued) {
        this.issued = issued;
    }

    public MarketOrdersResponse locationId(Long locationId) {

        this.locationId = locationId;
        return this;
    }

    /**
     * location_id integer
     * 
     * @return locationId
     **/
    @javax.annotation.Nonnull
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public MarketOrdersResponse minVolume(Integer minVolume) {

        this.minVolume = minVolume;
        return this;
    }

    /**
     * min_volume integer
     * 
     * @return minVolume
     **/
    @javax.annotation.Nonnull
    public Integer getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(Integer minVolume) {
        this.minVolume = minVolume;
    }

    public MarketOrdersResponse orderId(Long orderId) {

        this.orderId = orderId;
        return this;
    }

    /**
     * order_id integer
     * 
     * @return orderId
     **/
    @javax.annotation.Nonnull
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public MarketOrdersResponse price(Double price) {

        this.price = price;
        return this;
    }

    /**
     * price number
     * 
     * @return price
     **/
    @javax.annotation.Nonnull
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MarketOrdersResponse rangeString(String range) {

        this.range = range;
        return this;
    }

    public MarketOrdersResponse range(RangeEnum rangeEnum) {

        this.rangeEnum = rangeEnum;
        return this;
    }

    /**
     * range string
     * 
     * @return range
     **/
    @javax.annotation.Nonnull
    public RangeEnum getRange() {
        if (rangeEnum == null) {
            rangeEnum = RangeEnum.fromValue(range);
        }
        return rangeEnum;
    }

    public String getRangeString() {
        return range;
    }

    public void setRange(RangeEnum rangeEnum) {
        this.rangeEnum = rangeEnum;
    }

    public void setRangeString(String range) {
        this.range = range;
    }

    public MarketOrdersResponse systemId(Integer systemId) {

        this.systemId = systemId;
        return this;
    }

    /**
     * The solar system this order was placed
     * 
     * @return systemId
     **/
    @javax.annotation.Nonnull
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public MarketOrdersResponse typeId(Integer typeId) {

        this.typeId = typeId;
        return this;
    }

    /**
     * type_id integer
     * 
     * @return typeId
     **/
    @javax.annotation.Nonnull
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public MarketOrdersResponse volumeRemain(Integer volumeRemain) {

        this.volumeRemain = volumeRemain;
        return this;
    }

    /**
     * volume_remain integer
     * 
     * @return volumeRemain
     **/
    @javax.annotation.Nonnull
    public Integer getVolumeRemain() {
        return volumeRemain;
    }

    public void setVolumeRemain(Integer volumeRemain) {
        this.volumeRemain = volumeRemain;
    }

    public MarketOrdersResponse volumeTotal(Integer volumeTotal) {

        this.volumeTotal = volumeTotal;
        return this;
    }

    /**
     * volume_total integer
     * 
     * @return volumeTotal
     **/
    @javax.annotation.Nonnull
    public Integer getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(Integer volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketOrdersResponse marketOrdersResponse = (MarketOrdersResponse) o;
        return Objects.equals(this.duration, marketOrdersResponse.duration)
                && Objects.equals(this.isBuyOrder, marketOrdersResponse.isBuyOrder)
                && Objects.equals(this.issued, marketOrdersResponse.issued)
                && Objects.equals(this.locationId, marketOrdersResponse.locationId)
                && Objects.equals(this.minVolume, marketOrdersResponse.minVolume)
                && Objects.equals(this.orderId, marketOrdersResponse.orderId)
                && Objects.equals(this.price, marketOrdersResponse.price)
                && Objects.equals(this.range, marketOrdersResponse.range)
                && Objects.equals(this.systemId, marketOrdersResponse.systemId)
                && Objects.equals(this.typeId, marketOrdersResponse.typeId)
                && Objects.equals(this.volumeRemain, marketOrdersResponse.volumeRemain)
                && Objects.equals(this.volumeTotal, marketOrdersResponse.volumeTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, isBuyOrder, issued, locationId, minVolume, orderId, price, range, systemId,
                typeId, volumeRemain, volumeTotal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MarketOrdersResponse {\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    isBuyOrder: ").append(toIndentedString(isBuyOrder)).append("\n");
        sb.append("    issued: ").append(toIndentedString(issued)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    minVolume: ").append(toIndentedString(minVolume)).append("\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    range: ").append(toIndentedString(range)).append("\n");
        sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
        sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
        sb.append("    volumeRemain: ").append(toIndentedString(volumeRemain)).append("\n");
        sb.append("    volumeTotal: ").append(toIndentedString(volumeTotal)).append("\n");
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

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("duration");
        openapiFields.add("is_buy_order");
        openapiFields.add("issued");
        openapiFields.add("location_id");
        openapiFields.add("min_volume");
        openapiFields.add("order_id");
        openapiFields.add("price");
        openapiFields.add("range");
        openapiFields.add("system_id");
        openapiFields.add("type_id");
        openapiFields.add("volume_remain");
        openapiFields.add("volume_total");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("duration");
        openapiRequiredFields.add("is_buy_order");
        openapiRequiredFields.add("issued");
        openapiRequiredFields.add("location_id");
        openapiRequiredFields.add("min_volume");
        openapiRequiredFields.add("order_id");
        openapiRequiredFields.add("price");
        openapiRequiredFields.add("range");
        openapiRequiredFields.add("system_id");
        openapiRequiredFields.add("type_id");
        openapiRequiredFields.add("volume_remain");
        openapiRequiredFields.add("volume_total");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             MarketOrdersResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!MarketOrdersResponse.openapiRequiredFields.isEmpty()) { // has
                                                                         // required
                                                                         // fields
                                                                         // but
                                                                         // JSON
                                                                         // object
                                                                         // is
                                                                         // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in MarketOrdersResponse is not found in the empty JSON string",
                        MarketOrdersResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!MarketOrdersResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `MarketOrdersResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : MarketOrdersResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("range").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `range` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("range").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!MarketOrdersResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'MarketOrdersResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<MarketOrdersResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(MarketOrdersResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<MarketOrdersResponse>() {
                @Override
                public void write(JsonWriter out, MarketOrdersResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public MarketOrdersResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of MarketOrdersResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of MarketOrdersResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             MarketOrdersResponse
     */
    public static MarketOrdersResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, MarketOrdersResponse.class);
    }

    /**
     * Convert an instance of MarketOrdersResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
