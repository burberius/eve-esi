#!/bin/bash

cp esi.json work1.json

# Position
POS=$(jq ".paths.\"/universe/structures/{structure_id}/\".get.responses.\"200\".schema.properties.position" esi.json)
jq ".definitions.position = $POS" esi.json > work1.json
jq "(.paths[][].responses[\"200\"].schema | select(.title == \"get_killmails_killmail_id_killmail_hash_ok\")).properties.victim.properties.position = { \"\$ref\": \"#/definitions/position\" }" work1.json > work2.json
jq "(.paths.\"/universe/structures/{structure_id}/\".get.responses.\"200\".schema.properties.position) = { \"\$ref\": \"#/definitions/position\" }" work2.json > work1.json
jq "(.paths.\"/characters/{character_id}/bookmarks/\".get.responses.\"200\".schema.items.properties.target.properties.coordinates) = { \"\$ref\": \"#/definitions/position\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_universe_structures_structure_id_position#Position#g' work1.json

# Recipient
RECIPIENT=$(jq ".paths.\"/characters/{character_id}/mail/{mail_id}/\".get.responses.\"200\".schema.properties.recipients.items" esi.json)
jq ".definitions.recipient = $RECIPIENT" work1.json > work2.json
jq "(.paths.\"/characters/{character_id}/mail/{mail_id}/\".get.responses.\"200\".schema.properties.recipients.items) = { \"\$ref\": \"#/definitions/recipient\" }" work2.json > work1.json
jq "(.paths[].get.responses[\"200\"].schema.items.properties | select(.recipients.title == \"get_characters_character_id_mail_recipients\") | .recipients.items) = { \"\$ref\": \"#/definitions/recipient\" }" work1.json > work2.json
jq "(.paths[].post.parameters[1].schema.properties.recipients | select(.title == \"post_characters_character_id_mail_recipients\")).items = { \"\$ref\": \"#/definitions/recipient\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_mail_mail_id_recipient#Recipient#g' work1.json

# Killmail items are double named
jq "(.paths.\"/killmails/{killmail_id}/{killmail_hash}/\".get.responses[\"200\"].schema.properties.victim.properties.items.items.properties.items.items.title) = \"KillmailSubItem\"" work1.json > work2.json
sed -e 's#get_killmails_killmail_id_killmail_hash_item#KillmailItem#' work2.json > work1.json

# Bad Request = 400
BADREQUEST=$(jq ".paths[][].responses[\"400\"] | select(.schema.title == \"post_characters_character_id_mail_bad_request\")" esi.json)
jq ".definitions.bad_request = $BADREQUEST" work1.json > work2.json
jq "(.paths[][].responses[\"400\"]) = { \"\$ref\": \"#/definitions/bad_request\" }" work2.json > work1.json
sed -i -e 's#post_characters_character_id_mail_bad_request#BadRequest#g' work1.json

# Forbidden = 403
FORBIDDEN=$(jq ".paths[][].responses[\"403\"] | select(.schema.title == \"get_characters_character_id_assets_forbidden\")" esi.json)
jq ".definitions.forbidden = $FORBIDDEN" work1.json > work2.json
jq "(.paths[][].responses[\"403\"]) = { \"\$ref\": \"#/definitions/forbidden\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_assets_forbidden#Forbidden#g' work1.json

# Not Found = 404
NOTFOUND=$(jq ".paths[][].responses[\"404\"] | select(.schema.title == \"get_alliances_alliance_id_not_found\")" esi.json)
jq ".definitions.not_found = $NOTFOUND" work1.json > work2.json
jq "(.paths[][].responses[\"404\"]) = { \"\$ref\": \"#/definitions/not_found\" }" work2.json > work1.json
sed -i -e 's#get_alliances_alliance_id_not_found#NotFound#g' work1.json

# Unprocessable Entity = 422
UNPROENTITY=$(jq ".paths[][].responses[\"422\"] | select(.schema.title == \"get_characters_character_id_unprocessable_entity\")" esi.json)
jq ".definitions.unprocessable_entity = $UNPROENTITY" work1.json > work2.json
jq "(.paths[][].responses[\"422\"]) = { \"\$ref\": \"#/definitions/unprocessable_entity\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_unprocessable_entity#UnprocessableEntity#g' work1.json

# Internal Server Error = 500
SERVERERROR=$(jq ".paths[][].responses[\"500\"] | select(.schema.title == \"get_alliances_internal_server_error\")" esi.json)
jq ".definitions.internal_server_error = $SERVERERROR" work1.json > work2.json
jq "(.paths[][].responses[\"500\"]) = { \"\$ref\": \"#/definitions/internal_server_error\" }" work2.json > work1.json
sed -i -e 's#get_alliances_internal_server_error#InternalServerError#g' work1.json

# Add SSO scope to description
jq ".paths[][] | select(.security[0].evesso) | [.description , .security[].evesso[0]] | @csv" work1.json > tmp.csv
sed -e 's|"\\"\(.*\)\\",\\"\(.*\)\\""|s#\1#\1\\n\\nSSO Scope: \2#g|' -e 's#\\#\\\\#g' tmp.csv > scope.sed
sed -f scope.sed work1.json > esi.json

# Clean up
rm work1.json work2.json tmp.csv scope.sed
