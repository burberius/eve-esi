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

# rate limit = 520
# echo "Transforming rate limit"
RATELIMIT=$(jq ".paths[][].responses[\"520\"] | select(.schema.title == \"get_corporations_corporation_id_contracts_contract_id_items_520_response\")" esi.json)
jq ".definitions.rate_limit = $RATELIMIT" work1.json > work2.json
jq "(.paths[][].responses[\"520\"]) = { \"\$ref\": \"#/definitions/rate_limit\" }" work2.json > work1.json
sed -i -e 's#get_corporations_corporation_id_contracts_contract_id_items_520_response#RateLimit#g' work1.json

# Bad request = 400
echo "Removing 400 Bad Request "
jq "(.paths[][].responses[\"400\"]) = {}" work1.json > work2.json
jq "(.definitions.bad_request) = {}" work2.json > work1.json

# Unauthorized = 401
echo "Removing 401 Unauthorized"
jq "(.paths[][].responses[\"401\"]) = {}" work1.json > work2.json
jq "(.definitions.unauthorized) = {}" work2.json > work1.json

# Internal server error = 500
echo "Removing 500 Internal Server Error"
jq "(.paths[][].responses[\"500\"]) = {}" work1.json > work2.json
jq "(.definitions.internal_server_error) = {}" work2.json > work1.json

# Not modified = 502
echo "Removing 502 Bad Gateway"
jq "(.paths[][].responses[\"502\"]) = {}" work1.json > work2.json
jq "(.definitions.bad_gateway) = {}" work2.json > work1.json

# Service unavailable = 503
echo "Removing 503 Service Unavailable"
jq "(.paths[][].responses[\"503\"]) = {}" work1.json > work2.json
jq "(.definitions.service_unavailable) = {}" work2.json > work1.json

# Add SSO scope to description
echo "Adding SSO scopes"
jq ".paths[][] | select(.security[0].evesso) | [.description , .security[].evesso[0]] | @csv" work1.json > tmp.csv
sed -i -e 's#\\#\\\\#g' tmp.csv
sed -i -e 's#\/#\\\/#g' tmp.csv
sed -i -e 's#\[#\\\[#g' tmp.csv
sed -i -e 's#\]#\\\]#g' tmp.csv
sed -i -e 's#\.#\\\.#g' tmp.csv
sed -i -e 's#\$#\\\$#g' tmp.csv
sed -i -e 's#\*#\\\*#g' tmp.csv
sed -i -e 's#\^#\\\^#g' tmp.csv
sed -e 's|"\\\\"\(.*\)\\\\",\\\\"\(.*\)\\\\""|s/\1/\1\\\\n\\\\nSSO Scope: \2/g|' tmp.csv > scope.sed
sed -f scope.sed work1.json > esi.json

# Clean up
rm work1.json work2.json tmp.csv scope.sed