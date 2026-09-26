#!/bin/bash

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
for VAL in $(jq ".components.securitySchemes.OAuth2.flows.authorizationCode.scopes" esi.json | sed -n -e 's#.*: "\(.*\)".*#\1#p'); do
  echo $BAD_SCOPES | grep $VAL > /dev/null && continue
  UPPER=$(echo $VAL | tr [.a-z-:] [_A-Z__])
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

