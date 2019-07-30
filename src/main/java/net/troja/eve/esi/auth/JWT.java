package net.troja.eve.esi.auth;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * JWT (JSON Web Token) WARNING: The JWT is unverified. Verifying the JWT is
 * beyond the scope of this library. As ESI will verify the token when used. See
 * the SSO documentation for JWT Token validation for details:
 * https://github.com/esi/esi-docs/blob/master/docs/sso/validating_eve_jwt.md
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

    public static class Payload {

        private Set<String> scopes = new HashSet<>();

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

        public String getKid() {
            return kid;
        }

        public String getSub() {
            return sub;
        }

        public void setSub(String sub) {
            this.sub = sub;

        }

        public Integer getCharacterID() {
            return characterID;
        }

        public String getAzp() {
            return azp;
        }

        public String getName() {
            return name;
        }

        public String getOwner() {
            return owner;
        }

        public String getExp() {
            return exp;
        }

        public String getIss() {
            return iss;
        }
    }

    public static class PayloadDeserializer implements JsonDeserializer<Payload> {

        @Override
        public Payload deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            Payload payload = new Payload();
            JsonElement element = jsonObject.get("scp");
            if (element != null) {
                if (element.isJsonArray()) {
                    for (JsonElement item : element.getAsJsonArray()) {
                        payload.scopes.add(item.getAsString());
                    }
                } else {
                    payload.scopes.add(element.getAsString());
                }
            }

            payload.jti = jsonObject.get("jti").getAsString();
            payload.kid = jsonObject.get("kid").getAsString();
            payload.sub = jsonObject.get("sub").getAsString();
            try {
                payload.characterID = Integer.valueOf(payload.sub.substring("CHARACTER:EVE:".length()));
            } catch (NumberFormatException ex) {
                payload.characterID = null;
            }
            payload.azp = jsonObject.get("azp").getAsString();
            payload.name = jsonObject.get("name").getAsString();
            payload.owner = jsonObject.get("owner").getAsString();
            payload.jti = jsonObject.get("jti").getAsString();
            payload.exp = jsonObject.get("exp").getAsString();
            payload.iss = jsonObject.get("iss").getAsString();
            return payload;
        }
    }
}
