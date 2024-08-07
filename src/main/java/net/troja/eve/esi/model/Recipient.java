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
 * recipient object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Recipient implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_RECIPIENT_ID = "recipient_id";
    @SerializedName(SERIALIZED_NAME_RECIPIENT_ID)
    private Integer recipientId;

    /**
     * recipient_type string
     */
    @JsonAdapter(RecipientTypeEnum.Adapter.class)
    public enum RecipientTypeEnum {
        ALLIANCE("alliance"),

        CHARACTER("character"),

        CORPORATION("corporation"),

        MAILING_LIST("mailing_list");

        private String value;

        RecipientTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RecipientTypeEnum fromValue(String value) {
            for (RecipientTypeEnum b : RecipientTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<RecipientTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecipientTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RecipientTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RecipientTypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_RECIPIENT_TYPE = "recipient_type";
    @SerializedName(SERIALIZED_NAME_RECIPIENT_TYPE)
    private String recipientType;
    private RecipientTypeEnum recipientTypeEnum;

    public Recipient() {
    }

    public Recipient recipientId(Integer recipientId) {

        this.recipientId = recipientId;
        return this;
    }

    /**
     * recipient_id integer
     * 
     * @return recipientId
     **/
    @javax.annotation.Nonnull
    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Recipient recipientTypeString(String recipientType) {

        this.recipientType = recipientType;
        return this;
    }

    public Recipient recipientType(RecipientTypeEnum recipientTypeEnum) {

        this.recipientTypeEnum = recipientTypeEnum;
        return this;
    }

    /**
     * recipient_type string
     * 
     * @return recipientType
     **/
    @javax.annotation.Nonnull
    public RecipientTypeEnum getRecipientType() {
        if (recipientTypeEnum == null) {
            recipientTypeEnum = RecipientTypeEnum.fromValue(recipientType);
        }
        return recipientTypeEnum;
    }

    public String getRecipientTypeString() {
        return recipientType;
    }

    public void setRecipientType(RecipientTypeEnum recipientTypeEnum) {
        this.recipientTypeEnum = recipientTypeEnum;
    }

    public void setRecipientTypeString(String recipientType) {
        this.recipientType = recipientType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipient recipient = (Recipient) o;
        return Objects.equals(this.recipientId, recipient.recipientId)
                && Objects.equals(this.recipientType, recipient.recipientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientId, recipientType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recipient {\n");
        sb.append("    recipientId: ").append(toIndentedString(recipientId)).append("\n");
        sb.append("    recipientType: ").append(toIndentedString(recipientType)).append("\n");
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
        openapiFields.add("recipient_id");
        openapiFields.add("recipient_type");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("recipient_id");
        openapiRequiredFields.add("recipient_type");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to Recipient
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!Recipient.openapiRequiredFields.isEmpty()) { // has required
                                                              // fields but JSON
                                                              // object is null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in Recipient is not found in the empty JSON string",
                        Recipient.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!Recipient.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format(
                        "The field `%s` in the JSON string is not defined in the `Recipient` properties. JSON: %s",
                        entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : Recipient.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("recipient_type").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `recipient_type` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("recipient_type").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!Recipient.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'Recipient' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<Recipient> thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(Recipient.class));

            return (TypeAdapter<T>) new TypeAdapter<Recipient>() {
                @Override
                public void write(JsonWriter out, Recipient value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public Recipient read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of Recipient given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of Recipient
     * @throws IOException
     *             if the JSON string is invalid with respect to Recipient
     */
    public static Recipient fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, Recipient.class);
    }

    /**
     * Convert an instance of Recipient to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
