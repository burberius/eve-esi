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
public class RegionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CONSTELLATIONS = "constellations";
    @SerializedName(SERIALIZED_NAME_CONSTELLATIONS)
    private List<Integer> constellations = new ArrayList<>();

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_REGION_ID = "region_id";
    @SerializedName(SERIALIZED_NAME_REGION_ID)
    private Integer regionId;

    public RegionResponse() {
    }

    public RegionResponse constellations(List<Integer> constellations) {

        this.constellations = constellations;
        return this;
    }

    public RegionResponse addConstellationsItem(Integer constellationsItem) {
        if (this.constellations == null) {
            this.constellations = new ArrayList<>();
        }
        this.constellations.add(constellationsItem);
        return this;
    }

    /**
     * constellations array
     * 
     * @return constellations
     **/
    @javax.annotation.Nonnull
    public List<Integer> getConstellations() {
        return constellations;
    }

    public void setConstellations(List<Integer> constellations) {
        this.constellations = constellations;
    }

    public RegionResponse description(String description) {

        this.description = description;
        return this;
    }

    /**
     * description string
     * 
     * @return description
     **/
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RegionResponse name(String name) {

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

    public RegionResponse regionId(Integer regionId) {

        this.regionId = regionId;
        return this;
    }

    /**
     * region_id integer
     * 
     * @return regionId
     **/
    @javax.annotation.Nonnull
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegionResponse regionResponse = (RegionResponse) o;
        return Objects.equals(this.constellations, regionResponse.constellations)
                && Objects.equals(this.description, regionResponse.description)
                && Objects.equals(this.name, regionResponse.name)
                && Objects.equals(this.regionId, regionResponse.regionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constellations, description, name, regionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegionResponse {\n");
        sb.append("    constellations: ").append(toIndentedString(constellations)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
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
        openapiFields.add("constellations");
        openapiFields.add("description");
        openapiFields.add("name");
        openapiFields.add("region_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("constellations");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("region_id");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to RegionResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!RegionResponse.openapiRequiredFields.isEmpty()) { // has
                                                                   // required
                                                                   // fields but
                                                                   // JSON
                                                                   // object is
                                                                   // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in RegionResponse is not found in the empty JSON string",
                        RegionResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!RegionResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `RegionResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : RegionResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        // ensure the required json array is present
        if (jsonObj.get("constellations") == null) {
            throw new IllegalArgumentException(
                    "Expected the field `linkedContent` to be an array in the JSON string but got `null`");
        } else if (!jsonObj.get("constellations").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `constellations` to be an array in the JSON string but got `%s`",
                    jsonObj.get("constellations").toString()));
        }
        if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull())
                && !jsonObj.get("description").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj
                            .get("description").toString()));
        }
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `name` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("name").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RegionResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RegionResponse' and
                             // its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RegionResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(RegionResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<RegionResponse>() {
                @Override
                public void write(JsonWriter out, RegionResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RegionResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RegionResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of RegionResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to RegionResponse
     */
    public static RegionResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RegionResponse.class);
    }

    /**
     * Convert an instance of RegionResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
