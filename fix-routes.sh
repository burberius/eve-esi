#!/bin/bash

SWAGGER="esi.json"
ROUTES="version-routes.txt"

echo "Fixing routes"

./create-version-routes.sh $ROUTES

IFS="
"
for ROUTE in $(cat $ROUTES); do
  TYPE=$(echo $ROUTE | sed -e 's#^\([^ ]*\) .*#\1#')
  URI=$(echo $ROUTE | sed -e 's#^[^ ]* ##')
  OLD=$(echo $URI | sed -e 's#/v[0-9]*##')
  NAME=$(echo $OLD | sed -e 's#[/{}_]##g')

  FOUND=$(grep -i "$TYPE$NAME(" src/main/java/net/troja/eve/esi/api/*)
  FILE=$(echo $FOUND | sed -s 's#:.*##')
  REALNAME=$(echo $FOUND | sed -s "s#.*:.*\($TYPE[^(]*\).*#\1#")
  sed -i -e "/$REALNAME(/,/String localVarPath/ s#$OLD#$URI#" $FILE
done

sed -i -e 's#https://esi.tech.ccp.is/latest#https://esi.tech.ccp.is#' src/main/java/net/troja/eve/esi/ApiClient.java
