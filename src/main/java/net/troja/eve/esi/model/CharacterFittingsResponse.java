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
import net.troja.eve.esi.model.FittingItem;
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
public class CharacterFittingsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;

    public static final String SERIALIZED_NAME_FITTING_ID = "fitting_id";
    @SerializedName(SERIALIZED_NAME_FITTING_ID)
    private Integer fittingId;

    public static final String SERIALIZED_NAME_ITEMS = "items";
    @SerializedName(SERIALIZED_NAME_ITEMS)
    private List<FittingItem> items = new ArrayList<>();

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_SHIP_TYPE_ID = "ship_type_id";
    @SerializedName(SERIALIZED_NAME_SHIP_TYPE_ID)
    private Integer shipTypeId;

    public CharacterFittingsResponse() {
    }

    public CharacterFittingsResponse description(String description) {

        this.description = description;
        return this;
    }

    /**
     * description string
     * 
     * @return description
     **/
    @javax.annotation.Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterFittingsResponse fittingId(Integer fittingId) {

        this.fittingId = fittingId;
        return this;
    }

    /**
     * fitting_id integer
     * 
     * @return fittingId
     **/
    @javax.annotation.Nonnull
    public Integer getFittingId() {
        return fittingId;
    }

    public void setFittingId(Integer fittingId) {
        this.fittingId = fittingId;
    }

    public CharacterFittingsResponse items(List<FittingItem> items) {

        this.items = items;
        return this;
    }

    public CharacterFittingsResponse addItemsItem(FittingItem itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * items array
     * 
     * @return items
     **/
    @javax.annotation.Nonnull
    public List<FittingItem> getItems() {
        return items;
    }

    public void setItems(List<FittingItem> items) {
        this.items = items;
    }

    public CharacterFittingsResponse name(String name) {

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

    public CharacterFittingsResponse shipTypeId(Integer shipTypeId) {

        this.shipTypeId = shipTypeId;
        return this;
    }

    /**
     * ship_type_id integer
     * 
     * @return shipTypeId
     **/
    @javax.annotation.Nonnull
    public Integer getShipTypeId() {
        return shipTypeId;
    }

    public void setShipTypeId(Integer shipTypeId) {
        this.shipTypeId = shipTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterFittingsResponse characterFittingsResponse = (CharacterFittingsResponse) o;
        return Objects.equals(this.description, characterFittingsResponse.description)
                && Objects.equals(this.fittingId, characterFittingsResponse.fittingId)
                && Objects.equals(this.items, characterFittingsResponse.items)
                && Objects.equals(this.name, characterFittingsResponse.name)
                && Objects.equals(this.shipTypeId, characterFittingsResponse.shipTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, fittingId, items, name, shipTypeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterFittingsResponse {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    fittingId: ").append(toIndentedString(fittingId)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    shipTypeId: ").append(toIndentedString(shipTypeId)).append("\n");
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
        openapiFields.add("description");
        openapiFields.add("fitting_id");
        openapiFields.add("items");
        openapiFields.add("name");
        openapiFields.add("ship_type_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("description");
        openapiRequiredFields.add("fitting_id");
        openapiRequiredFields.add("items");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("ship_type_id");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterFittingsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterFittingsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                              // required
                                                                              // fields
                                                                              // but
                                                                              // JSON
                                                                              // object
                                                                              // is
                                                                              // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CharacterFittingsResponse is not found in the empty JSON string",
                        CharacterFittingsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterFittingsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterFittingsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterFittingsResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("description").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj
                            .get("description").toString()));
        }
        // ensure the json data is an array
        if (!jsonObj.get("items").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `items` to be an array in the JSON string but got `%s`", jsonObj.get("items")
                            .toString()));
        }

        JsonArray jsonArrayitems = jsonObj.getAsJsonArray("items");
        // validate the required field `items` (array)
        for (int i = 0; i < jsonArrayitems.size(); i++) {
            FittingItem.validateJsonObject(jsonArrayitems.get(i).getAsJsonObject());
        };
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
            if (!CharacterFittingsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterFittingsResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterFittingsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterFittingsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterFittingsResponse>() {
                @Override
                public void write(JsonWriter out, CharacterFittingsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterFittingsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterFittingsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterFittingsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterFittingsResponse
     */
    public static CharacterFittingsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterFittingsResponse.class);
    }

    /**
     * Convert an instance of CharacterFittingsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
