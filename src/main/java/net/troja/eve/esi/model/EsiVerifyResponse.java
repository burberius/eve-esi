/*
 * ESI Meta Spec
 * ESI specs and miscellaneous routes
 *
 * The version of the OpenAPI document: 0.1
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.io.Serializable;

/**
 * SSO /verify JSON
 */
@ApiModel(description = "SSO /verify JSON")
public class EsiVerifyResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CHARACTER_I_D = "CharacterID";
    @SerializedName(SERIALIZED_NAME_CHARACTER_I_D)
    private Integer characterID;

    public static final String SERIALIZED_NAME_CHARACTER_NAME = "CharacterName";
    @SerializedName(SERIALIZED_NAME_CHARACTER_NAME)
    private String characterName;

    public static final String SERIALIZED_NAME_CHARACTER_OWNER_HASH = "CharacterOwnerHash";
    @SerializedName(SERIALIZED_NAME_CHARACTER_OWNER_HASH)
    private String characterOwnerHash;

    public static final String SERIALIZED_NAME_EXPIRES_ON = "ExpiresOn";
    @SerializedName(SERIALIZED_NAME_EXPIRES_ON)
    private String expiresOn;

    public static final String SERIALIZED_NAME_INTELLECTUAL_PROPERTY = "IntellectualProperty";
    @SerializedName(SERIALIZED_NAME_INTELLECTUAL_PROPERTY)
    private String intellectualProperty;

    public static final String SERIALIZED_NAME_SCOPES = "Scopes";
    @SerializedName(SERIALIZED_NAME_SCOPES)
    private String scopes;

    public static final String SERIALIZED_NAME_TOKEN_TYPE = "TokenType";
    @SerializedName(SERIALIZED_NAME_TOKEN_TYPE)
    private String tokenType;

    public EsiVerifyResponse characterID(Integer characterID) {

        this.characterID = characterID;
        return this;
    }

    /**
     * Token owner&#39;s character ID
     * 
     * @return characterID
     **/
    @ApiModelProperty(required = true, value = "Token owner's character ID")
    public Integer getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Integer characterID) {
        this.characterID = characterID;
    }

    public EsiVerifyResponse characterName(String characterName) {

        this.characterName = characterName;
        return this;
    }

    /**
     * Token owner&#39;s character name
     * 
     * @return characterName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Token owner's character name")
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public EsiVerifyResponse characterOwnerHash(String characterOwnerHash) {

        this.characterOwnerHash = characterOwnerHash;
        return this;
    }

    /**
     * Hash of the character&#39;s owner. If the character is sold or otherwise
     * transferred, this will change
     * 
     * @return characterOwnerHash
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Hash of the character's owner. If the character is sold or otherwise transferred, this will change")
    public String getCharacterOwnerHash() {
        return characterOwnerHash;
    }

    public void setCharacterOwnerHash(String characterOwnerHash) {
        this.characterOwnerHash = characterOwnerHash;
    }

    public EsiVerifyResponse expiresOn(String expiresOn) {

        this.expiresOn = expiresOn;
        return this;
    }

    /**
     * Expiry time of the token (not RFC3339)
     * 
     * @return expiresOn
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Expiry time of the token (not RFC3339)")
    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

    public EsiVerifyResponse intellectualProperty(String intellectualProperty) {

        this.intellectualProperty = intellectualProperty;
        return this;
    }

    /**
     * The IP which generated the token
     * 
     * @return intellectualProperty
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The IP which generated the token")
    public String getIntellectualProperty() {
        return intellectualProperty;
    }

    public void setIntellectualProperty(String intellectualProperty) {
        this.intellectualProperty = intellectualProperty;
    }

    public EsiVerifyResponse scopes(String scopes) {

        this.scopes = scopes;
        return this;
    }

    /**
     * Space separated list of scopes the token is valid for
     * 
     * @return scopes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Space separated list of scopes the token is valid for")
    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public EsiVerifyResponse tokenType(String tokenType) {

        this.tokenType = tokenType;
        return this;
    }

    /**
     * Type of access token
     * 
     * @return tokenType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Type of access token")
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EsiVerifyResponse esiVerifyResponse = (EsiVerifyResponse) o;
        return Objects.equals(this.characterID, esiVerifyResponse.characterID)
                && Objects.equals(this.characterName, esiVerifyResponse.characterName)
                && Objects.equals(this.characterOwnerHash, esiVerifyResponse.characterOwnerHash)
                && Objects.equals(this.expiresOn, esiVerifyResponse.expiresOn)
                && Objects.equals(this.intellectualProperty, esiVerifyResponse.intellectualProperty)
                && Objects.equals(this.scopes, esiVerifyResponse.scopes)
                && Objects.equals(this.tokenType, esiVerifyResponse.tokenType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterID, characterName, characterOwnerHash, expiresOn, intellectualProperty, scopes,
                tokenType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EsiVerifyResponse {\n");
        sb.append("    characterID: ").append(toIndentedString(characterID)).append("\n");
        sb.append("    characterName: ").append(toIndentedString(characterName)).append("\n");
        sb.append("    characterOwnerHash: ").append(toIndentedString(characterOwnerHash)).append("\n");
        sb.append("    expiresOn: ").append(toIndentedString(expiresOn)).append("\n");
        sb.append("    intellectualProperty: ").append(toIndentedString(intellectualProperty)).append("\n");
        sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
        sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
