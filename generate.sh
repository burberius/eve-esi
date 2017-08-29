#!/bin/bash

#
# Get eve swagger file
#
rm -f esi.json
wget -q -O esi.json https://esi.tech.ccp.is/_latest/swagger.json?datasource=tranquility

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
./transformation.sh
sed -i -f replace.sed esi.json

#
# Generate code
# Move tests so they are generated new and then moved to a different directory
#
test -d src/test/java/net/troja/eve/esi/api.new && rm -r src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.old
java -jar swagger-codegen-cli.jar generate \
  -i esi.json \
  -l java \
  -c config.json
mv src/test/java/net/troja/eve/esi/api src/test/java/net/troja/eve/esi/api.new
mv src/test/java/net/troja/eve/esi/api.old src/test/java/net/troja/eve/esi/api

for I in $(grep "OpenAPI spec version" src/* -r | sed -e 's#:.*##'); do
  sed -i -e '/OpenAPI spec version/d' $I
done

# Fix route
sed -i -e 's#https://esi.tech.ccp.is/#https://esi.tech.ccp.is#' src/main/java/net/troja/eve/esi/ApiClient.java
jq ".paths | keys" esi.json > version-routes.txt

#
# Generate SSO scopes
#
BAD_SCOPES=""
FILE="src/main/java/net/troja/eve/esi/auth/SsoScopes.java"
echo "package net.troja.eve.esi.auth;" > $FILE
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
echo -e "\npublic static final String[] ALL = {$ALL};" >> $FILE
echo "}" >> $FILE

#
# Clean formating
#
mvn formatter:format

cp src/test/java/net/troja/eve/esi/api/GeneralApiTest.java src/test/java/net/troja/eve/esi/api.new/
cp -r src/test/java/net/troja/eve/esi/api/auth src/test/java/net/troja/eve/esi/api.new/
