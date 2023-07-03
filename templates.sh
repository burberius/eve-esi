#!/bin/bash

VERSION=$(git ls-remote --tags https://github.com/OpenAPITools/openapi-generator.git | grep -o "refs/tags/v[^-]*$" | sort -rV | head -1 | sed -e 's#.*v##')

java -jar openapi-generator-cli-$VERSION.jar author template -g java --library okhttp-gson