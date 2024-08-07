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
public class CharacterStandingsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_FROM_ID = "from_id";
    @SerializedName(SERIALIZED_NAME_FROM_ID)
    private Integer fromId;

    /**
     * from_type string
     */
    @JsonAdapter(FromTypeEnum.Adapter.class)
    public enum FromTypeEnum {
        AGENT("agent"),

        NPC_CORP("npc_corp"),

        FACTION("faction");

        private String value;

        FromTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static FromTypeEnum fromValue(String value) {
            for (FromTypeEnum b : FromTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<FromTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FromTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FromTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FromTypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_FROM_TYPE = "from_type";
    @SerializedName(SERIALIZED_NAME_FROM_TYPE)
    private String fromType;
    private FromTypeEnum fromTypeEnum;

    public static final String SERIALIZED_NAME_STANDING = "standing";
    @SerializedName(SERIALIZED_NAME_STANDING)
    private Float standing;

    public CharacterStandingsResponse() {
    }

    public CharacterStandingsResponse fromId(Integer fromId) {

        this.fromId = fromId;
        return this;
    }

    /**
     * from_id integer
     * 
     * @return fromId
     **/
    @javax.annotation.Nonnull
    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public CharacterStandingsResponse fromTypeString(String fromType) {

        this.fromType = fromType;
        return this;
    }

    public CharacterStandingsResponse fromType(FromTypeEnum fromTypeEnum) {

        this.fromTypeEnum = fromTypeEnum;
        return this;
    }

    /**
     * from_type string
     * 
     * @return fromType
     **/
    @javax.annotation.Nonnull
    public FromTypeEnum getFromType() {
        if (fromTypeEnum == null) {
            fromTypeEnum = FromTypeEnum.fromValue(fromType);
        }
        return fromTypeEnum;
    }

    public String getFromTypeString() {
        return fromType;
    }

    public void setFromType(FromTypeEnum fromTypeEnum) {
        this.fromTypeEnum = fromTypeEnum;
    }

    public void setFromTypeString(String fromType) {
        this.fromType = fromType;
    }

    public CharacterStandingsResponse standing(Float standing) {

        this.standing = standing;
        return this;
    }

    /**
     * standing number
     * 
     * @return standing
     **/
    @javax.annotation.Nonnull
    public Float getStanding() {
        return standing;
    }

    public void setStanding(Float standing) {
        this.standing = standing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterStandingsResponse characterStandingsResponse = (CharacterStandingsResponse) o;
        return Objects.equals(this.fromId, characterStandingsResponse.fromId)
                && Objects.equals(this.fromType, characterStandingsResponse.fromType)
                && Objects.equals(this.standing, characterStandingsResponse.standing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromId, fromType, standing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterStandingsResponse {\n");
        sb.append("    fromId: ").append(toIndentedString(fromId)).append("\n");
        sb.append("    fromType: ").append(toIndentedString(fromType)).append("\n");
        sb.append("    standing: ").append(toIndentedString(standing)).append("\n");
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
        openapiFields.add("from_id");
        openapiFields.add("from_type");
        openapiFields.add("standing");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("from_id");
        openapiRequiredFields.add("from_type");
        openapiRequiredFields.add("standing");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterStandingsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterStandingsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                               // required
                                                                               // fields
                                                                               // but
                                                                               // JSON
                                                                               // object
                                                                               // is
                                                                               // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CharacterStandingsResponse is not found in the empty JSON string",
                        CharacterStandingsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterStandingsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterStandingsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterStandingsResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("from_type").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `from_type` to be a primitive type in the JSON string but got `%s`", jsonObj
                            .get("from_type").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CharacterStandingsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterStandingsResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterStandingsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterStandingsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterStandingsResponse>() {
                @Override
                public void write(JsonWriter out, CharacterStandingsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterStandingsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterStandingsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterStandingsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterStandingsResponse
     */
    public static CharacterStandingsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterStandingsResponse.class);
    }

    /**
     * Convert an instance of CharacterStandingsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
