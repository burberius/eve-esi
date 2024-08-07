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
 * wallet transaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CorporationWalletTransactionsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CLIENT_ID = "client_id";
    @SerializedName(SERIALIZED_NAME_CLIENT_ID)
    private Integer clientId;

    public static final String SERIALIZED_NAME_DATE = "date";
    @SerializedName(SERIALIZED_NAME_DATE)
    private OffsetDateTime date;

    public static final String SERIALIZED_NAME_IS_BUY = "is_buy";
    @SerializedName(SERIALIZED_NAME_IS_BUY)
    private Boolean isBuy;

    public static final String SERIALIZED_NAME_JOURNAL_REF_ID = "journal_ref_id";
    @SerializedName(SERIALIZED_NAME_JOURNAL_REF_ID)
    private Long journalRefId;

    public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
    @SerializedName(SERIALIZED_NAME_LOCATION_ID)
    private Long locationId;

    public static final String SERIALIZED_NAME_QUANTITY = "quantity";
    @SerializedName(SERIALIZED_NAME_QUANTITY)
    private Integer quantity;

    public static final String SERIALIZED_NAME_TRANSACTION_ID = "transaction_id";
    @SerializedName(SERIALIZED_NAME_TRANSACTION_ID)
    private Long transactionId;

    public static final String SERIALIZED_NAME_TYPE_ID = "type_id";
    @SerializedName(SERIALIZED_NAME_TYPE_ID)
    private Integer typeId;

    public static final String SERIALIZED_NAME_UNIT_PRICE = "unit_price";
    @SerializedName(SERIALIZED_NAME_UNIT_PRICE)
    private Double unitPrice;

    public CorporationWalletTransactionsResponse() {
    }

    public CorporationWalletTransactionsResponse clientId(Integer clientId) {

        this.clientId = clientId;
        return this;
    }

    /**
     * client_id integer
     * 
     * @return clientId
     **/
    @javax.annotation.Nonnull
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public CorporationWalletTransactionsResponse date(OffsetDateTime date) {

        this.date = date;
        return this;
    }

    /**
     * Date and time of transaction
     * 
     * @return date
     **/
    @javax.annotation.Nonnull
    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public CorporationWalletTransactionsResponse isBuy(Boolean isBuy) {

        this.isBuy = isBuy;
        return this;
    }

    /**
     * is_buy boolean
     * 
     * @return isBuy
     **/
    @javax.annotation.Nonnull
    public Boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Boolean isBuy) {
        this.isBuy = isBuy;
    }

    public CorporationWalletTransactionsResponse journalRefId(Long journalRefId) {

        this.journalRefId = journalRefId;
        return this;
    }

    /**
     * -1 if there is no corresponding wallet journal entry
     * 
     * @return journalRefId
     **/
    @javax.annotation.Nonnull
    public Long getJournalRefId() {
        return journalRefId;
    }

    public void setJournalRefId(Long journalRefId) {
        this.journalRefId = journalRefId;
    }

    public CorporationWalletTransactionsResponse locationId(Long locationId) {

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

    public CorporationWalletTransactionsResponse quantity(Integer quantity) {

        this.quantity = quantity;
        return this;
    }

    /**
     * quantity integer
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

    public CorporationWalletTransactionsResponse transactionId(Long transactionId) {

        this.transactionId = transactionId;
        return this;
    }

    /**
     * Unique transaction ID
     * 
     * @return transactionId
     **/
    @javax.annotation.Nonnull
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public CorporationWalletTransactionsResponse typeId(Integer typeId) {

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

    public CorporationWalletTransactionsResponse unitPrice(Double unitPrice) {

        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Amount paid per unit
     * 
     * @return unitPrice
     **/
    @javax.annotation.Nonnull
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CorporationWalletTransactionsResponse corporationWalletTransactionsResponse = (CorporationWalletTransactionsResponse) o;
        return Objects.equals(this.clientId, corporationWalletTransactionsResponse.clientId)
                && Objects.equals(this.date, corporationWalletTransactionsResponse.date)
                && Objects.equals(this.isBuy, corporationWalletTransactionsResponse.isBuy)
                && Objects.equals(this.journalRefId, corporationWalletTransactionsResponse.journalRefId)
                && Objects.equals(this.locationId, corporationWalletTransactionsResponse.locationId)
                && Objects.equals(this.quantity, corporationWalletTransactionsResponse.quantity)
                && Objects.equals(this.transactionId, corporationWalletTransactionsResponse.transactionId)
                && Objects.equals(this.typeId, corporationWalletTransactionsResponse.typeId)
                && Objects.equals(this.unitPrice, corporationWalletTransactionsResponse.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(clientId, date, isBuy, journalRefId, locationId, quantity, transactionId, typeId, unitPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CorporationWalletTransactionsResponse {\n");
        sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    isBuy: ").append(toIndentedString(isBuy)).append("\n");
        sb.append("    journalRefId: ").append(toIndentedString(journalRefId)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
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
        openapiFields.add("client_id");
        openapiFields.add("date");
        openapiFields.add("is_buy");
        openapiFields.add("journal_ref_id");
        openapiFields.add("location_id");
        openapiFields.add("quantity");
        openapiFields.add("transaction_id");
        openapiFields.add("type_id");
        openapiFields.add("unit_price");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("client_id");
        openapiRequiredFields.add("date");
        openapiRequiredFields.add("is_buy");
        openapiRequiredFields.add("journal_ref_id");
        openapiRequiredFields.add("location_id");
        openapiRequiredFields.add("quantity");
        openapiRequiredFields.add("transaction_id");
        openapiRequiredFields.add("type_id");
        openapiRequiredFields.add("unit_price");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CorporationWalletTransactionsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CorporationWalletTransactionsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                                          // required
                                                                                          // fields
                                                                                          // but
                                                                                          // JSON
                                                                                          // object
                                                                                          // is
                                                                                          // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in CorporationWalletTransactionsResponse is not found in the empty JSON string",
                                CorporationWalletTransactionsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CorporationWalletTransactionsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CorporationWalletTransactionsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CorporationWalletTransactionsResponse.openapiRequiredFields) {
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
            if (!CorporationWalletTransactionsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CorporationWalletTransactionsResponse' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CorporationWalletTransactionsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CorporationWalletTransactionsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CorporationWalletTransactionsResponse>() {
                @Override
                public void write(JsonWriter out, CorporationWalletTransactionsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CorporationWalletTransactionsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CorporationWalletTransactionsResponse given an JSON
     * string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CorporationWalletTransactionsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CorporationWalletTransactionsResponse
     */
    public static CorporationWalletTransactionsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CorporationWalletTransactionsResponse.class);
    }

    /**
     * Convert an instance of CorporationWalletTransactionsResponse to an JSON
     * string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
