package net.troja.eve.esi.auth;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CharacterInfo {
    @JsonProperty("CharacterID")
    private int characterId;
    @JsonProperty("CharacterName")
    private String characterName;
    @JsonProperty("ExpiresOn")
    private Date expiresOn;
    @JsonProperty("Scopes")
    private Set<String> scopes;
    @JsonProperty("TokenType")
    private String TokenType;
    @JsonProperty("CharacterOwnerHash")
    private String CharacterOwnerHash;
    @JsonProperty("IntellectualProperty")
    private String intellectualProperty;

    public CharacterInfo() {
        super();
    }

    // {"CharacterID":91522382,
    // "CharacterName":"Burbone Mijory",
    // "ExpiresOn":"2017-01-12T21:32:55.8859259",
    // "Scopes":"esi-assets.read_assets.v1 esi-characters.write_contacts.v1
    // esi-skills.read_skills.v1 esi-calendar.respond_calendar_events.v1
    // esi-corporations.read_corporation_membership.v1
    // esi-killmails.read_killmails.v1 esi-location.read_ship_type.v1
    // esi-skills.read_skillqueue.v1 esi-search.search_structures.v1
    // esi-universe.read_structures.v1 esi-bookmarks.read_character_bookmarks.v1
    // esi-characters.read_contacts.v1 esi-location.read_location.v1
    // esi-ui.open_window.v1 esi-calendar.read_calendar_events.v1
    // esi-ui.write_waypoint.v1 esi-planets.manage_planets.v1
    // esi-wallet.read_character_wallet.v1 esi-clones.read_clones.v1",
    // "TokenType":"Character",
    // "CharacterOwnerHash":"H6SPoOsHG7BdtTTLekzA39Hy/EQ=",
    // "IntellectualProperty":"EVE"}
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(final int characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(final Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public Set<String> getScopes() {
        return scopes;
    }

    public void setScopes(final String scopes) {
        this.scopes = new HashSet<>(Arrays.asList(scopes.split(" ")));
    }

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(final String tokenType) {
        TokenType = tokenType;
    }

    public String getCharacterOwnerHash() {
        return CharacterOwnerHash;
    }

    public void setCharacterOwnerHash(final String characterOwnerHash) {
        CharacterOwnerHash = characterOwnerHash;
    }

    public String getIntellectualProperty() {
        return intellectualProperty;
    }

    public void setIntellectualProperty(final String intellectualProperty) {
        this.intellectualProperty = intellectualProperty;
    }

    @Override
    public String toString() {
        return "CharacterInfo [characterId=" + characterId + ", characterName=" + characterName + ", expiresOn="
                + expiresOn + ", scopes=" + scopes + ", TokenType=" + TokenType + ", CharacterOwnerHash="
                + CharacterOwnerHash + ", intellectualProperty=" + intellectualProperty + "]";
    }
}
