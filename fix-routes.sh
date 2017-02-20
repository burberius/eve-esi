#!/bin/bash

SWAGGER="esi.json"
FILE="version-routes.txt"

sed -n -e 's#.*Alternate route: `\(/v[^`]*\)`.*#\1#p' $SWAGGER | sort | uniq > $FILE

for ROUTE in $(cat $FILE); do
  OLD=$(echo $ROUTE | sed -e 's#/v[0-9]*##')
  sed -i -e "s#\"$OLD\":#\"$ROUTE\":#" esi.json
done
