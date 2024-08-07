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
import java.util.ArrayList;
import java.util.List;
import net.troja.eve.esi.model.Squad;
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
public class FleetWingsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private Long id;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_SQUADS = "squads";
    @SerializedName(SERIALIZED_NAME_SQUADS)
    private List<Squad> squads = new ArrayList<>();

    public FleetWingsResponse() {
    }

    public FleetWingsResponse id(Long id) {

        this.id = id;
        return this;
    }

    /**
     * id integer
     * 
     * @return id
     **/
    @javax.annotation.Nonnull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FleetWingsResponse name(String name) {

        this.name = name;
        return this;
    }

    /**
     * name string
     * 
     * @return name
     **/
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FleetWingsResponse squads(List<Squad> squads) {

        this.squads = squads;
        return this;
    }

    public FleetWingsResponse addSquadsItem(Squad squadsItem) {
        if (this.squads == null) {
            this.squads = new ArrayList<>();
        }
        this.squads.add(squadsItem);
        return this;
    }

    /**
     * squads array
     * 
     * @return squads
     **/
    @javax.annotation.Nonnull
    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FleetWingsResponse fleetWingsResponse = (FleetWingsResponse) o;
        return Objects.equals(this.id, fleetWingsResponse.id) && Objects.equals(this.name, fleetWingsResponse.name)
                && Objects.equals(this.squads, fleetWingsResponse.squads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, squads);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FleetWingsResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    squads: ").append(toIndentedString(squads)).append("\n");
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
        openapiFields.add("id");
        openapiFields.add("name");
        openapiFields.add("squads");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("id");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("squads");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             FleetWingsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!FleetWingsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                       // required
                                                                       // fields
                                                                       // but
                                                                       // JSON
                                                                       // object
                                                                       // is
                                                                       // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in FleetWingsResponse is not found in the empty JSON string",
                        FleetWingsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!FleetWingsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `FleetWingsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : FleetWingsResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `name` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("name").toString()));
        }
        // ensure the json data is an array
        if (!jsonObj.get("squads").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `squads` to be an array in the JSON string but got `%s`", jsonObj.get("squads")
                            .toString()));
        }

        JsonArray jsonArraysquads = jsonObj.getAsJsonArray("squads");
        // validate the required field `squads` (array)
        for (int i = 0; i < jsonArraysquads.size(); i++) {
            Squad.validateJsonObject(jsonArraysquads.get(i).getAsJsonObject());
        };
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!FleetWingsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'FleetWingsResponse'
                             // and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FleetWingsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(FleetWingsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<FleetWingsResponse>() {
                @Override
                public void write(JsonWriter out, FleetWingsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public FleetWingsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of FleetWingsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of FleetWingsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             FleetWingsResponse
     */
    public static FleetWingsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, FleetWingsResponse.class);
    }

    /**
     * Convert an instance of FleetWingsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
