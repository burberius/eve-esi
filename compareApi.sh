#!/bin/bash

for file in $(ls -1 src/test/java/net/troja/eve/esi/api.new); do
	diff -aur src/test/java/net/troja/eve/esi/api/${file} src/test/java/net/troja/eve/esi/api.new/${file} | less
done