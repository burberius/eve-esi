#!/bin/bash

jq -c ".paths[] | to_entries[] | [.key, .value.description ] | @csv" esi.json | sed -e 's#"\\"\(.*\)\\",\\".*Alternate route: `\(/v[^`]*\)`.*#\1 \2#' > $1
