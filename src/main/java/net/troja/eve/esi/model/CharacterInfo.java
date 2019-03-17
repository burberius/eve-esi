package net.troja.eve.esi.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CharacterInfo {

    private final EsiVerifyResponse response;
    private OffsetDateTime expiresDate;
    private Set<String> scopesSet = null;

    public CharacterInfo(EsiVerifyResponse response) {
        this.response = response;
    }

    public Set<String> getScopes() {
        if (scopesSet == null) {
            if (response.getScopes() != null) {
                this.scopesSet = new HashSet<>(Arrays.asList(response.getScopes().split(" ")));
            } else {
                this.scopesSet = new HashSet<>();
            }
        }
        return scopesSet;
    }

    @Override
    public String toString() {
        return response.toString();
    }

    @Override
    public int hashCode() {
        return response.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return response.equals(o);
    }

    public void setCharacterOwnerHash(String characterOwnerHash) {
        response.setCharacterOwnerHash(characterOwnerHash);
    }

    public String getCharacterOwnerHash() {
        return response.getCharacterOwnerHash();
    }

    public EsiVerifyResponse characterOwnerHash(String characterOwnerHash) {
        return response.characterOwnerHash(characterOwnerHash);
    }

    public void setExpiresOn(String expiresOn) {
        response.setExpiresOn(expiresOn);
    }

    public OffsetDateTime getExpiresOn() {
        if (expiresDate == null) {
            expiresDate = OffsetDateTime.of(LocalDateTime.parse(response.getExpiresOn()), ZoneOffset.UTC);
        }
        return expiresDate;
    }

    public EsiVerifyResponse expiresOn(String expiresOn) {
        return response.expiresOn(expiresOn);
    }

    public void setCharacterName(String characterName) {
        response.setCharacterName(characterName);
    }

    public String getCharacterName() {
        return response.getCharacterName();
    }

    public EsiVerifyResponse characterName(String characterName) {
        return response.characterName(characterName);
    }

    public void setCharacterID(Integer characterID) {
        response.setCharacterID(characterID);
    }

    public Integer getCharacterID() {
        return response.getCharacterID();
    }

    public EsiVerifyResponse characterID(Integer characterID) {
        return response.characterID(characterID);
    }

    public void setScopes(String scopes) {
        response.setScopes(scopes);
    }

    public EsiVerifyResponse scopes(String scopes) {
        return response.scopes(scopes);
    }

    public void setIntellectualProperty(String intellectualProperty) {
        response.setIntellectualProperty(intellectualProperty);
    }

    public String getIntellectualProperty() {
        return response.getIntellectualProperty();
    }

    public EsiVerifyResponse intellectualProperty(String intellectualProperty) {
        return response.intellectualProperty(intellectualProperty);
    }

    public void setTokenType(String tokenType) {
        response.setTokenType(tokenType);
    }

    public String getTokenType() {
        return response.getTokenType();
    }

    public EsiVerifyResponse tokenType(String tokenType) {
        return response.tokenType(tokenType);
    }
}
