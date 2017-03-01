#!/bin/bash

# Position
echo "Transforming position"
POS=$(jq ".paths[].get.responses.\"200\".schema.properties.position | select(.title == \"get_universe_structures_structure_id_position\")" esi.json)
jq ".definitions.position = $POS" esi.json > work1.json
jq "(.paths[][].responses.\"200\".schema.properties | select(.position != null).position ) = { \"\$ref\": \"#/definitions/position\" }" work1.json > work2.json
jq "(.paths[][].responses.\"200\".schema.properties | select(.victim != null).victim.properties.position) = { \"\$ref\": \"#/definitions/position\" }" work2.json > work1.json
jq "(.paths[][].responses.\"200\".schema.items.properties | select(.target != null).target.properties.coordinates) = { \"\$ref\": \"#/definitions/position\" }" work1.json > work2.json
mv work2.json work1.json
sed -i -e 's#get_universe_structures_structure_id_position#Position#g' work1.json

# Recipient
echo "Transforming recipient"
RECIPIENT=$(jq ".paths[].get.responses.\"200\".schema.properties.recipients | select(.items != null).items" esi.json)
jq ".definitions.recipient = $RECIPIENT" work1.json > work2.json
jq "(.paths[].get.responses.\"200\".schema.properties.recipients | select(.items != null).items) = { \"\$ref\": \"#/definitions/recipient\" }" work2.json > work1.json
jq "(.paths[].get.responses[\"200\"].schema.items.properties.recipients | select(.items != null).items) = { \"\$ref\": \"#/definitions/recipient\" }" work1.json > work2.json
jq "(.paths[].post.parameters[2].schema.properties.recipients | select(.items != null).items) = { \"\$ref\": \"#/definitions/recipient\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_mail_mail_id_recipient#Recipient#g' work1.json

# Killmail items are double named
echo "Transforming double named killmail items"
jq "(.paths[].get.responses[\"200\"].schema.properties.victim.properties.items.items.properties.items.items | select(.title != null).title) = \"KillmailSubItem\"" work1.json > work2.json
sed -e 's#get_killmails_killmail_id_killmail_hash_item#KillmailItem#' work2.json > work1.json

# Fitting item
echo "Transforming fitting item"
FITTINGITEM=$(jq ".paths[].get.responses.\"200\".schema.items.properties.items | select(.items != null).items" esi.json)
jq ".definitions.fitting_item = $FITTINGITEM" work1.json > work2.json
jq "(.paths[].get.responses.\"200\".schema.items.properties.items | select(.items != null).items) = { \"\$ref\": \"#/definitions/fitting_item\" }" work2.json > work1.json
jq "(.paths[].post.parameters[2].schema.properties.items | select(.title == \"post_characters_character_id_fittings_items\").items) = { \"\$ref\": \"#/definitions/fitting_item\" }" work1.json > work2.json
mv work2.json work1.json

# Vulnerability window
echo "Transforming vulnerability windows"
VULNERABILITY=$(jq ".paths[].get.responses.\"200\".schema.items.properties.current_vul | select(.items != null).items" esi.json)
jq ".definitions.vulnerability_window = $VULNERABILITY" work1.json > work2.json
jq "(.paths[].get.responses.\"200\".schema.items.properties.current_vul | select(.items != null).items) = { \"\$ref\": \"#/definitions/vulnerability_window\" }" work2.json > work1.json
jq "(.paths[].get.responses.\"200\".schema.items.properties.next_vul | select(.items != null).items) = { \"\$ref\": \"#/definitions/vulnerability_window\" }" work1.json > work2.json
jq "(.paths[].put | select(.parameters != null).parameters[] | select(.name == \"new_schedule\").schema.items) = { \"\$ref\": \"#/definitions/vulnerability_window\" }" work2.json > work1.json

# Bad Request = 400
echo "Transforming bad request"
BADREQUEST=$(jq ".paths[][].responses[\"400\"] | select(.schema.title == \"post_characters_character_id_mail_bad_request\")" esi.json)
jq ".definitions.bad_request = $BADREQUEST" work1.json > work2.json
jq "(.paths[][].responses[\"400\"]) = { \"\$ref\": \"#/definitions/bad_request\" }" work2.json > work1.json
sed -i -e 's#post_characters_character_id_mail_bad_request#BadRequest#g' work1.json

# Forbidden = 403
echo "Transforming forbidden"
FORBIDDEN=$(jq ".paths[][].responses[\"403\"] | select(.schema.title == \"get_characters_character_id_assets_forbidden\")" esi.json)
jq ".definitions.forbidden = $FORBIDDEN" work1.json > work2.json
jq "(.paths[][].responses[\"403\"]) = { \"\$ref\": \"#/definitions/forbidden\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_assets_forbidden#Forbidden#g' work1.json

# Not Found = 404
echo "Transforming not found"
NOTFOUND=$(jq ".paths[][].responses[\"404\"] | select(.schema.title == \"get_alliances_alliance_id_not_found\")" esi.json)
jq ".definitions.not_found = $NOTFOUND" work1.json > work2.json
jq "(.paths[][].responses[\"404\"]) = { \"\$ref\": \"#/definitions/not_found\" }" work2.json > work1.json
sed -i -e 's#get_alliances_alliance_id_not_found#NotFound#g' work1.json

# Unprocessable Entity = 422
echo "Transforming unprocessable entity"
UNPROENTITY=$(jq ".paths[][].responses[\"422\"] | select(.schema.title == \"get_markets_region_id_history_unprocessable_entity\")" esi.json)
jq ".definitions.unprocessable_entity = $UNPROENTITY" work1.json > work2.json
jq "(.paths[][].responses[\"422\"]) = { \"\$ref\": \"#/definitions/unprocessable_entity\" }" work2.json > work1.json
sed -i -e 's#get_characters_character_id_unprocessable_entity#UnprocessableEntity#g' work1.json

# Internal Server Error = 500
echo "Transforming internal server error"
SERVERERROR=$(jq ".paths[][].responses[\"500\"] | select(.schema.title == \"get_alliances_internal_server_error\")" esi.json)
jq ".definitions.internal_server_error = $SERVERERROR" work1.json > work2.json
jq "(.paths[][].responses[\"500\"]) = { \"\$ref\": \"#/definitions/internal_server_error\" }" work2.json > work1.json
sed -i -e 's#get_alliances_internal_server_error#InternalServerError#g' work1.json

# Add SSO scope to description
echo "Adding SSO scopes"
jq ".paths[][] | select(.security[0].evesso) | [.description , .security[].evesso[0]] | @csv" work1.json > tmp.csv
sed -e 's|"\\"\(.*\)\\",\\"\(.*\)\\""|s#\1#\1\\n\\nSSO Scope: \2#g|' -e 's#\\#\\\\#g' tmp.csv > scope.sed
sed -f scope.sed work1.json > esi.json

# Clean up
rm work1.json work2.json tmp.csv scope.sed
