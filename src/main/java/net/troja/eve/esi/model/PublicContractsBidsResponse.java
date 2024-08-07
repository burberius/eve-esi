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
public class PublicContractsBidsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private Float amount;

    public static final String SERIALIZED_NAME_BID_ID = "bid_id";
    @SerializedName(SERIALIZED_NAME_BID_ID)
    private Integer bidId;

    public static final String SERIALIZED_NAME_DATE_BID = "date_bid";
    @SerializedName(SERIALIZED_NAME_DATE_BID)
    private OffsetDateTime dateBid;

    public PublicContractsBidsResponse() {
    }

    public PublicContractsBidsResponse amount(Float amount) {

        this.amount = amount;
        return this;
    }

    /**
     * The amount bid, in ISK
     * 
     * @return amount
     **/
    @javax.annotation.Nonnull
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public PublicContractsBidsResponse bidId(Integer bidId) {

        this.bidId = bidId;
        return this;
    }

    /**
     * Unique ID for the bid
     * 
     * @return bidId
     **/
    @javax.annotation.Nonnull
    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public PublicContractsBidsResponse dateBid(OffsetDateTime dateBid) {

        this.dateBid = dateBid;
        return this;
    }

    /**
     * Datetime when the bid was placed
     * 
     * @return dateBid
     **/
    @javax.annotation.Nonnull
    public OffsetDateTime getDateBid() {
        return dateBid;
    }

    public void setDateBid(OffsetDateTime dateBid) {
        this.dateBid = dateBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublicContractsBidsResponse publicContractsBidsResponse = (PublicContractsBidsResponse) o;
        return Objects.equals(this.amount, publicContractsBidsResponse.amount)
                && Objects.equals(this.bidId, publicContractsBidsResponse.bidId)
                && Objects.equals(this.dateBid, publicContractsBidsResponse.dateBid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, bidId, dateBid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublicContractsBidsResponse {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    bidId: ").append(toIndentedString(bidId)).append("\n");
        sb.append("    dateBid: ").append(toIndentedString(dateBid)).append("\n");
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
        openapiFields.add("amount");
        openapiFields.add("bid_id");
        openapiFields.add("date_bid");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("amount");
        openapiRequiredFields.add("bid_id");
        openapiRequiredFields.add("date_bid");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             PublicContractsBidsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!PublicContractsBidsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                                // required
                                                                                // fields
                                                                                // but
                                                                                // JSON
                                                                                // object
                                                                                // is
                                                                                // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in PublicContractsBidsResponse is not found in the empty JSON string",
                                PublicContractsBidsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!PublicContractsBidsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `PublicContractsBidsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : PublicContractsBidsResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!PublicContractsBidsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'PublicContractsBidsResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<PublicContractsBidsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(PublicContractsBidsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<PublicContractsBidsResponse>() {
                @Override
                public void write(JsonWriter out, PublicContractsBidsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public PublicContractsBidsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of PublicContractsBidsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of PublicContractsBidsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             PublicContractsBidsResponse
     */
    public static PublicContractsBidsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, PublicContractsBidsResponse.class);
    }

    /**
     * Convert an instance of PublicContractsBidsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
