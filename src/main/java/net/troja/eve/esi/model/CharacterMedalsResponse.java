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
import java.util.ArrayList;
import java.util.List;
import net.troja.eve.esi.model.CharacterMedalsGraphic;
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
public class CharacterMedalsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CORPORATION_ID = "corporation_id";
    @SerializedName(SERIALIZED_NAME_CORPORATION_ID)
    private Integer corporationId;

    public static final String SERIALIZED_NAME_DATE = "date";
    @SerializedName(SERIALIZED_NAME_DATE)
    private OffsetDateTime date;

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;

    public static final String SERIALIZED_NAME_GRAPHICS = "graphics";
    @SerializedName(SERIALIZED_NAME_GRAPHICS)
    private List<CharacterMedalsGraphic> graphics = new ArrayList<>();

    public static final String SERIALIZED_NAME_ISSUER_ID = "issuer_id";
    @SerializedName(SERIALIZED_NAME_ISSUER_ID)
    private Integer issuerId;

    public static final String SERIALIZED_NAME_MEDAL_ID = "medal_id";
    @SerializedName(SERIALIZED_NAME_MEDAL_ID)
    private Integer medalId;

    public static final String SERIALIZED_NAME_REASON = "reason";
    @SerializedName(SERIALIZED_NAME_REASON)
    private String reason;

    /**
     * status string
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        PUBLIC("public"),

        PRIVATE("private");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private String status;
    private StatusEnum statusEnum;

    public static final String SERIALIZED_NAME_TITLE = "title";
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;

    public CharacterMedalsResponse() {
    }

    public CharacterMedalsResponse corporationId(Integer corporationId) {

        this.corporationId = corporationId;
        return this;
    }

    /**
     * corporation_id integer
     * 
     * @return corporationId
     **/
    @javax.annotation.Nonnull
    public Integer getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    public CharacterMedalsResponse date(OffsetDateTime date) {

        this.date = date;
        return this;
    }

    /**
     * date string
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

    public CharacterMedalsResponse description(String description) {

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

    public CharacterMedalsResponse graphics(List<CharacterMedalsGraphic> graphics) {

        this.graphics = graphics;
        return this;
    }

    public CharacterMedalsResponse addGraphicsItem(CharacterMedalsGraphic graphicsItem) {
        if (this.graphics == null) {
            this.graphics = new ArrayList<>();
        }
        this.graphics.add(graphicsItem);
        return this;
    }

    /**
     * graphics array
     * 
     * @return graphics
     **/
    @javax.annotation.Nonnull
    public List<CharacterMedalsGraphic> getGraphics() {
        return graphics;
    }

    public void setGraphics(List<CharacterMedalsGraphic> graphics) {
        this.graphics = graphics;
    }

    public CharacterMedalsResponse issuerId(Integer issuerId) {

        this.issuerId = issuerId;
        return this;
    }

    /**
     * issuer_id integer
     * 
     * @return issuerId
     **/
    @javax.annotation.Nonnull
    public Integer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Integer issuerId) {
        this.issuerId = issuerId;
    }

    public CharacterMedalsResponse medalId(Integer medalId) {

        this.medalId = medalId;
        return this;
    }

    /**
     * medal_id integer
     * 
     * @return medalId
     **/
    @javax.annotation.Nonnull
    public Integer getMedalId() {
        return medalId;
    }

    public void setMedalId(Integer medalId) {
        this.medalId = medalId;
    }

    public CharacterMedalsResponse reason(String reason) {

        this.reason = reason;
        return this;
    }

    /**
     * reason string
     * 
     * @return reason
     **/
    @javax.annotation.Nonnull
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CharacterMedalsResponse statusString(String status) {

        this.status = status;
        return this;
    }

    public CharacterMedalsResponse status(StatusEnum statusEnum) {

        this.statusEnum = statusEnum;
        return this;
    }

    /**
     * status string
     * 
     * @return status
     **/
    @javax.annotation.Nonnull
    public StatusEnum getStatus() {
        if (statusEnum == null) {
            statusEnum = StatusEnum.fromValue(status);
        }
        return statusEnum;
    }

    public String getStatusString() {
        return status;
    }

    public void setStatus(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public void setStatusString(String status) {
        this.status = status;
    }

    public CharacterMedalsResponse title(String title) {

        this.title = title;
        return this;
    }

    /**
     * title string
     * 
     * @return title
     **/
    @javax.annotation.Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterMedalsResponse characterMedalsResponse = (CharacterMedalsResponse) o;
        return Objects.equals(this.corporationId, characterMedalsResponse.corporationId)
                && Objects.equals(this.date, characterMedalsResponse.date)
                && Objects.equals(this.description, characterMedalsResponse.description)
                && Objects.equals(this.graphics, characterMedalsResponse.graphics)
                && Objects.equals(this.issuerId, characterMedalsResponse.issuerId)
                && Objects.equals(this.medalId, characterMedalsResponse.medalId)
                && Objects.equals(this.reason, characterMedalsResponse.reason)
                && Objects.equals(this.status, characterMedalsResponse.status)
                && Objects.equals(this.title, characterMedalsResponse.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corporationId, date, description, graphics, issuerId, medalId, reason, status, title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterMedalsResponse {\n");
        sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    graphics: ").append(toIndentedString(graphics)).append("\n");
        sb.append("    issuerId: ").append(toIndentedString(issuerId)).append("\n");
        sb.append("    medalId: ").append(toIndentedString(medalId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
        openapiFields.add("corporation_id");
        openapiFields.add("date");
        openapiFields.add("description");
        openapiFields.add("graphics");
        openapiFields.add("issuer_id");
        openapiFields.add("medal_id");
        openapiFields.add("reason");
        openapiFields.add("status");
        openapiFields.add("title");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("corporation_id");
        openapiRequiredFields.add("date");
        openapiRequiredFields.add("description");
        openapiRequiredFields.add("graphics");
        openapiRequiredFields.add("issuer_id");
        openapiRequiredFields.add("medal_id");
        openapiRequiredFields.add("reason");
        openapiRequiredFields.add("status");
        openapiRequiredFields.add("title");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterMedalsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterMedalsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                            // required
                                                                            // fields
                                                                            // but
                                                                            // JSON
                                                                            // object
                                                                            // is
                                                                            // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CharacterMedalsResponse is not found in the empty JSON string",
                        CharacterMedalsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterMedalsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterMedalsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterMedalsResponse.openapiRequiredFields) {
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
        if (!jsonObj.get("graphics").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `graphics` to be an array in the JSON string but got `%s`",
                    jsonObj.get("graphics").toString()));
        }

        JsonArray jsonArraygraphics = jsonObj.getAsJsonArray("graphics");
        // validate the required field `graphics` (array)
        for (int i = 0; i < jsonArraygraphics.size(); i++) {
            CharacterMedalsGraphic.validateJsonObject(jsonArraygraphics.get(i).getAsJsonObject());
        };
        if (!jsonObj.get("reason").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `reason` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("reason").toString()));
        }
        if (!jsonObj.get("status").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `status` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("status").toString()));
        }
        if (!jsonObj.get("title").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `title` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("title").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CharacterMedalsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterMedalsResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterMedalsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterMedalsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterMedalsResponse>() {
                @Override
                public void write(JsonWriter out, CharacterMedalsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterMedalsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterMedalsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterMedalsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterMedalsResponse
     */
    public static CharacterMedalsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterMedalsResponse.class);
    }

    /**
     * Convert an instance of CharacterMedalsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
