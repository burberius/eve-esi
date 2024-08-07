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
import net.troja.eve.esi.model.MailLabel;
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
public class MailLabelsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_LABELS = "labels";
    @SerializedName(SERIALIZED_NAME_LABELS)
    private List<MailLabel> labels;

    public static final String SERIALIZED_NAME_TOTAL_UNREAD_COUNT = "total_unread_count";
    @SerializedName(SERIALIZED_NAME_TOTAL_UNREAD_COUNT)
    private Integer totalUnreadCount;

    public MailLabelsResponse() {
    }

    public MailLabelsResponse labels(List<MailLabel> labels) {

        this.labels = labels;
        return this;
    }

    public MailLabelsResponse addLabelsItem(MailLabel labelsItem) {
        if (this.labels == null) {
            this.labels = new ArrayList<>();
        }
        this.labels.add(labelsItem);
        return this;
    }

    /**
     * labels array
     * 
     * @return labels
     **/
    @javax.annotation.Nullable
    public List<MailLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<MailLabel> labels) {
        this.labels = labels;
    }

    public MailLabelsResponse totalUnreadCount(Integer totalUnreadCount) {

        this.totalUnreadCount = totalUnreadCount;
        return this;
    }

    /**
     * total_unread_count integer minimum: 0
     * 
     * @return totalUnreadCount
     **/
    @javax.annotation.Nullable
    public Integer getTotalUnreadCount() {
        return totalUnreadCount;
    }

    public void setTotalUnreadCount(Integer totalUnreadCount) {
        this.totalUnreadCount = totalUnreadCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MailLabelsResponse mailLabelsResponse = (MailLabelsResponse) o;
        return Objects.equals(this.labels, mailLabelsResponse.labels)
                && Objects.equals(this.totalUnreadCount, mailLabelsResponse.totalUnreadCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, totalUnreadCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailLabelsResponse {\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    totalUnreadCount: ").append(toIndentedString(totalUnreadCount)).append("\n");
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
        openapiFields.add("labels");
        openapiFields.add("total_unread_count");

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
     *             MailLabelsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!MailLabelsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                       // required
                                                                       // fields
                                                                       // but
                                                                       // JSON
                                                                       // object
                                                                       // is
                                                                       // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in MailLabelsResponse is not found in the empty JSON string",
                        MailLabelsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!MailLabelsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `MailLabelsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }
        if (jsonObj.get("labels") != null && !jsonObj.get("labels").isJsonNull()) {
            JsonArray jsonArraylabels = jsonObj.getAsJsonArray("labels");
            if (jsonArraylabels != null) {
                // ensure the json data is an array
                if (!jsonObj.get("labels").isJsonArray()) {
                    throw new IllegalArgumentException(String.format(
                            "Expected the field `labels` to be an array in the JSON string but got `%s`",
                            jsonObj.get("labels").toString()));
                }

                // validate the optional field `labels` (array)
                for (int i = 0; i < jsonArraylabels.size(); i++) {
                    MailLabel.validateJsonObject(jsonArraylabels.get(i).getAsJsonObject());
                };
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!MailLabelsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'MailLabelsResponse'
                             // and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<MailLabelsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(MailLabelsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<MailLabelsResponse>() {
                @Override
                public void write(JsonWriter out, MailLabelsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public MailLabelsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of MailLabelsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of MailLabelsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             MailLabelsResponse
     */
    public static MailLabelsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, MailLabelsResponse.class);
    }

    /**
     * Convert an instance of MailLabelsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
