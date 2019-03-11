#!/bin/bash

# evesso securityDefinitions
echo "Added evesso securityDefinitions"
jq "(.securityDefinitions.evesso) = {\"authorizationUrl\": \"https://login.eveonline.com/v2/oauth/authorize\",\"flow\": \"implicit\",\"scopes\": {}, \"type\": \"oauth2\"}" meta.json > meta_1.json

# evesso verify
echo "Added evesso to verify"
jq "(.paths.\"/verify/\".get.security[0].evesso) = {}" meta_1.json > meta.json

# Clean up
rm meta_1.json
