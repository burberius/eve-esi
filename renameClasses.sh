#!/bin/bash

for OLD in $(find . -name \*Inner\*.java); do
  NEW=$(echo $OLD | sed -e 's#Inner##g')
  mv $OLD $NEW
done

mv src/main/java/net/troja/eve/esi/model/CharacterContractItemsResponse.java src/main/java/net/troja/eve/esi/model/ContractItemsResponse.java

for DIR in `for F in $(find src -name \*.java); do dirname $F; done | sort -u`; do
  sed -i -e 's#Inner##g' $DIR/*.java
  sed -i -e 's#CharacterContractItemsResponse#ContractItemsResponse#g' $DIR/*.java
done
