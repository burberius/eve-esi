#!/bin/bash

ROUTES="version-routes.txt"

ERROR=1

for ROUTE in $(cat $ROUTES); do
  USE=$(echo $ROUTE | sed -e 's#{.*}#1234#g')
  RESULT=$(curl -s -D - https://esi.tech.ccp.is$USE | grep deprecated > /dev/null && echo "ERROR" || echo "OK")
  echo "$ROUTE -> $RESULT"
  if [ $RESULT == "ERROR" ]; then
    ERROR=-1
  fi
done

exit $ERROR
