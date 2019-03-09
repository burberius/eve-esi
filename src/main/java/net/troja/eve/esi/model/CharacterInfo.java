package net.troja.eve.esi.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CharacterInfo extends EsiVerifyResponse {

    private final EsiVerifyResponse response;
    private Set<String> scopesSet = null;

    public CharacterInfo(EsiVerifyResponse response) {
        this.response = response;
    }

    public Set<String> getScopesSet() {
        if (scopesSet == null) {
            if (getScopes() != null) {
                this.scopesSet = new HashSet<>(Arrays.asList(getScopes().split(" ")));
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

    @Override
    public void setCharacterOwnerHash(String characterOwnerHash) {
        response.setCharacterOwnerHash(characterOwnerHash);
    }

    @Override
    public String getCharacterOwnerHash() {
        return response.getCharacterOwnerHash();
    }

    @Override
    public EsiVerifyResponse characterOwnerHash(String characterOwnerHash) {
        return response.characterOwnerHash(characterOwnerHash);
    }

    @Override
    public void setExpiresOn(String expiresOn) {
        response.setExpiresOn(expiresOn);
    }

    @Override
    public String getExpiresOn() {
        return response.getExpiresOn();
    }

    @Override
    public EsiVerifyResponse expiresOn(String expiresOn) {
        return response.expiresOn(expiresOn);
    }

    @Override
    public void setCharacterName(String characterName) {
        response.setCharacterName(characterName);
    }

    @Override
    public String getCharacterName() {
        return response.getCharacterName();
    }

    @Override
    public EsiVerifyResponse characterName(String characterName) {
        return response.characterName(characterName);
    }

    @Override
    public void setCharacterID(Integer characterID) {
        response.setCharacterID(characterID);
    }

    @Override
    public Integer getCharacterID() {
        return response.getCharacterID();
    }

    @Override
    public EsiVerifyResponse characterID(Integer characterID) {
        return response.characterID(characterID);
    }

    @Override
    public void setScopes(String scopes) {
        response.setScopes(scopes);
    }

    @Override
    public String getScopes() {
        return response.getScopes();
    }

    @Override
    public EsiVerifyResponse scopes(String scopes) {
        return response.scopes(scopes);
    }

    @Override
    public void setIntellectualProperty(String intellectualProperty) {
        response.setIntellectualProperty(intellectualProperty);
    }

    @Override
    public String getIntellectualProperty() {
        return response.getIntellectualProperty();
    }

    @Override
    public EsiVerifyResponse intellectualProperty(String intellectualProperty) {
        return response.intellectualProperty(intellectualProperty);
    }

    @Override
    public void setTokenType(String tokenType) {
        response.setTokenType(tokenType);
    }

    @Override
    public String getTokenType() {
        return response.getTokenType();
    }

    @Override
    public EsiVerifyResponse tokenType(String tokenType) {
        return response.tokenType(tokenType);
    }
}
