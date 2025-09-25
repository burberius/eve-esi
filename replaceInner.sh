#!/bin/bash

for OLD in $(find . -name \*Inner\*.java); do
  NEW=$(echo $OLD | sed -e 's#Inner##g')
  mv $OLD $NEW
done

for DIR in `for F in $(find src -name \*.java); do dirname $F; done | sort -u`; do
  sed -i -e 's#Inner##g' $DIR/*.java
done
