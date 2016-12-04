#!/bin/bash

cp esi.json work1.json

# Bad Request = 400
jq "(.paths[][].responses[\"400\"] | select(.schema.title != \"post_characters_character_id_mail_bad_request\")) = { \"\$ref\": \"#/paths/characters/{character_id}/mail/post/responses/400\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#post_characters_character_id_mail_bad_request#BadRequest#g' work1.json

# Forbidden = 403
jq "(.paths[][].responses[\"403\"] | select(.schema.title != \"get_characters_character_id_assets_forbidden\")) = { \"\$ref\": \"#/paths/characters/{character_id}/assets/get/responses/403\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_characters_character_id_assets_forbidden#Forbidden#g' work1.json

# Not Found = 404
jq "(.paths[][].responses[\"404\"] | select(.schema.title != \"get_alliances_alliance_id_not_found\")) = { \"\$ref\": \"#/paths/alliances/{alliance_id}/get/responses/404\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_alliances_alliance_id_not_found#NotFound#g' work1.json

# Unprocessable Entity = 422
jq "(.paths[][].responses[\"422\"] | select(.schema.title != \"get_characters_character_id_unprocessable_entity\")) = { \"\$ref\": \"#/paths/characters/{character_id}/get/responses/422\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_characters_character_id_unprocessable_entity#UnprocessableEntity#g' work1.json

# Internal Server Error = 500
jq "(.paths[][].responses[\"500\"] | select(.schema.title != \"get_alliances_internal_server_error\")) = { \"\$ref\": \"#/paths/alliances/get/responses/500\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_alliances_internal_server_error#InternalServerError#g' work1.json

mv work1.json esi.json
