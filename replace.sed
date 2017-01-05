# Objects
# jq '.paths[].get.responses["200"].schema.properties[]? | select(.type == "object") | .title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_characters_character_id_clones_home_location/CloneHomeLocation/g
s/get_killmails_killmail_id_killmail_hash_victim/KillmailVictim/g
s/get_wars_war_id_aggressor/Aggressor/g
s/get_wars_war_id_defender/Defender/g

# Objects in Arrays
# jq '.paths[].get.responses["200"].schema.properties[]? | select(.type == "array") | .items | select(.type == "object") | .title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_characters_character_id_clones_jump_clone/Clone/g
s/get_characters_character_id_mail_labels_label/MailLabel/g
s/get_characters_character_id_planets_planet_id_link/PlanetLink/g
s/get_characters_character_id_planets_planet_id_pin/PlanetPin/g
s/get_characters_character_id_planets_planet_id_route/PlanetRoute/g
s/get_characters_character_id_skills_skill/Skill/g
s/get_killmails_killmail_id_killmail_hash_attacker/KillmailAttacker/g
s/get_wars_war_id_ally/WarAlly/g

# Inner Objects
# jq '.paths[].get.responses["200"].schema.items.properties[]? | select(.type == "object") | .title' esi.json | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_characters_character_id_bookmarks_target/BookmarkTarget/g
s/get_corporations_corporation_id_alliancehistory_alliance/Alliance/g
# jq '.paths[].get.responses["200"].schema.items.properties[]? | select(.properties != null).properties[] | select(.type == "object").title' esi.json | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_characters_character_id_bookmarks_item/BookmarkItem/g

# Objects in post/put
# jq '.paths[][].parameters[].schema.title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/post_characters_character_id_cspa_characters/CspaCharacters/g
s/post_characters_character_id_mail_labels_label/MailLabelSimple/g
s/post_characters_character_id_mail_mail/Mail/g
s/post_fleets_fleet_id_members_invitation/FleetInvitation/g
s/post_universe_names_ids/EntityIds/g
s/put_characters_character_id_mail_mail_id_contents/MailMetaData/g
s/put_characters_character_id_calendar_event_id_response/EventResponseStatus/g
s/put_fleets_fleet_id_members_member_id_movement/FleetMemberMovement/g
s/put_fleets_fleet_id_new_settings/FleetNewSettings/g
s/put_fleets_fleet_id_squads_squad_id_naming/FleetSquadNaming/g
s/put_fleets_fleet_id_wings_wing_id_naming/FleetWingNaming/g

# Other objects
s/get_characters_character_id_planets_planet_id_content/PlanetContent/
s/get_characters_character_id_planets_planet_id_extractor_details/PlanetExtractorDetails/
s/get_characters_character_id_planets_planet_id_factory_details/PlanetFactoryDetails/
s/get_characters_character_id_planets_planet_id_head/PlanetHead/
s/get_characters_character_id_planets_planet_id_waypoint/PlanetWaypoint/
s/get_fleets_fleet_id_wings_squad/Squad/
s/get_industry_systems_cost_indice/SystemCostIndice/
s/get_insurance_prices_level/InsurancePriceLevel/
s/get_sovereignty_campaigns_participant/SovereigntyCampaignParticipant/
s/post_ui_openwindow_newmail_new_mail/UiNewMail/

# Post 200
# jq '.paths[].post.responses["200"].schema.items.title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/post_universe_names_200_ok/UniverseNamesResponse/g

# Post 201
# jq '.paths[].post.responses["201"].schema.title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/post_characters_character_id_contacts_created/AddContactsResponse/g
s/post_characters_character_id_cspa_created/CspaCostResponse/g
s/post_characters_character_id_mail_created/SendMailResponse/g
s/post_characters_character_id_mail_labels_created/CreateMailLabelResponse/g
s/post_fleets_fleet_id_wings_created/FleetWingCreatedResponse/g
s/post_fleets_fleet_id_wings_wing_id_squads_created/FleetSquadCreatedResponse/g

