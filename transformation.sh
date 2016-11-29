#!/bin/bash

cp esi.json work1.json

# Internal Server Error = 500
jq "(.paths[][].responses[\"500\"] | select(.schema.title != \"get_alliances_internal_server_error\")) = { \"\$ref\": \"#/paths/alliances/get/responses/500\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_alliances_internal_server_error#InternalServerErrorResponse#g' work1.json

# Forbidden = 403
jq "(.paths[][].responses[\"403\"] | select(.schema.title != \"get_characters_character_id_assets_forbidden\")) = { \"\$ref\": \"#/paths/characters/{character_id}/assets/get/responses/403\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_characters_character_id_assets_forbidden#ForbiddenResponse#g' work1.json

# Not Found = 404
jq "(.paths[][].responses[\"404\"] | select(.schema.title != \"get_alliances_alliance_id_not_found\")) = { \"\$ref\": \"#/paths/alliances/{alliance_id}/get/responses/404\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_alliances_alliance_id_not_found#NotFoundResponse#g' work1.json
