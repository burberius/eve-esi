#!/bin/bash

# Reset BASH time counter
SECONDS=0

#
# Get eve swagger file
#
rm -f esi.json
#
# esi _latest
#
wget -O esi.json https://esi.evetech.net/meta/openapi.json?compatibility_date=2025-08-26 || exit 1

#
# Get swagger code generator
#
VERSION=$(git ls-remote --tags https://github.com/OpenAPITools/openapi-generator.git | grep -o "refs/tags/v[^-]*$" | sort -rV | head -1 | sed -e 's#.*v##')

if [ ! -e openapi-generator-cli-$VERSION.jar ]; then
  wget -O openapi-generator-cli-$VERSION.jar https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/$VERSION/openapi-generator-cli-$VERSION.jar

  if [ $? != 0 ]; then
    echo "Could not download https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/$VERSION/openapi-generator-cli-$VERSION.jar"
    exit 1
  fi
fi

#
# Remove old model files in case something was removed
#
rm -r src/main/java/net/troja/eve/esi/model
mv src/main/java/net/troja/eve/esi/api/SsoApi.java src/main/java/net/troja/eve/esi/SsoApi.java
rm -r src/main/java/net/troja/eve/esi/api

#
# Transform and beautify swagger file
#
sed -i -f replace.sed esi.json

#
# Generate code
# Move tests so they are generated new and then moved to a different directory
#
test -d src/test/java/net/troja/eve/esi/api.new && rm -r src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.old
java -jar openapi-generator-cli-$VERSION.jar generate \
  --skip-validate-spec  \
  -i esi.json \
  -t templates \
  -g java \
  -c config.json
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api.old src/test/java/net/troja/eve/esi/api
rm -rf src/test/java/net/troja/eve/esi/model
mv src/main/java/net/troja/eve/esi/SsoApi.java src/main/java/net/troja/eve/esi/api/SsoApi.java

#
# Generate SSO scopes
#
BAD_SCOPES=""
FILE="src/main/java/net/troja/eve/esi/auth/SsoScopes.java"
echo "package net.troja.eve.esi.auth;" > $FILE
echo "" >> $FILE
echo "import java.util.Arrays;" >> $FILE
echo "import java.util.Collections;" >> $FILE
echo "import java.util.HashSet;" >> $FILE
echo "import java.util.Set;" >> $FILE
echo "" >> $FILE
echo "public class SsoScopes {" >> $FILE
echo "public static final String PUBLIC_DATA = \"publicData\";" >> $FILE
for VAL in $(jq ".components.securitySchemes.OAuth2.flows.authorizationCode.scopes" esi.json | sed -n -e 's#.*: "\(.*\)",#\1#p'); do
  echo $BAD_SCOPES | grep $VAL > /dev/null && continue
  UPPER=$(echo $VAL | tr [.a-z-] [_A-Z_])
  if [ "a$ALL" = "a" ]; then
    ALL="$UPPER"
  else
    ALL="$ALL, $UPPER"
  fi
  echo "public static final String $UPPER = \"$VAL\";" >> $FILE
done
echo -e "\nprivate static final String[] ALL_VALUES = {$ALL};" >> $FILE
echo "" >> $FILE
echo "    public static Set<String> ALL = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(ALL_VALUES)));" >> $FILE
echo "" >> $FILE
echo "}" >> $FILE

#
# Clean formating
#
mvn formatter:format

if (( $SECONDS >= 60 ))
   then
       echo "Generated in $((($SECONDS / 60) % 60))min $(($SECONDS % 60))sec"
   else
       echo "Generated in $(($SECONDS % 60))sec"
fi

echo
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "! Did you update the date in templates/api.mustache?                              !"
echo "! The current version is visible at https://developers.eveonline.com/api-explorer !"
echo "! After a change you have to regenerate it!                                       !"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
