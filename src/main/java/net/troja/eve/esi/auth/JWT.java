package net.troja.eve.esi.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

/**
* JWT (JSON Web Token)
* WARNING: The JWT is unverified.
* Verifying the JWT is beyond the scope of this library.
* As ESI will verify the token when used.
* See the SSO documentation for JWT Token validation for details:
* https://github.com/ccpgames/eveonline-third-party-documentation/blob/master/docs/sso/jwt-validation.md
*/
public class JWT {

    private final Header header;
    private final Payload payload;
    private final String signature;

    public JWT(Header header, Payload payload, String signature) {
        this.header = header;
        this.payload = payload;
        this.signature = signature;
    }

    public Header getHeader() {
        return header;
    }

    public Payload getPayload() {
        return payload;
    }

    public String getSignature() {
        return signature;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Header {

        private String alg;
        private String typ;

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {

        @JsonProperty("scp")
        private Set<String> scopes;

        private String jti;
        private String kid;
        private String sub;
        private String azp;
        private String name;
        private String owner;
        private String exp;
        private String iss;
        private Integer characterID;

        public Set<String> getScopes() {
            return scopes;
        }

        public void setScopes(Set<String> scopes) {
            this.scopes = scopes;
        }

        public String getJti() {
            return jti;
        }

        public void setJti(String jti) {
            this.jti = jti;
        }

        public String getKid() {
            return kid;
        }

        public void setKid(String kid) {
            this.kid = kid;
        }

        public String getSub() {
            return sub;
        }

        public void setSub(String sub) {
            this.sub = sub;
            try {
                characterID = Integer.valueOf(sub.substring("CHARACTER:EVE:".length()));
            } catch (NumberFormatException ex) {
                characterID = null;
            }
        }

        public Integer getCharacterID() {
            return characterID;
        }

        public String getAzp() {
            return azp;
        }

        public void setAzp(String azp) {
            this.azp = azp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getExp() {
            return exp;
        }

        public void setExp(String exp) {
            this.exp = exp;
        }

        public String getIss() {
            return iss;
        }

        public void setIss(String iss) {
            this.iss = iss;
        }
    }
}
