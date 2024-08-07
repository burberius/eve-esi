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
import net.troja.eve.esi.model.FactionWarfareLeaderboardKills;
import net.troja.eve.esi.model.FactionWarfareLeaderboardVictoryPoints;
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
public class FactionWarfareLeaderboardResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_KILLS = "kills";
    @SerializedName(SERIALIZED_NAME_KILLS)
    private FactionWarfareLeaderboardKills kills;

    public static final String SERIALIZED_NAME_VICTORY_POINTS = "victory_points";
    @SerializedName(SERIALIZED_NAME_VICTORY_POINTS)
    private FactionWarfareLeaderboardVictoryPoints victoryPoints;

    public FactionWarfareLeaderboardResponse() {
    }

    public FactionWarfareLeaderboardResponse kills(FactionWarfareLeaderboardKills kills) {

        this.kills = kills;
        return this;
    }

    /**
     * Get kills
     * 
     * @return kills
     **/
    @javax.annotation.Nonnull
    public FactionWarfareLeaderboardKills getKills() {
        return kills;
    }

    public void setKills(FactionWarfareLeaderboardKills kills) {
        this.kills = kills;
    }

    public FactionWarfareLeaderboardResponse victoryPoints(FactionWarfareLeaderboardVictoryPoints victoryPoints) {

        this.victoryPoints = victoryPoints;
        return this;
    }

    /**
     * Get victoryPoints
     * 
     * @return victoryPoints
     **/
    @javax.annotation.Nonnull
    public FactionWarfareLeaderboardVictoryPoints getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(FactionWarfareLeaderboardVictoryPoints victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FactionWarfareLeaderboardResponse factionWarfareLeaderboardResponse = (FactionWarfareLeaderboardResponse) o;
        return Objects.equals(this.kills, factionWarfareLeaderboardResponse.kills)
                && Objects.equals(this.victoryPoints, factionWarfareLeaderboardResponse.victoryPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kills, victoryPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FactionWarfareLeaderboardResponse {\n");
        sb.append("    kills: ").append(toIndentedString(kills)).append("\n");
        sb.append("    victoryPoints: ").append(toIndentedString(victoryPoints)).append("\n");
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
        openapiFields.add("kills");
        openapiFields.add("victory_points");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("kills");
        openapiRequiredFields.add("victory_points");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             FactionWarfareLeaderboardResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!FactionWarfareLeaderboardResponse.openapiRequiredFields.isEmpty()) { // has
                                                                                      // required
                                                                                      // fields
                                                                                      // but
                                                                                      // JSON
                                                                                      // object
                                                                                      // is
                                                                                      // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in FactionWarfareLeaderboardResponse is not found in the empty JSON string",
                                FactionWarfareLeaderboardResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!FactionWarfareLeaderboardResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `FactionWarfareLeaderboardResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : FactionWarfareLeaderboardResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        // validate the required field `kills`
        FactionWarfareLeaderboardKills.validateJsonObject(jsonObj.getAsJsonObject("kills"));
        // validate the required field `victory_points`
        FactionWarfareLeaderboardVictoryPoints.validateJsonObject(jsonObj.getAsJsonObject("victory_points"));
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!FactionWarfareLeaderboardResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'FactionWarfareLeaderboardResponse' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FactionWarfareLeaderboardResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(FactionWarfareLeaderboardResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<FactionWarfareLeaderboardResponse>() {
                @Override
                public void write(JsonWriter out, FactionWarfareLeaderboardResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public FactionWarfareLeaderboardResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of FactionWarfareLeaderboardResponse given an JSON
     * string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of FactionWarfareLeaderboardResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             FactionWarfareLeaderboardResponse
     */
    public static FactionWarfareLeaderboardResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, FactionWarfareLeaderboardResponse.class);
    }

    /**
     * Convert an instance of FactionWarfareLeaderboardResponse to an JSON
     * string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
