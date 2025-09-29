#!/bin/bash

for OLD in $(find . -name \*Inner\*.java); do
  NEW=$(echo $OLD | sed -e 's#Inner##g')
  mv $OLD $NEW
done

mv src/main/java/net/troja/eve/esi/model/CharacterContractItemsResponse.java src/main/java/net/troja/eve/esi/model/ContractItemsResponse.java
mv src/main/java/net/troja/eve/esi/model/CharacterSkillsResponseSkills.java src/main/java/net/troja/eve/esi/model/Skills.java
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponsePins.java src/main/java/net/troja/eve/esi/model/PlanetPin.java;
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponsePinsContents.java src/main/java/net/troja/eve/esi/model/PinContent.java
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponsePinsExtractorDetails.java src/main/java/net/troja/eve/esi/model/PinExtractorDetails.java
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponsePinsExtractorDetailsHeads.java src/main/java/net/troja/eve/esi/model/ExtractorDetailsHead.java
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponsePinsFactoryDetails.java src/main/java/net/troja/eve/esi/model/PinFactoryDetails.java
mv src/main/java/net/troja/eve/esi/model/CharacterPlanetResponseRoutes.java src/main/java/net/troja/eve/esi/model/PlanetRoute.java
mv src/main/java/net/troja/eve/esi/model/CharacterFactionWarfareStatsResponseKills.java src/main/java/net/troja/eve/esi/model/CharacterFactionWarfareKills.java
mv src/main/java/net/troja/eve/esi/model/CharacterFactionWarfareStatsResponseVictoryPoints.java src/main/java/net/troja/eve/esi/model/CharacterFactionWarfareVictoryPoints.java
mv src/main/java/net/troja/eve/esi/model/CorporationFactionWarfareStatsResponseKills.java src/main/java/net/troja/eve/esi/model/CorporationFactionWarfareKills.java
mv src/main/java/net/troja/eve/esi/model/CorporationFactionWarfareStatsResponseVictoryPoints.java src/main/java/net/troja/eve/esi/model/CorporationFactionWarfareVictoryPoints.java
mv src/main/java/net/troja/eve/esi/model/FactionWarfareStatsResponseKills.java src/main/java/net/troja/eve/esi/model/FactionWarfareKills.java
mv src/main/java/net/troja/eve/esi/model/FactionWarfareStatsResponseVictoryPoints.java src/main/java/net/troja/eve/esi/model/FactionWarfareVictoryPoints.java
mv src/main/java/net/troja/eve/esi/model/CharacterStandingsResponse.java src/main/java/net/troja/eve/esi/model/StandingsResponse.java
mv src/main/java/net/troja/eve/esi/model/IndustrySystemsResponseCostIndices.java src/main/java/net/troja/eve/esi/model/SystemCostIndice.java
mv src/main/java/net/troja/eve/esi/model/CharacterAssetsNamesPost.java src/main/java/net/troja/eve/esi/model/AssetsNamesResponse.java
mv src/main/java/net/troja/eve/esi/model/DogmaDynamicItemsResponseDogmaEffects.java src/main/java/net/troja/eve/esi/model/DogmaEffect.java
mv src/main/java/net/troja/eve/esi/model/DogmaDynamicItemsResponseDogmaAttributes.java src/main/java/net/troja/eve/esi/model/DogmaAttribute.java
mv src/main/java/net/troja/eve/esi/model/CharacterClonesResponseJumpClones.java src/main/java/net/troja/eve/esi/model/JumpClone.java
mv src/main/java/net/troja/eve/esi/model/CharacterAssetsLocationsPost.java src/main/java/net/troja/eve/esi/model/CharacterAssetsLocationsResponse.java
mv src/main/java/net/troja/eve/esi/model/CharacterAssetsLocationsPostPosition.java src/main/java/net/troja/eve/esi/model/AssetsLocationPosition.java
mv src/main/java/net/troja/eve/esi/model/CharacterClonesResponseHomeLocation.java src/main/java/net/troja/eve/esi/model/CloneHomeLocation.java
mv src/main/java/net/troja/eve/esi/model/CharacterFittingsResponseItems.java src/main/java/net/troja/eve/esi/model/FittingsItem.java
mv src/main/java/net/troja/eve/esi/model/CharacterMedalsResponseGraphics.java src/main/java/net/troja/eve/esi/model/MedalsGraphic.java
mv src/main/java/net/troja/eve/esi/model/CorporationDivisionsResponseHangar.java src/main/java/net/troja/eve/esi/model/DivisionsHangar.java
mv src/main/java/net/troja/eve/esi/model/CorporationDivisionsResponseWallet.java src/main/java/net/troja/eve/esi/model/DivisionsWallet.java

for DIR in `for F in $(find src -name \*.java); do dirname $F; done | sort -u`; do
  sed -i \
    -e 's#Inner##g' \
    -e 's#CharacterContractItemsResponse#ContractItemsResponse#g' \
    -e 's#CharacterSkillsResponseSkills#Skills#g' \
    -e 's#CharacterPlanetResponsePinsContents#PinContent#g' \
    -e 's#CharacterPlanetResponsePinsExtractorDetailsHeads#ExtractorDetailsHead#g' \
    -e 's#CharacterPlanetResponsePinsExtractorDetails#PinExtractorDetails#g' \
    -e 's#CharacterPlanetResponsePinsFactoryDetails#PinFactoryDetails#g' \
    -e 's#CharacterPlanetResponsePins#PlanetPin#g' \
    -e 's#CharacterPlanetResponseRoutes#PlanetRoute#g' \
    -e 's#FactionWarfareStatsResponseKills#FactionWarfareKills#g' \
    -e 's#FactionWarfareStatsResponseVictoryPoints#FactionWarfareVictoryPoints#g' \
    -e 's#CharacterStandingsResponse#StandingsResponse#g' \
    -e 's#IndustrySystemsResponseCostIndices#SystemCostIndice#g' \
    -e 's#CharacterAssetsNamesPost#AssetsNamesResponse#g' \
    -e 's#DogmaDynamicItemsResponseDogmaEffects#DogmaEffect#g' \
    -e 's#DogmaDynamicItemsResponseDogmaAttributes#DogmaAttribute#g' \
    -e 's#CharacterClonesResponseJumpClones#JumpClone#g' \
    -e 's#CharacterAssetsLocationsPostPosition#AssetsLocationPosition#g' \
    -e 's#CharacterAssetsLocationsPost#CharacterAssetsLocationsResponse#g' \
    -e 's#CharacterClonesResponseHomeLocation#CloneHomeLocation#g' \
    -e 's#CharacterFittingsResponseItems#FittingsItem#g' \
    -e 's#CharacterMedalsResponseGraphics#MedalsGraphic#g' \
    -e 's#CorporationDivisionsResponseHangar#DivisionsHangar#g' \
    -e 's#CorporationDivisionsResponseWallet#DivisionsWallet#g' \
    -e 's#CorporationFactionWarfareStatsResponseKills#CorporationFactionWarfareKills#g' \
    -e 's#CorporationFactionWarfareStatsResponseVictoryPoints#CorporationFactionWarfareVictoryPoints#g' \
    -e 's#getUniverseStructure#getStructure#g' \
      $DIR/*.java

done
