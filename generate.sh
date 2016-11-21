#!/bin/bash

#
# Get eve swagger file
#
rm -f esi.json
wget -q -O esi.json https://esi.tech.ccp.is/latest/swagger.json?datasource=tranquility
APIVERSION=$(jq -r '.info.version' esi.json)

if [ a$APIVERSION = "a" ]; then
  echo "Version not found, perhaps the API is down."
  exit 1
fi

echo "ESI version $APIVERSION"

git fetch -p
BRANCH=$(git branch -a | grep $APIVERSION > /dev/null && echo "true")
COMMIT=$(git log | grep $APIVERSION > /dev/null && echo "true")

if [ "a$BRANCH" = "atrue" ]; then
  echo "Found version as branch"
  exit 0
fi
if [ "a$COMMIT" = "atrue" ]; then
  echo "Found version as commit"
  exit 0
fi

git checkout -b $APIVERSION

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
# Generate code
#
java -jar swagger-codegen-cli-$VERSION.jar generate \
  -i esi.json \
  -l java \
  -c config.json

#
# Clean up
#
rm -rf gradle* settings.gradle build.* docs git_push.sh .travis.yml

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
