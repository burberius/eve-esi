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
 * new_mail object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UiNewMail implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_BODY = "body";
    @SerializedName(SERIALIZED_NAME_BODY)
    private String body;

    public static final String SERIALIZED_NAME_RECIPIENTS = "recipients";
    @SerializedName(SERIALIZED_NAME_RECIPIENTS)
    private List<Integer> recipients = new ArrayList<>();

    public static final String SERIALIZED_NAME_SUBJECT = "subject";
    @SerializedName(SERIALIZED_NAME_SUBJECT)
    private String subject;

    public static final String SERIALIZED_NAME_TO_CORP_OR_ALLIANCE_ID = "to_corp_or_alliance_id";
    @SerializedName(SERIALIZED_NAME_TO_CORP_OR_ALLIANCE_ID)
    private Integer toCorpOrAllianceId;

    public static final String SERIALIZED_NAME_TO_MAILING_LIST_ID = "to_mailing_list_id";
    @SerializedName(SERIALIZED_NAME_TO_MAILING_LIST_ID)
    private Integer toMailingListId;

    public UiNewMail() {
    }

    public UiNewMail body(String body) {

        this.body = body;
        return this;
    }

    /**
     * body string
     * 
     * @return body
     **/
    @javax.annotation.Nonnull
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UiNewMail recipients(List<Integer> recipients) {

        this.recipients = recipients;
        return this;
    }

    public UiNewMail addRecipientsItem(Integer recipientsItem) {
        if (this.recipients == null) {
            this.recipients = new ArrayList<>();
        }
        this.recipients.add(recipientsItem);
        return this;
    }

    /**
     * recipients array
     * 
     * @return recipients
     **/
    @javax.annotation.Nonnull
    public List<Integer> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Integer> recipients) {
        this.recipients = recipients;
    }

    public UiNewMail subject(String subject) {

        this.subject = subject;
        return this;
    }

    /**
     * subject string
     * 
     * @return subject
     **/
    @javax.annotation.Nonnull
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UiNewMail toCorpOrAllianceId(Integer toCorpOrAllianceId) {

        this.toCorpOrAllianceId = toCorpOrAllianceId;
        return this;
    }

    /**
     * to_corp_or_alliance_id integer
     * 
     * @return toCorpOrAllianceId
     **/
    @javax.annotation.Nullable
    public Integer getToCorpOrAllianceId() {
        return toCorpOrAllianceId;
    }

    public void setToCorpOrAllianceId(Integer toCorpOrAllianceId) {
        this.toCorpOrAllianceId = toCorpOrAllianceId;
    }

    public UiNewMail toMailingListId(Integer toMailingListId) {

        this.toMailingListId = toMailingListId;
        return this;
    }

    /**
     * Corporations, alliances and mailing lists are all types of mailing
     * groups. You may only send to one mailing group, at a time, so you may
     * fill out either this field or the to_corp_or_alliance_ids field
     * 
     * @return toMailingListId
     **/
    @javax.annotation.Nullable
    public Integer getToMailingListId() {
        return toMailingListId;
    }

    public void setToMailingListId(Integer toMailingListId) {
        this.toMailingListId = toMailingListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UiNewMail uiNewMail = (UiNewMail) o;
        return Objects.equals(this.body, uiNewMail.body) && Objects.equals(this.recipients, uiNewMail.recipients)
                && Objects.equals(this.subject, uiNewMail.subject)
                && Objects.equals(this.toCorpOrAllianceId, uiNewMail.toCorpOrAllianceId)
                && Objects.equals(this.toMailingListId, uiNewMail.toMailingListId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, recipients, subject, toCorpOrAllianceId, toMailingListId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UiNewMail {\n");
        sb.append("    body: ").append(toIndentedString(body)).append("\n");
        sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    toCorpOrAllianceId: ").append(toIndentedString(toCorpOrAllianceId)).append("\n");
        sb.append("    toMailingListId: ").append(toIndentedString(toMailingListId)).append("\n");
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
        openapiFields.add("body");
        openapiFields.add("recipients");
        openapiFields.add("subject");
        openapiFields.add("to_corp_or_alliance_id");
        openapiFields.add("to_mailing_list_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("body");
        openapiRequiredFields.add("recipients");
        openapiRequiredFields.add("subject");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to UiNewMail
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!UiNewMail.openapiRequiredFields.isEmpty()) { // has required
                                                              // fields but JSON
                                                              // object is null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in UiNewMail is not found in the empty JSON string",
                        UiNewMail.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!UiNewMail.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format(
                        "The field `%s` in the JSON string is not defined in the `UiNewMail` properties. JSON: %s",
                        entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : UiNewMail.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("body").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `body` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("body").toString()));
        }
        // ensure the required json array is present
        if (jsonObj.get("recipients") == null) {
            throw new IllegalArgumentException(
                    "Expected the field `linkedContent` to be an array in the JSON string but got `null`");
        } else if (!jsonObj.get("recipients").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `recipients` to be an array in the JSON string but got `%s`",
                    jsonObj.get("recipients").toString()));
        }
        if (!jsonObj.get("subject").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `subject` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("subject").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!UiNewMail.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'UiNewMail' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<UiNewMail> thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(UiNewMail.class));

            return (TypeAdapter<T>) new TypeAdapter<UiNewMail>() {
                @Override
                public void write(JsonWriter out, UiNewMail value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public UiNewMail read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of UiNewMail given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of UiNewMail
     * @throws IOException
     *             if the JSON string is invalid with respect to UiNewMail
     */
    public static UiNewMail fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, UiNewMail.class);
    }

    /**
     * Convert an instance of UiNewMail to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
