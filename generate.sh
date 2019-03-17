#!/bin/bash

#
# Get eve swagger file
#
rm -f esi.json
wget -O esi.json https://esi.evetech.net/_latest/swagger.json?datasource=tranquility
wget -O meta.json https://esi.evetech.net/swagger.json

#
# Remove old model files in case something was removed
#
mv src/main/java/net/troja/eve/esi/model/CharacterInfo.java src/main/java/net/troja/eve/esi/CharacterInfo.java
rm -r src/main/java/net/troja/eve/esi/model
mv src/main/java/net/troja/eve/esi/api/SsoApi.java src/main/java/net/troja/eve/esi/SsoApi.java
rm -r src/main/java/net/troja/eve/esi/api

#
# Get swagger code generator
#
#VERSION=$(git ls-remote --tags https://github.com/swagger-api/swagger-codegen.git | grep -o "refs/tags/v.*" | sort -rV | head -1 | sed -e 's#.*v##')

#if [ ! -e swagger-codegen-cli-$VERSION.jar ]; then
#  wget -O swagger-codegen-cli.jar -q http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/$VERSION/swagger-codegen-cli-$VERSION.jar

#  if [ $? != 0 ]; then
#    echo "Could not download http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/$VERSION/swagger-codegen-cli-$VERSION.jar"
#    exit -1
#  fi
#fi

#
# Transform and beautify swagger file
#
sed -i -f replace.sed esi.json
sed -i -f meta_replace.sed meta.json
./meta_transformation.sh
./transformation.sh
#
# Generate code
# Move tests so they are generated new and then moved to a different directory
#
test -d src/test/java/net/troja/eve/esi/api.new && rm -r src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.old
java -jar openapi-generator-cli.jar generate \
  --skip-validate-spec  \
  -i meta.json \
  -g java \
  -c config.json
java -jar openapi-generator-cli.jar generate \
  --skip-validate-spec  \
  -i esi.json \
  -g java \
  -c config.json
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api.old src/test/java/net/troja/eve/esi/api
mv src/main/java/net/troja/eve/esi/CharacterInfo.java src/main/java/net/troja/eve/esi//model/CharacterInfo.java
mv src/main/java/net/troja/eve/esi/SsoApi.java src/main/java/net/troja/eve/esi/api/SsoApi.java

for I in $(grep "OpenAPI spec version" src/* -r | sed -e 's#:.*##'); do
  sed -i -e '/OpenAPI spec version/d' $I
done

# Fix route
jq ".paths | keys" esi.json > version-routes.txt

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
for VAL in $(jq "(.paths[][] | select(.security[0].evesso).security[0].evesso[0])" esi.json | sort | uniq | sed -e 's#"##g'); do
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

cp src/test/java/net/troja/eve/esi/api/GeneralApiTest.java src/test/java/net/troja/eve/esi/api.new/
cp -r src/test/java/net/troja/eve/esi/api/auth src/test/java/net/troja/eve/esi/api.new/
