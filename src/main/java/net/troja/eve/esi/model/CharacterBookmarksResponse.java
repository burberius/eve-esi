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
import net.troja.eve.esi.model.CharacterBookmarkItem;
import net.troja.eve.esi.model.CharacterBookmarksCoordinates;
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
public class CharacterBookmarksResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_BOOKMARK_ID = "bookmark_id";
    @SerializedName(SERIALIZED_NAME_BOOKMARK_ID)
    private Integer bookmarkId;

    public static final String SERIALIZED_NAME_COORDINATES = "coordinates";
    @SerializedName(SERIALIZED_NAME_COORDINATES)
    private CharacterBookmarksCoordinates coordinates;

    public static final String SERIALIZED_NAME_CREATED = "created";
    @SerializedName(SERIALIZED_NAME_CREATED)
    private OffsetDateTime created;

    public static final String SERIALIZED_NAME_CREATOR_ID = "creator_id";
    @SerializedName(SERIALIZED_NAME_CREATOR_ID)
    private Integer creatorId;

    public static final String SERIALIZED_NAME_FOLDER_ID = "folder_id";
    @SerializedName(SERIALIZED_NAME_FOLDER_ID)
    private Integer folderId;

    public static final String SERIALIZED_NAME_ITEM = "item";
    @SerializedName(SERIALIZED_NAME_ITEM)
    private CharacterBookmarkItem item;

    public static final String SERIALIZED_NAME_LABEL = "label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    private String label;

    public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
    @SerializedName(SERIALIZED_NAME_LOCATION_ID)
    private Integer locationId;

    public static final String SERIALIZED_NAME_NOTES = "notes";
    @SerializedName(SERIALIZED_NAME_NOTES)
    private String notes;

    public CharacterBookmarksResponse() {
    }

    public CharacterBookmarksResponse bookmarkId(Integer bookmarkId) {

        this.bookmarkId = bookmarkId;
        return this;
    }

    /**
     * bookmark_id integer
     * 
     * @return bookmarkId
     **/
    @javax.annotation.Nonnull
    public Integer getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Integer bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public CharacterBookmarksResponse coordinates(CharacterBookmarksCoordinates coordinates) {

        this.coordinates = coordinates;
        return this;
    }

    /**
     * Get coordinates
     * 
     * @return coordinates
     **/
    @javax.annotation.Nullable
    public CharacterBookmarksCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CharacterBookmarksCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public CharacterBookmarksResponse created(OffsetDateTime created) {

        this.created = created;
        return this;
    }

    /**
     * created string
     * 
     * @return created
     **/
    @javax.annotation.Nonnull
    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public CharacterBookmarksResponse creatorId(Integer creatorId) {

        this.creatorId = creatorId;
        return this;
    }

    /**
     * creator_id integer
     * 
     * @return creatorId
     **/
    @javax.annotation.Nonnull
    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public CharacterBookmarksResponse folderId(Integer folderId) {

        this.folderId = folderId;
        return this;
    }

    /**
     * folder_id integer
     * 
     * @return folderId
     **/
    @javax.annotation.Nullable
    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public CharacterBookmarksResponse item(CharacterBookmarkItem item) {

        this.item = item;
        return this;
    }

    /**
     * Get item
     * 
     * @return item
     **/
    @javax.annotation.Nullable
    public CharacterBookmarkItem getItem() {
        return item;
    }

    public void setItem(CharacterBookmarkItem item) {
        this.item = item;
    }

    public CharacterBookmarksResponse label(String label) {

        this.label = label;
        return this;
    }

    /**
     * label string
     * 
     * @return label
     **/
    @javax.annotation.Nonnull
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CharacterBookmarksResponse locationId(Integer locationId) {

        this.locationId = locationId;
        return this;
    }

    /**
     * location_id integer
     * 
     * @return locationId
     **/
    @javax.annotation.Nonnull
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public CharacterBookmarksResponse notes(String notes) {

        this.notes = notes;
        return this;
    }

    /**
     * notes string
     * 
     * @return notes
     **/
    @javax.annotation.Nonnull
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterBookmarksResponse characterBookmarksResponse = (CharacterBookmarksResponse) o;
        return Objects.equals(this.bookmarkId, characterBookmarksResponse.bookmarkId)
                && Objects.equals(this.coordinates, characterBookmarksResponse.coordinates)
                && Objects.equals(this.created, characterBookmarksResponse.created)
                && Objects.equals(this.creatorId, characterBookmarksResponse.creatorId)
                && Objects.equals(this.folderId, characterBookmarksResponse.folderId)
                && Objects.equals(this.item, characterBookmarksResponse.item)
                && Objects.equals(this.label, characterBookmarksResponse.label)
                && Objects.equals(this.locationId, characterBookmarksResponse.locationId)
                && Objects.equals(this.notes, characterBookmarksResponse.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookmarkId, coordinates, created, creatorId, folderId, item, label, locationId, notes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterBookmarksResponse {\n");
        sb.append("    bookmarkId: ").append(toIndentedString(bookmarkId)).append("\n");
        sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
        sb.append("    item: ").append(toIndentedString(item)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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
        openapiFields.add("bookmark_id");
        openapiFields.add("coordinates");
        openapiFields.add("created");
        openapiFields.add("creator_id");
        openapiFields.add("folder_id");
        openapiFields.add("item");
        openapiFields.add("label");
        openapiFields.add("location_id");
        openapiFields.add("notes");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("bookmark_id");
        openapiRequiredFields.add("created");
        openapiRequiredFields.add("creator_id");
        openapiRequiredFields.add("label");
        openapiRequiredFields.add("location_id");
        openapiRequiredFields.add("notes");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterBookmarksResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterBookmarksResponse.openapiRequiredFields.isEmpty()) { // has
                                                                               // required
                                                                               // fields
                                                                               // but
                                                                               // JSON
                                                                               // object
                                                                               // is
                                                                               // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CharacterBookmarksResponse is not found in the empty JSON string",
                        CharacterBookmarksResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterBookmarksResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterBookmarksResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterBookmarksResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        // validate the optional field `coordinates`
        if (jsonObj.get("coordinates") != null && !jsonObj.get("coordinates").isJsonNull()) {
            CharacterBookmarksCoordinates.validateJsonObject(jsonObj.getAsJsonObject("coordinates"));
        }
        // validate the optional field `item`
        if (jsonObj.get("item") != null && !jsonObj.get("item").isJsonNull()) {
            CharacterBookmarkItem.validateJsonObject(jsonObj.getAsJsonObject("item"));
        }
        if (!jsonObj.get("label").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `label` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("label").toString()));
        }
        if (!jsonObj.get("notes").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `notes` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("notes").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CharacterBookmarksResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterBookmarksResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterBookmarksResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterBookmarksResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterBookmarksResponse>() {
                @Override
                public void write(JsonWriter out, CharacterBookmarksResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterBookmarksResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterBookmarksResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterBookmarksResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterBookmarksResponse
     */
    public static CharacterBookmarksResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterBookmarksResponse.class);
    }

    /**
     * Convert an instance of CharacterBookmarksResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