# Responses Objects
# jq '.paths[].get.responses["200"].schema.items.title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_alliances_alliance_id_corporations_200_ok/AllianceCorporationsResponse/g
s/get_alliances_alliance_id_ok/AllianceResponse/g
s/get_alliances_names_200_ok/AllianceNamesResponse/g
s/get_characters_character_id_assets_200_ok/CharacterAssetsResponse/g
s/get_characters_character_id_bookmarks_200_ok/CharacterBookmarksResponse/g
s/get_characters_character_id_bookmarks_folders_200_ok/CharacterBookmarkFoldersResponse/g
s/get_characters_character_id_calendar_200_ok/CharacterCalendarResponse/g
s/get_characters_character_id_corporationhistory_200_ok/CharacterCorporationHistoryResponse/g
s/get_characters_character_id_killmails_recent_200_ok/CharacterKillmailsResponse/g
s/get_characters_character_id_mail_200_ok/MailHeadersResponse/g
s/get_characters_character_id_mail_lists_200_ok/CharacterMailinglistsResponse/g
s/get_characters_character_id_planets_200_ok/CharacterPlanetsResponse/g
s/get_characters_character_id_skillqueue_200_ok/CharacterSkillqueueResponse/g
s/get_characters_character_id_wallets_200_ok/CharacterWalletsResponse/g
s/get_characters_character_id_wallets_journal_200_ok/CharacterWalletJournalResponse/g
s/get_characters_character_id_wallets_transactions_200_ok/CharacterWalletTransactionsResponse/g
s/get_characters_names_200_ok/CharacterNamesResponse/g
s/get_corporations_corporation_id_alliancehistory_200_ok/CorporationAlliancesHistoryResponse/g
s/get_corporations_corporation_id_members_200_ok/CorporationMembersResponse/g
s/get_corporations_corporation_id_roles_200_ok/CorporationRolesResponse/g
s/get_corporations_names_200_ok/CorporationNamesResponse/g
s/get_fleets_fleet_id_members_200_ok/FleetMembersResponse/g
s/get_fleets_fleet_id_wings_200_ok/FleetWingsResponse/g
s/get_characters_character_id_contacts_200_ok/ContactsResponse/g
s/get_characters_character_id_contacts_labels_200_ok/ContactLabelsResponse/g
s/get_incursions_200_ok/IncursionsResponse/g
s/get_industry_facilities_200_ok/IndustryFacilitiesResponse/g
s/get_industry_systems_200_ok/IndustrySystemsResponse/g
s/get_insurance_prices_200_ok/InsurancePricesResponse/g
s/get_markets_prices_200_ok/MarketPricesResponse/g
s/get_markets_region_id_history_200_ok/MarketHistoryResponse/g
s/get_markets_region_id_orders_200_ok/MarketOrdersResponse/g
s/get_sovereignty_campaigns_200_ok/SovereigntyCampaignsResponse/g
s/get_sovereignty_structures_200_ok/SovereigntyStructuresResponse/g
s/get_universe_structures_200_ok/StructuresResponse/g
s/get_wars_200_ok/WarsResponse/g
s/get_wars_war_id_killmails_200_ok/WarKillmailsResponse/g

# Responses Array
# jq '.paths[].get.responses["200"].schema | select(.type != "array") | .title' esi.json | grep -v null | sort | sed -e 's#"##g' -e 's#^#s/#' -e 's#$#//g#'
s/get_alliances_200_ok/AlliancesResponse/g
s/get_alliances_alliance_id_icons_ok/AllianceIconsResponse/g
s/get_characters_character_id_calendar_event_id_ok/CharacterCalendarEventResponse/g
s/get_characters_character_id_clones_ok/CharacterClonesResponse/g
s/get_characters_character_id_location_ok/CharacterLocationResponse/g
s/get_characters_character_id_mail_labels_ok/MailLabelsResponse/g
s/get_characters_character_id_mail_mail_id_ok/MailResponse/g
s/get_characters_character_id_ok/CharacterResponse/g
s/get_characters_character_id_planets_planet_id_ok/CharacterPlanetResponse/g
s/get_characters_character_id_portrait_ok/CharacterPortraitResponse/g
s/get_characters_character_id_search_ok/CharacterSearchResponse/g
s/get_characters_character_id_ship_ok/CharacterShipResponse/g
s/get_characters_character_id_skills_ok/CharacterSkillsResponse/g
s/get_corporations_corporation_id_icons_ok/CorporationIconsResponse/g
s/get_corporations_corporation_id_ok/CorporationResponse/g
s/get_fleets_fleet_id_ok/FleetResponse/g
s/get_killmails_killmail_id_killmail_hash_ok/KillmailResponse/g
s/get_search_ok/SearchResponse/g
s/get_universe_planets_planet_id_ok/PlanetResponse/g
s/get_universe_schematics_schematic_id_ok/PlanetFactorySchematicResponse/g
s/get_universe_stations_station_id_ok/StationResponse/g
s/get_universe_structures_structure_id_ok/StructureResponse/g
s/get_universe_systems_system_id_ok/SystemResponse/g
s/get_universe_types_type_id_ok/TypeResponse/g
s/get_wars_war_id_ok/WarResponse/g
