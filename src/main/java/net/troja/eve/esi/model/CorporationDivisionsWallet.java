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
 * wallet object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CorporationDivisionsWallet implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_DIVISION = "division";
    @SerializedName(SERIALIZED_NAME_DIVISION)
    private Integer division;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public CorporationDivisionsWallet() {
    }

    public CorporationDivisionsWallet division(Integer division) {

        this.division = division;
        return this;
    }

    /**
     * division integer minimum: 1 maximum: 7
     * 
     * @return division
     **/
    @javax.annotation.Nullable
    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public CorporationDivisionsWallet name(String name) {

        this.name = name;
        return this;
    }

    /**
     * name string
     * 
     * @return name
     **/
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CorporationDivisionsWallet corporationDivisionsWallet = (CorporationDivisionsWallet) o;
        return Objects.equals(this.division, corporationDivisionsWallet.division)
                && Objects.equals(this.name, corporationDivisionsWallet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CorporationDivisionsWallet {\n");
        sb.append("    division: ").append(toIndentedString(division)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
        openapiFields.add("division");
        openapiFields.add("name");

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
     *             CorporationDivisionsWallet
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CorporationDivisionsWallet.openapiRequiredFields.isEmpty()) { // has
                                                                               // required
                                                                               // fields
                                                                               // but
                                                                               // JSON
                                                                               // object
                                                                               // is
                                                                               // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CorporationDivisionsWallet is not found in the empty JSON string",
                        CorporationDivisionsWallet.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CorporationDivisionsWallet.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CorporationDivisionsWallet` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }
        if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull())
                && !jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `name` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("name").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CorporationDivisionsWallet.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CorporationDivisionsWallet' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CorporationDivisionsWallet> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CorporationDivisionsWallet.class));

            return (TypeAdapter<T>) new TypeAdapter<CorporationDivisionsWallet>() {
                @Override
                public void write(JsonWriter out, CorporationDivisionsWallet value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CorporationDivisionsWallet read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CorporationDivisionsWallet given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CorporationDivisionsWallet
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CorporationDivisionsWallet
     */
    public static CorporationDivisionsWallet fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CorporationDivisionsWallet.class);
    }

    /**
     * Convert an instance of CorporationDivisionsWallet to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
