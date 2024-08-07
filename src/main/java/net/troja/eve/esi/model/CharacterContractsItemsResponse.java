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
public class CharacterContractsItemsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_IS_INCLUDED = "is_included";
    @SerializedName(SERIALIZED_NAME_IS_INCLUDED)
    private Boolean isIncluded;

    public static final String SERIALIZED_NAME_IS_SINGLETON = "is_singleton";
    @SerializedName(SERIALIZED_NAME_IS_SINGLETON)
    private Boolean isSingleton;

    public static final String SERIALIZED_NAME_QUANTITY = "quantity";
    @SerializedName(SERIALIZED_NAME_QUANTITY)
    private Integer quantity;

    public static final String SERIALIZED_NAME_RAW_QUANTITY = "raw_quantity";
    @SerializedName(SERIALIZED_NAME_RAW_QUANTITY)
    private Integer rawQuantity;

    public static final String SERIALIZED_NAME_RECORD_ID = "record_id";
    @SerializedName(SERIALIZED_NAME_RECORD_ID)
    private Long recordId;

    public static final String SERIALIZED_NAME_TYPE_ID = "type_id";
    @SerializedName(SERIALIZED_NAME_TYPE_ID)
    private Integer typeId;

    public CharacterContractsItemsResponse() {
    }

    public CharacterContractsItemsResponse isIncluded(Boolean isIncluded) {

        this.isIncluded = isIncluded;
        return this;
    }

    /**
     * true if the contract issuer has submitted this item with the contract,
     * false if the isser is asking for this item in the contract
     * 
     * @return isIncluded
     **/
    @javax.annotation.Nonnull
    public Boolean getIsIncluded() {
        return isIncluded;
    }

    public void setIsIncluded(Boolean isIncluded) {
        this.isIncluded = isIncluded;
    }

    public CharacterContractsItemsResponse isSingleton(Boolean isSingleton) {

        this.isSingleton = isSingleton;
        return this;
    }

    /**
     * is_singleton boolean
     * 
     * @return isSingleton
     **/
    @javax.annotation.Nonnull
    public Boolean getIsSingleton() {
        return isSingleton;
    }

    public void setIsSingleton(Boolean isSingleton) {
        this.isSingleton = isSingleton;
    }

    public CharacterContractsItemsResponse quantity(Integer quantity) {

        this.quantity = quantity;
        return this;
    }

    /**
     * Number of items in the stack
     * 
     * @return quantity
     **/
    @javax.annotation.Nonnull
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CharacterContractsItemsResponse rawQuantity(Integer rawQuantity) {

        this.rawQuantity = rawQuantity;
        return this;
    }

    /**
     * -1 indicates that the item is a singleton (non-stackable). If the item
     * happens to be a Blueprint, -1 is an Original and -2 is a Blueprint Copy
     * 
     * @return rawQuantity
     **/
    @javax.annotation.Nullable
    public Integer getRawQuantity() {
        return rawQuantity;
    }

    public void setRawQuantity(Integer rawQuantity) {
        this.rawQuantity = rawQuantity;
    }

    public CharacterContractsItemsResponse recordId(Long recordId) {

        this.recordId = recordId;
        return this;
    }

    /**
     * Unique ID for the item
     * 
     * @return recordId
     **/
    @javax.annotation.Nonnull
    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public CharacterContractsItemsResponse typeId(Integer typeId) {

        this.typeId = typeId;
        return this;
    }

    /**
     * Type ID for item
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterContractsItemsResponse characterContractsItemsResponse = (CharacterContractsItemsResponse) o;
        return Objects.equals(this.isIncluded, characterContractsItemsResponse.isIncluded)
                && Objects.equals(this.isSingleton, characterContractsItemsResponse.isSingleton)
                && Objects.equals(this.quantity, characterContractsItemsResponse.quantity)
                && Objects.equals(this.rawQuantity, characterContractsItemsResponse.rawQuantity)
                && Objects.equals(this.recordId, characterContractsItemsResponse.recordId)
                && Objects.equals(this.typeId, characterContractsItemsResponse.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isIncluded, isSingleton, quantity, rawQuantity, recordId, typeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterContractsItemsResponse {\n");
        sb.append("    isIncluded: ").append(toIndentedString(isIncluded)).append("\n");
        sb.append("    isSingleton: ").append(toIndentedString(isSingleton)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    rawQuantity: ").append(toIndentedString(rawQuantity)).append("\n");
        sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
        sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
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
        openapiFields.add("is_included");
        openapiFields.add("is_singleton");
        openapiFields.add("quantity");
        openapiFields.add("raw_quantity");
        openapiFields.add("record_id");
        openapiFields.add("type_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("is_included");
        openapiRequiredFields.add("is_singleton");
        openapiRequiredFields.add("quantity");
        openapiRequiredFields.add("record_id");
        openapiRequiredFields.add("type_id");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterContractsItemsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterContractsItemsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                                    // required
                                                                                    // fields
                                                                                    // but
                                                                                    // JSON
                                                                                    // object
                                                                                    // is
                                                                                    // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in CharacterContractsItemsResponse is not found in the empty JSON string",
                                CharacterContractsItemsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterContractsItemsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterContractsItemsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterContractsItemsResponse.openapiRequiredFields) {
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
            if (!CharacterContractsItemsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterContractsItemsResponse' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterContractsItemsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterContractsItemsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterContractsItemsResponse>() {
                @Override
                public void write(JsonWriter out, CharacterContractsItemsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterContractsItemsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterContractsItemsResponse given an JSON
     * string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterContractsItemsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterContractsItemsResponse
     */
    public static CharacterContractsItemsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterContractsItemsResponse.class);
    }

    /**
     * Convert an instance of CharacterContractsItemsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
