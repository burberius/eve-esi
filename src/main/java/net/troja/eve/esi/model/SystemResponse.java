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
import net.troja.eve.esi.model.Position;
import net.troja.eve.esi.model.SystemPlanet;
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
public class SystemResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CONSTELLATION_ID = "constellation_id";
    @SerializedName(SERIALIZED_NAME_CONSTELLATION_ID)
    private Integer constellationId;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_PLANETS = "planets";
    @SerializedName(SERIALIZED_NAME_PLANETS)
    private List<SystemPlanet> planets;

    public static final String SERIALIZED_NAME_POSITION = "position";
    @SerializedName(SERIALIZED_NAME_POSITION)
    private Position position;

    public static final String SERIALIZED_NAME_SECURITY_CLASS = "security_class";
    @SerializedName(SERIALIZED_NAME_SECURITY_CLASS)
    private String securityClass;

    public static final String SERIALIZED_NAME_SECURITY_STATUS = "security_status";
    @SerializedName(SERIALIZED_NAME_SECURITY_STATUS)
    private Float securityStatus;

    public static final String SERIALIZED_NAME_STAR_ID = "star_id";
    @SerializedName(SERIALIZED_NAME_STAR_ID)
    private Integer starId;

    public static final String SERIALIZED_NAME_STARGATES = "stargates";
    @SerializedName(SERIALIZED_NAME_STARGATES)
    private List<Integer> stargates;

    public static final String SERIALIZED_NAME_STATIONS = "stations";
    @SerializedName(SERIALIZED_NAME_STATIONS)
    private List<Integer> stations;

    public static final String SERIALIZED_NAME_SYSTEM_ID = "system_id";
    @SerializedName(SERIALIZED_NAME_SYSTEM_ID)
    private Integer systemId;

    public SystemResponse() {
    }

    public SystemResponse constellationId(Integer constellationId) {

        this.constellationId = constellationId;
        return this;
    }

    /**
     * The constellation this solar system is in
     * 
     * @return constellationId
     **/
    @javax.annotation.Nonnull
    public Integer getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(Integer constellationId) {
        this.constellationId = constellationId;
    }

    public SystemResponse name(String name) {

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

    public SystemResponse planets(List<SystemPlanet> planets) {

        this.planets = planets;
        return this;
    }

    public SystemResponse addPlanetsItem(SystemPlanet planetsItem) {
        if (this.planets == null) {
            this.planets = new ArrayList<>();
        }
        this.planets.add(planetsItem);
        return this;
    }

    /**
     * planets array
     * 
     * @return planets
     **/
    @javax.annotation.Nullable
    public List<SystemPlanet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<SystemPlanet> planets) {
        this.planets = planets;
    }

    public SystemResponse position(Position position) {

        this.position = position;
        return this;
    }

    /**
     * Get position
     * 
     * @return position
     **/
    @javax.annotation.Nonnull
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public SystemResponse securityClass(String securityClass) {

        this.securityClass = securityClass;
        return this;
    }

    /**
     * security_class string
     * 
     * @return securityClass
     **/
    @javax.annotation.Nullable
    public String getSecurityClass() {
        return securityClass;
    }

    public void setSecurityClass(String securityClass) {
        this.securityClass = securityClass;
    }

    public SystemResponse securityStatus(Float securityStatus) {

        this.securityStatus = securityStatus;
        return this;
    }

    /**
     * security_status number
     * 
     * @return securityStatus
     **/
    @javax.annotation.Nonnull
    public Float getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(Float securityStatus) {
        this.securityStatus = securityStatus;
    }

    public SystemResponse starId(Integer starId) {

        this.starId = starId;
        return this;
    }

    /**
     * star_id integer
     * 
     * @return starId
     **/
    @javax.annotation.Nullable
    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public SystemResponse stargates(List<Integer> stargates) {

        this.stargates = stargates;
        return this;
    }

    public SystemResponse addStargatesItem(Integer stargatesItem) {
        if (this.stargates == null) {
            this.stargates = new ArrayList<>();
        }
        this.stargates.add(stargatesItem);
        return this;
    }

    /**
     * stargates array
     * 
     * @return stargates
     **/
    @javax.annotation.Nullable
    public List<Integer> getStargates() {
        return stargates;
    }

    public void setStargates(List<Integer> stargates) {
        this.stargates = stargates;
    }

    public SystemResponse stations(List<Integer> stations) {

        this.stations = stations;
        return this;
    }

    public SystemResponse addStationsItem(Integer stationsItem) {
        if (this.stations == null) {
            this.stations = new ArrayList<>();
        }
        this.stations.add(stationsItem);
        return this;
    }

    /**
     * stations array
     * 
     * @return stations
     **/
    @javax.annotation.Nullable
    public List<Integer> getStations() {
        return stations;
    }

    public void setStations(List<Integer> stations) {
        this.stations = stations;
    }

    public SystemResponse systemId(Integer systemId) {

        this.systemId = systemId;
        return this;
    }

    /**
     * system_id integer
     * 
     * @return systemId
     **/
    @javax.annotation.Nonnull
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemResponse systemResponse = (SystemResponse) o;
        return Objects.equals(this.constellationId, systemResponse.constellationId)
                && Objects.equals(this.name, systemResponse.name)
                && Objects.equals(this.planets, systemResponse.planets)
                && Objects.equals(this.position, systemResponse.position)
                && Objects.equals(this.securityClass, systemResponse.securityClass)
                && Objects.equals(this.securityStatus, systemResponse.securityStatus)
                && Objects.equals(this.starId, systemResponse.starId)
                && Objects.equals(this.stargates, systemResponse.stargates)
                && Objects.equals(this.stations, systemResponse.stations)
                && Objects.equals(this.systemId, systemResponse.systemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constellationId, name, planets, position, securityClass, securityStatus, starId, stargates,
                stations, systemId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SystemResponse {\n");
        sb.append("    constellationId: ").append(toIndentedString(constellationId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    planets: ").append(toIndentedString(planets)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    securityClass: ").append(toIndentedString(securityClass)).append("\n");
        sb.append("    securityStatus: ").append(toIndentedString(securityStatus)).append("\n");
        sb.append("    starId: ").append(toIndentedString(starId)).append("\n");
        sb.append("    stargates: ").append(toIndentedString(stargates)).append("\n");
        sb.append("    stations: ").append(toIndentedString(stations)).append("\n");
        sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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
        openapiFields.add("constellation_id");
        openapiFields.add("name");
        openapiFields.add("planets");
        openapiFields.add("position");
        openapiFields.add("security_class");
        openapiFields.add("security_status");
        openapiFields.add("star_id");
        openapiFields.add("stargates");
        openapiFields.add("stations");
        openapiFields.add("system_id");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("constellation_id");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("position");
        openapiRequiredFields.add("security_status");
        openapiRequiredFields.add("system_id");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to SystemResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!SystemResponse.openapiRequiredFields.isEmpty()) { // has
                                                                   // required
                                                                   // fields but
                                                                   // JSON
                                                                   // object is
                                                                   // null
                throw new IllegalArgumentException(String.format(
                        "The required field(s) %s in SystemResponse is not found in the empty JSON string",
                        SystemResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!SystemResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `SystemResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : SystemResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `name` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("name").toString()));
        }
        if (jsonObj.get("planets") != null && !jsonObj.get("planets").isJsonNull()) {
            JsonArray jsonArrayplanets = jsonObj.getAsJsonArray("planets");
            if (jsonArrayplanets != null) {
                // ensure the json data is an array
                if (!jsonObj.get("planets").isJsonArray()) {
                    throw new IllegalArgumentException(String.format(
                            "Expected the field `planets` to be an array in the JSON string but got `%s`",
                            jsonObj.get("planets").toString()));
                }

                // validate the optional field `planets` (array)
                for (int i = 0; i < jsonArrayplanets.size(); i++) {
                    SystemPlanet.validateJsonObject(jsonArrayplanets.get(i).getAsJsonObject());
                };
            }
        }
        // validate the required field `position`
        Position.validateJsonObject(jsonObj.getAsJsonObject("position"));
        if ((jsonObj.get("security_class") != null && !jsonObj.get("security_class").isJsonNull())
                && !jsonObj.get("security_class").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `security_class` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("security_class").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("stargates") != null && !jsonObj.get("stargates").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `stargates` to be an array in the JSON string but got `%s`",
                    jsonObj.get("stargates").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("stations") != null && !jsonObj.get("stations").isJsonArray()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `stations` to be an array in the JSON string but got `%s`",
                    jsonObj.get("stations").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!SystemResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'SystemResponse' and
                             // its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SystemResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(SystemResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<SystemResponse>() {
                @Override
                public void write(JsonWriter out, SystemResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public SystemResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of SystemResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of SystemResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to SystemResponse
     */
    public static SystemResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, SystemResponse.class);
    }

    /**
     * Convert an instance of SystemResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
