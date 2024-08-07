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
 * active_total object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private Integer amount;

    public static final String SERIALIZED_NAME_CORPORATION_ID = "corporation_id";
    @SerializedName(SERIALIZED_NAME_CORPORATION_ID)
    private Integer corporationId;

    public FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints() {
    }

    public FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints amount(Integer amount) {

        this.amount = amount;
        return this;
    }

    /**
     * Amount of victory points
     * 
     * @return amount
     **/
    @javax.annotation.Nullable
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints corporationId(Integer corporationId) {

        this.corporationId = corporationId;
        return this;
    }

    /**
     * corporation_id integer
     * 
     * @return corporationId
     **/
    @javax.annotation.Nullable
    public Integer getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints factionWarfareLeaderboardCorporationActiveTotalVictoryPoints = (FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints) o;
        return Objects.equals(this.amount, factionWarfareLeaderboardCorporationActiveTotalVictoryPoints.amount)
                && Objects.equals(this.corporationId,
                        factionWarfareLeaderboardCorporationActiveTotalVictoryPoints.corporationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, corporationId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
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
        openapiFields.add("corporation_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.openapiRequiredFields.isEmpty()) { // has
                                                                                                                 // required
                                                                                                                 // fields
                                                                                                                 // but
                                                                                                                 // JSON
                                                                                                                 // object
                                                                                                                 // is
                                                                                                                 // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints is not found in the empty JSON string",
                                FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.openapiRequiredFields
                                        .toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints'
                             // and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints> thisAdapter = gson
                    .getDelegateAdapter(this,
                            TypeToken.get(FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.class));

            return (TypeAdapter<T>) new TypeAdapter<FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints>() {
                @Override
                public void write(JsonWriter out, FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints value)
                        throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints read(JsonReader in)
                        throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of
     * FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints given an
     * JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of
     *         FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints
     */
    public static FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints fromJson(String jsonString)
            throws IOException {
        return JSON.getGson().fromJson(jsonString, FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints.class);
    }

    /**
     * Convert an instance of
     * FactionWarfareLeaderboardCorporationActiveTotalVictoryPoints to an JSON
     * string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
