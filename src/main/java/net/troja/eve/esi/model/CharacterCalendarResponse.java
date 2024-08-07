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
 * event
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CharacterCalendarResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_EVENT_DATE = "event_date";
    @SerializedName(SERIALIZED_NAME_EVENT_DATE)
    private OffsetDateTime eventDate;

    public static final String SERIALIZED_NAME_EVENT_ID = "event_id";
    @SerializedName(SERIALIZED_NAME_EVENT_ID)
    private Integer eventId;

    /**
     * event_response string
     */
    @JsonAdapter(EventResponseEnum.Adapter.class)
    public enum EventResponseEnum {
        DECLINED("declined"),

        NOT_RESPONDED("not_responded"),

        ACCEPTED("accepted"),

        TENTATIVE("tentative");

        private String value;

        EventResponseEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EventResponseEnum fromValue(String value) {
            for (EventResponseEnum b : EventResponseEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EventResponseEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EventResponseEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EventResponseEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EventResponseEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_EVENT_RESPONSE = "event_response";
    @SerializedName(SERIALIZED_NAME_EVENT_RESPONSE)
    private String eventResponse;
    private EventResponseEnum eventResponseEnum;

    public static final String SERIALIZED_NAME_IMPORTANCE = "importance";
    @SerializedName(SERIALIZED_NAME_IMPORTANCE)
    private Integer importance;

    public static final String SERIALIZED_NAME_TITLE = "title";
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;

    public CharacterCalendarResponse() {
    }

    public CharacterCalendarResponse eventDate(OffsetDateTime eventDate) {

        this.eventDate = eventDate;
        return this;
    }

    /**
     * event_date string
     * 
     * @return eventDate
     **/
    @javax.annotation.Nullable
    public OffsetDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(OffsetDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public CharacterCalendarResponse eventId(Integer eventId) {

        this.eventId = eventId;
        return this;
    }

    /**
     * event_id integer
     * 
     * @return eventId
     **/
    @javax.annotation.Nullable
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public CharacterCalendarResponse eventResponseString(String eventResponse) {

        this.eventResponse = eventResponse;
        return this;
    }

    public CharacterCalendarResponse eventResponse(EventResponseEnum eventResponseEnum) {

        this.eventResponseEnum = eventResponseEnum;
        return this;
    }

    /**
     * event_response string
     * 
     * @return eventResponse
     **/
    @javax.annotation.Nullable
    public EventResponseEnum getEventResponse() {
        if (eventResponseEnum == null) {
            eventResponseEnum = EventResponseEnum.fromValue(eventResponse);
        }
        return eventResponseEnum;
    }

    public String getEventResponseString() {
        return eventResponse;
    }

    public void setEventResponse(EventResponseEnum eventResponseEnum) {
        this.eventResponseEnum = eventResponseEnum;
    }

    public void setEventResponseString(String eventResponse) {
        this.eventResponse = eventResponse;
    }

    public CharacterCalendarResponse importance(Integer importance) {

        this.importance = importance;
        return this;
    }

    /**
     * importance integer
     * 
     * @return importance
     **/
    @javax.annotation.Nullable
    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public CharacterCalendarResponse title(String title) {

        this.title = title;
        return this;
    }

    /**
     * title string
     * 
     * @return title
     **/
    @javax.annotation.Nullable
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
        CharacterCalendarResponse characterCalendarResponse = (CharacterCalendarResponse) o;
        return Objects.equals(this.eventDate, characterCalendarResponse.eventDate)
                && Objects.equals(this.eventId, characterCalendarResponse.eventId)
                && Objects.equals(this.eventResponse, characterCalendarResponse.eventResponse)
                && Objects.equals(this.importance, characterCalendarResponse.importance)
                && Objects.equals(this.title, characterCalendarResponse.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventDate, eventId, eventResponse, importance, title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterCalendarResponse {\n");
        sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
        sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
        sb.append("    eventResponse: ").append(toIndentedString(eventResponse)).append("\n");
        sb.append("    importance: ").append(toIndentedString(importance)).append("\n");
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
        openapiFields.add("event_date");
        openapiFields.add("event_id");
        openapiFields.add("event_response");
        openapiFields.add("importance");
        openapiFields.add("title");

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
     *             CharacterCalendarResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterCalendarResponse.openapiRequiredFields.isEmpty()) { // has
                                                                              // required
                                                                              // fields
                                                                              // but
                                                                              // JSON
                                                                              // object
                                                                              // is
                                                                              // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in CharacterCalendarResponse is not found in the empty JSON string",
                        CharacterCalendarResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterCalendarResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterCalendarResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }
        if ((jsonObj.get("event_response") != null && !jsonObj.get("event_response").isJsonNull())
                && !jsonObj.get("event_response").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `event_response` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("event_response").toString()));
        }
        if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull())
                && !jsonObj.get("title").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `title` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("title").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CharacterCalendarResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterCalendarResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterCalendarResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterCalendarResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterCalendarResponse>() {
                @Override
                public void write(JsonWriter out, CharacterCalendarResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterCalendarResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterCalendarResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterCalendarResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterCalendarResponse
     */
    public static CharacterCalendarResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterCalendarResponse.class);
    }

    /**
     * Convert an instance of CharacterCalendarResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
