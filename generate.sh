#!/bin/bash

if [ "a$1" = "a-g" ]; then
  GIT=true
fi

#
# Get eve swagger file
#
rm -f esi.json
wget -q -O esi.json https://esi.tech.ccp.is/latest/swagger.json?datasource=tranquility

APIHASH=$(md5sum esi.json | sed -e 's#.*\(.\{10\}\)  esi.json#\1#')
DATE=$(date +"%y-%m-%d")

APIVERSION="$DATE-$APIHASH"

echo "ESI version $APIVERSION"

if [ "$GIT" = true ]; then
  git fetch -p
  BRANCH=$(git branch -a | grep $APIHASH > /dev/null && echo "true")
  COMMIT=$(git log | grep $APIHASH > /dev/null && echo "true")

  if [ "a$BRANCH" = "atrue" ]; then
    echo "Found version as branch"
    exit 0
  fi
  if [ "a$COMMIT" = "atrue" ]; then
    echo "Found version as commit"
    exit 0
  fi

  git checkout -b $APIVERSION
fi

#
# Get swagger code generator
#
VERSION=$(git ls-remote --tags https://github.com/swagger-api/swagger-codegen.git | grep -o "refs/tags/v.*" | sort -rV | head -1 | sed -e 's#.*v##')

if [ ! -e swagger-codegen-cli-$VERSION.jar ]; then
  wget -q http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/$VERSION/swagger-codegen-cli-$VERSION.jar

  if [ $? != 0 ]; then
    echo "Could not download http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/$VERSION/swagger-codegen-cli-$VERSION.jar"
    exit -1
  fi
fi

#
# Beautify swagger file
#
sed -i -f replace.sed esi.json

#
# Generate code
#
java -jar swagger-codegen-cli-$VERSION.jar generate \
  -i esi.json \
  -l java \
  -c config.json

#
# Clean formating
#
mvn formatter:format

if [ "$GIT" = true ]; then
  git add .
  git commit -m "Generated API version $APIVERSION"
  git push origin $APIVERSION

  echo "New version $APIVERSION"

#
# Send email
#
  EMAILS=$(sed -n -e 's#.*<email>\(.*\)</email>#\1#p' pom.xml | tr "\n" " ")
  DIFF=$(git diff HEAD^ HEAD)
  echo -e "$DIFF\n.\n" | mail -s "New eve-esi version $APIVERSION" $EMAILS

else
  echo "To publish to a git branch, start with '-g'"
fi
