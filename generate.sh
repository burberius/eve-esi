#!/bin/bash

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
  -i https://esi.tech.ccp.is/latest/swagger.json?datasource=tranquility \
  -l java \
  -c config.json

#
# Clean up
#
rm -rf gradle* settings.gradle build.* docs git_push.sh .travis.yml
