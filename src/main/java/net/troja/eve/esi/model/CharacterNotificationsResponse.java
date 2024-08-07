/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * The version of the OpenAPI document: 1.24
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package net.troja.eve.esi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.troja.eve.esi.JSON;

/**
 * 200 ok object
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CharacterNotificationsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_IS_READ = "is_read";
    @SerializedName(SERIALIZED_NAME_IS_READ)
    private Boolean isRead;

    public static final String SERIALIZED_NAME_NOTIFICATION_ID = "notification_id";
    @SerializedName(SERIALIZED_NAME_NOTIFICATION_ID)
    private Long notificationId;

    public static final String SERIALIZED_NAME_SENDER_ID = "sender_id";
    @SerializedName(SERIALIZED_NAME_SENDER_ID)
    private Integer senderId;

    /**
     * sender_type string
     */
    @JsonAdapter(SenderTypeEnum.Adapter.class)
    public enum SenderTypeEnum {
        CHARACTER("character"),

        CORPORATION("corporation"),

        ALLIANCE("alliance"),

        FACTION("faction"),

        OTHER("other");

        private String value;

        SenderTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SenderTypeEnum fromValue(String value) {
            for (SenderTypeEnum b : SenderTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<SenderTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SenderTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SenderTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SenderTypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SENDER_TYPE = "sender_type";
    @SerializedName(SERIALIZED_NAME_SENDER_TYPE)
    private String senderType;
    private SenderTypeEnum senderTypeEnum;

    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;

    public static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
    @SerializedName(SERIALIZED_NAME_TIMESTAMP)
    private OffsetDateTime timestamp;

    /**
     * type string
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        ACCEPTEDALLY("AcceptedAlly"),

        ACCEPTEDSURRENDER("AcceptedSurrender"),

        AGENTRETIREDTRIGRAVIAN("AgentRetiredTrigravian"),

        ALLANCHORINGMSG("AllAnchoringMsg"),

        ALLMAINTENANCEBILLMSG("AllMaintenanceBillMsg"),

        ALLSTRUCINVULNERABLEMSG("AllStrucInvulnerableMsg"),

        ALLSTRUCTVULNERABLEMSG("AllStructVulnerableMsg"),

        ALLWARCORPJOINEDALLIANCEMSG("AllWarCorpJoinedAllianceMsg"),

        ALLWARDECLAREDMSG("AllWarDeclaredMsg"),

        ALLWARINVALIDATEDMSG("AllWarInvalidatedMsg"),

        ALLWARRETRACTEDMSG("AllWarRetractedMsg"),

        ALLWARSURRENDERMSG("AllWarSurrenderMsg"),

        ALLIANCECAPITALCHANGED("AllianceCapitalChanged"),

        ALLIANCEWARDECLAREDV2("AllianceWarDeclaredV2"),

        ALLYCONTRACTCANCELLED("AllyContractCancelled"),

        ALLYJOINEDWARAGGRESSORMSG("AllyJoinedWarAggressorMsg"),

        ALLYJOINEDWARALLYMSG("AllyJoinedWarAllyMsg"),

        ALLYJOINEDWARDEFENDERMSG("AllyJoinedWarDefenderMsg"),

        BATTLEPUNISHFRIENDLYFIRE("BattlePunishFriendlyFire"),

        BILLOUTOFMONEYMSG("BillOutOfMoneyMsg"),

        BILLPAIDCORPALLMSG("BillPaidCorpAllMsg"),

        BOUNTYCLAIMMSG("BountyClaimMsg"),

        BOUNTYESSSHARED("BountyESSShared"),

        BOUNTYESSTAKEN("BountyESSTaken"),

        BOUNTYPLACEDALLIANCE("BountyPlacedAlliance"),

        BOUNTYPLACEDCHAR("BountyPlacedChar"),

        BOUNTYPLACEDCORP("BountyPlacedCorp"),

        BOUNTYYOURBOUNTYCLAIMED("BountyYourBountyClaimed"),

        BUDDYCONNECTCONTACTADD("BuddyConnectContactAdd"),

        CHARAPPACCEPTMSG("CharAppAcceptMsg"),

        CHARAPPREJECTMSG("CharAppRejectMsg"),

        CHARAPPWITHDRAWMSG("CharAppWithdrawMsg"),

        CHARLEFTCORPMSG("CharLeftCorpMsg"),

        CHARMEDALMSG("CharMedalMsg"),

        CHARTERMINATIONMSG("CharTerminationMsg"),

        CLONEACTIVATIONMSG("CloneActivationMsg"),

        CLONEACTIVATIONMSG2("CloneActivationMsg2"),

        CLONEMOVEDMSG("CloneMovedMsg"),

        CLONEREVOKEDMSG1("CloneRevokedMsg1"),

        CLONEREVOKEDMSG2("CloneRevokedMsg2"),

        COMBATOPERATIONFINISHED("CombatOperationFinished"),

        CONTACTADD("ContactAdd"),

        CONTACTEDIT("ContactEdit"),

        CONTAINERPASSWORDMSG("ContainerPasswordMsg"),

        CONTRACTREGIONCHANGEDTOPOCHVEN("ContractRegionChangedToPochven"),

        CORPALLBILLMSG("CorpAllBillMsg"),

        CORPAPPACCEPTMSG("CorpAppAcceptMsg"),

        CORPAPPINVITEDMSG("CorpAppInvitedMsg"),

        CORPAPPNEWMSG("CorpAppNewMsg"),

        CORPAPPREJECTCUSTOMMSG("CorpAppRejectCustomMsg"),

        CORPAPPREJECTMSG("CorpAppRejectMsg"),

        CORPBECAMEWARELIGIBLE("CorpBecameWarEligible"),

        CORPDIVIDENDMSG("CorpDividendMsg"),

        CORPFRIENDLYFIREDISABLETIMERCOMPLETED("CorpFriendlyFireDisableTimerCompleted"),

        CORPFRIENDLYFIREDISABLETIMERSTARTED("CorpFriendlyFireDisableTimerStarted"),

        CORPFRIENDLYFIREENABLETIMERCOMPLETED("CorpFriendlyFireEnableTimerCompleted"),

        CORPFRIENDLYFIREENABLETIMERSTARTED("CorpFriendlyFireEnableTimerStarted"),

        CORPKICKED("CorpKicked"),

        CORPLIQUIDATIONMSG("CorpLiquidationMsg"),

        CORPNEWCEOMSG("CorpNewCEOMsg"),

        CORPNEWSMSG("CorpNewsMsg"),

        CORPNOLONGERWARELIGIBLE("CorpNoLongerWarEligible"),

        CORPOFFICEEXPIRATIONMSG("CorpOfficeExpirationMsg"),

        CORPSTRUCTLOSTMSG("CorpStructLostMsg"),

        CORPTAXCHANGEMSG("CorpTaxChangeMsg"),

        CORPVOTECEOREVOKEDMSG("CorpVoteCEORevokedMsg"),

        CORPVOTEMSG("CorpVoteMsg"),

        CORPWARDECLAREDMSG("CorpWarDeclaredMsg"),

        CORPWARDECLAREDV2("CorpWarDeclaredV2"),

        CORPWARFIGHTINGLEGALMSG("CorpWarFightingLegalMsg"),

        CORPWARINVALIDATEDMSG("CorpWarInvalidatedMsg"),

        CORPWARRETRACTEDMSG("CorpWarRetractedMsg"),

        CORPWARSURRENDERMSG("CorpWarSurrenderMsg"),

        CORPORATIONGOALCLOSED("CorporationGoalClosed"),

        CORPORATIONGOALCOMPLETED("CorporationGoalCompleted"),

        CORPORATIONGOALCREATED("CorporationGoalCreated"),

        CORPORATIONGOALNAMECHANGE("CorporationGoalNameChange"),

        CORPORATIONLEFT("CorporationLeft"),

        CUSTOMSMSG("CustomsMsg"),

        DECLAREWAR("DeclareWar"),

        DISTRICTATTACKED("DistrictAttacked"),

        DUSTAPPACCEPTEDMSG("DustAppAcceptedMsg"),

        ESSMAINBANKLINK("ESSMainBankLink"),

        ENTOSISCAPTURESTARTED("EntosisCaptureStarted"),

        EXPERTSYSTEMEXPIRED("ExpertSystemExpired"),

        EXPERTSYSTEMEXPIRYIMMINENT("ExpertSystemExpiryImminent"),

        FWALLIANCEKICKMSG("FWAllianceKickMsg"),

        FWALLIANCEWARNINGMSG("FWAllianceWarningMsg"),

        FWCHARKICKMSG("FWCharKickMsg"),

        FWCHARRANKGAINMSG("FWCharRankGainMsg"),

        FWCHARRANKLOSSMSG("FWCharRankLossMsg"),

        FWCHARWARNINGMSG("FWCharWarningMsg"),

        FWCORPJOINMSG("FWCorpJoinMsg"),

        FWCORPKICKMSG("FWCorpKickMsg"),

        FWCORPLEAVEMSG("FWCorpLeaveMsg"),

        FWCORPWARNINGMSG("FWCorpWarningMsg"),

        FACWARCORPJOINREQUESTMSG("FacWarCorpJoinRequestMsg"),

        FACWARCORPJOINWITHDRAWMSG("FacWarCorpJoinWithdrawMsg"),

        FACWARCORPLEAVEREQUESTMSG("FacWarCorpLeaveRequestMsg"),

        FACWARCORPLEAVEWITHDRAWMSG("FacWarCorpLeaveWithdrawMsg"),

        FACWARLPDISQUALIFIEDEVENT("FacWarLPDisqualifiedEvent"),

        FACWARLPDISQUALIFIEDKILL("FacWarLPDisqualifiedKill"),

        FACWARLPPAYOUTEVENT("FacWarLPPayoutEvent"),

        FACWARLPPAYOUTKILL("FacWarLPPayoutKill"),

        GAMETIMEADDED("GameTimeAdded"),

        GAMETIMERECEIVED("GameTimeReceived"),

        GAMETIMESENT("GameTimeSent"),

        GIFTRECEIVED("GiftReceived"),

        IHUBDESTROYEDBYBILLFAILURE("IHubDestroyedByBillFailure"),

        INCURSIONCOMPLETEDMSG("IncursionCompletedMsg"),

        INDUSTRYOPERATIONFINISHED("IndustryOperationFinished"),

        INDUSTRYTEAMAUCTIONLOST("IndustryTeamAuctionLost"),

        INDUSTRYTEAMAUCTIONWON("IndustryTeamAuctionWon"),

        INFRASTRUCTUREHUBBILLABOUTTOEXPIRE("InfrastructureHubBillAboutToExpire"),

        INSURANCEEXPIRATIONMSG("InsuranceExpirationMsg"),

        INSURANCEFIRSTSHIPMSG("InsuranceFirstShipMsg"),

        INSURANCEINVALIDATEDMSG("InsuranceInvalidatedMsg"),

        INSURANCEISSUEDMSG("InsuranceIssuedMsg"),

        INSURANCEPAYOUTMSG("InsurancePayoutMsg"),

        INVASIONCOMPLETEDMSG("InvasionCompletedMsg"),

        INVASIONSYSTEMLOGIN("InvasionSystemLogin"),

        INVASIONSYSTEMSTART("InvasionSystemStart"),

        JUMPCLONEDELETEDMSG1("JumpCloneDeletedMsg1"),

        JUMPCLONEDELETEDMSG2("JumpCloneDeletedMsg2"),

        KILLREPORTFINALBLOW("KillReportFinalBlow"),

        KILLREPORTVICTIM("KillReportVictim"),

        KILLRIGHTAVAILABLE("KillRightAvailable"),

        KILLRIGHTAVAILABLEOPEN("KillRightAvailableOpen"),

        KILLRIGHTEARNED("KillRightEarned"),

        KILLRIGHTUNAVAILABLE("KillRightUnavailable"),

        KILLRIGHTUNAVAILABLEOPEN("KillRightUnavailableOpen"),

        KILLRIGHTUSED("KillRightUsed"),

        LPAUTOREDEEMED("LPAutoRedeemed"),

        LOCATECHARMSG("LocateCharMsg"),

        MADEWARMUTUAL("MadeWarMutual"),

        MERCOFFERRETRACTEDMSG("MercOfferRetractedMsg"),

        MERCOFFEREDNEGOTIATIONMSG("MercOfferedNegotiationMsg"),

        MISSIONCANCELEDTRIGLAVIAN("MissionCanceledTriglavian"),

        MISSIONOFFEREXPIRATIONMSG("MissionOfferExpirationMsg"),

        MISSIONTIMEOUTMSG("MissionTimeoutMsg"),

        MOONMININGAUTOMATICFRACTURE("MoonminingAutomaticFracture"),

        MOONMININGEXTRACTIONCANCELLED("MoonminingExtractionCancelled"),

        MOONMININGEXTRACTIONFINISHED("MoonminingExtractionFinished"),

        MOONMININGEXTRACTIONSTARTED("MoonminingExtractionStarted"),

        MOONMININGLASERFIRED("MoonminingLaserFired"),

        MUTUALWAREXPIRED("MutualWarExpired"),

        MUTUALWARINVITEACCEPTED("MutualWarInviteAccepted"),

        MUTUALWARINVITEREJECTED("MutualWarInviteRejected"),

        MUTUALWARINVITESENT("MutualWarInviteSent"),

        NPCSTANDINGSGAINED("NPCStandingsGained"),

        NPCSTANDINGSLOST("NPCStandingsLost"),

        OFFERTOALLYRETRACTED("OfferToAllyRetracted"),

        OFFEREDSURRENDER("OfferedSurrender"),

        OFFEREDTOALLY("OfferedToAlly"),

        OFFICELEASECANCELEDINSUFFICIENTSTANDINGS("OfficeLeaseCanceledInsufficientStandings"),

        OLDLSCMESSAGES("OldLscMessages"),

        OPERATIONFINISHED("OperationFinished"),

        ORBITALATTACKED("OrbitalAttacked"),

        ORBITALREINFORCED("OrbitalReinforced"),

        OWNERSHIPTRANSFERRED("OwnershipTransferred"),

        RAFFLECREATED("RaffleCreated"),

        RAFFLEEXPIRED("RaffleExpired"),

        RAFFLEFINISHED("RaffleFinished"),

        REIMBURSEMENTMSG("ReimbursementMsg"),

        RESEARCHMISSIONAVAILABLEMSG("ResearchMissionAvailableMsg"),

        RETRACTSWAR("RetractsWar"),

        SPAUTOREDEEMED("SPAutoRedeemed"),

        SEASONALCHALLENGECOMPLETED("SeasonalChallengeCompleted"),

        SKINSEQUENCINGCOMPLETED("SkinSequencingCompleted"),

        SKYHOOKDEPLOYED("SkyhookDeployed"),

        SKYHOOKDESTROYED("SkyhookDestroyed"),

        SKYHOOKLOSTSHIELDS("SkyhookLostShields"),

        SKYHOOKONLINE("SkyhookOnline"),

        SKYHOOKUNDERATTACK("SkyhookUnderAttack"),

        SOVALLCLAIMAQUIREDMSG("SovAllClaimAquiredMsg"),

        SOVALLCLAIMLOSTMSG("SovAllClaimLostMsg"),

        SOVCOMMANDNODEEVENTSTARTED("SovCommandNodeEventStarted"),

        SOVCORPBILLLATEMSG("SovCorpBillLateMsg"),

        SOVCORPCLAIMFAILMSG("SovCorpClaimFailMsg"),

        SOVDISRUPTORMSG("SovDisruptorMsg"),

        SOVSTATIONENTEREDFREEPORT("SovStationEnteredFreeport"),

        SOVSTRUCTUREDESTROYED("SovStructureDestroyed"),

        SOVSTRUCTUREREINFORCED("SovStructureReinforced"),

        SOVSTRUCTURESELFDESTRUCTCANCEL("SovStructureSelfDestructCancel"),

        SOVSTRUCTURESELFDESTRUCTFINISHED("SovStructureSelfDestructFinished"),

        SOVSTRUCTURESELFDESTRUCTREQUESTED("SovStructureSelfDestructRequested"),

        SOVEREIGNTYIHDAMAGEMSG("SovereigntyIHDamageMsg"),

        SOVEREIGNTYSBUDAMAGEMSG("SovereigntySBUDamageMsg"),

        SOVEREIGNTYTCUDAMAGEMSG("SovereigntyTCUDamageMsg"),

        STATIONAGGRESSIONMSG1("StationAggressionMsg1"),

        STATIONAGGRESSIONMSG2("StationAggressionMsg2"),

        STATIONCONQUERMSG("StationConquerMsg"),

        STATIONSERVICEDISABLED("StationServiceDisabled"),

        STATIONSERVICEENABLED("StationServiceEnabled"),

        STATIONSTATECHANGEMSG("StationStateChangeMsg"),

        STORYLINEMISSIONAVAILABLEMSG("StoryLineMissionAvailableMsg"),

        STRUCTUREANCHORING("StructureAnchoring"),

        STRUCTURECOURIERCONTRACTCHANGED("StructureCourierContractChanged"),

        STRUCTUREDESTROYED("StructureDestroyed"),

        STRUCTUREFUELALERT("StructureFuelAlert"),

        STRUCTUREIMPENDINGABANDONMENTASSETSATRISK("StructureImpendingAbandonmentAssetsAtRisk"),

        STRUCTUREITEMSDELIVERED("StructureItemsDelivered"),

        STRUCTUREITEMSMOVEDTOSAFETY("StructureItemsMovedToSafety"),

        STRUCTURELOSTARMOR("StructureLostArmor"),

        STRUCTURELOSTSHIELDS("StructureLostShields"),

        STRUCTUREONLINE("StructureOnline"),

        STRUCTUREPAINTPURCHASED("StructurePaintPurchased"),

        STRUCTURESERVICESOFFLINE("StructureServicesOffline"),

        STRUCTUREUNANCHORING("StructureUnanchoring"),

        STRUCTUREUNDERATTACK("StructureUnderAttack"),

        STRUCTUREWENTHIGHPOWER("StructureWentHighPower"),

        STRUCTUREWENTLOWPOWER("StructureWentLowPower"),

        STRUCTURESJOBSCANCELLED("StructuresJobsCancelled"),

        STRUCTURESJOBSPAUSED("StructuresJobsPaused"),

        STRUCTURESREINFORCEMENTCHANGED("StructuresReinforcementChanged"),

        TOWERALERTMSG("TowerAlertMsg"),

        TOWERRESOURCEALERTMSG("TowerResourceAlertMsg"),

        TRANSACTIONREVERSALMSG("TransactionReversalMsg"),

        TUTORIALMSG("TutorialMsg"),

        WARADOPTED_("WarAdopted "),

        WARALLYINHERITED("WarAllyInherited"),

        WARALLYOFFERDECLINEDMSG("WarAllyOfferDeclinedMsg"),

        WARCONCORDINVALIDATES("WarConcordInvalidates"),

        WARDECLARED("WarDeclared"),

        WARENDEDHQSECURITYDROP("WarEndedHqSecurityDrop"),

        WARHQREMOVEDFROMSPACE("WarHQRemovedFromSpace"),

        WARINHERITED("WarInherited"),

        WARINVALID("WarInvalid"),

        WARRETRACTED("WarRetracted"),

        WARRETRACTEDBYCONCORD("WarRetractedByConcord"),

        WARSURRENDERDECLINEDMSG("WarSurrenderDeclinedMsg"),

        WARSURRENDEROFFERMSG("WarSurrenderOfferMsg");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    private String type;
    private TypeEnum typeEnum;

    public CharacterNotificationsResponse() {
    }

    public CharacterNotificationsResponse isRead(Boolean isRead) {

        this.isRead = isRead;
        return this;
    }

    /**
     * is_read boolean
     * 
     * @return isRead
     **/
    @javax.annotation.Nullable
    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public CharacterNotificationsResponse notificationId(Long notificationId) {

        this.notificationId = notificationId;
        return this;
    }

    /**
     * notification_id integer
     * 
     * @return notificationId
     **/
    @javax.annotation.Nonnull
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public CharacterNotificationsResponse senderId(Integer senderId) {

        this.senderId = senderId;
        return this;
    }

    /**
     * sender_id integer
     * 
     * @return senderId
     **/
    @javax.annotation.Nonnull
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public CharacterNotificationsResponse senderTypeString(String senderType) {

        this.senderType = senderType;
        return this;
    }

    public CharacterNotificationsResponse senderType(SenderTypeEnum senderTypeEnum) {

        this.senderTypeEnum = senderTypeEnum;
        return this;
    }

    /**
     * sender_type string
     * 
     * @return senderType
     **/
    @javax.annotation.Nonnull
    public SenderTypeEnum getSenderType() {
        if (senderTypeEnum == null) {
            senderTypeEnum = SenderTypeEnum.fromValue(senderType);
        }
        return senderTypeEnum;
    }

    public String getSenderTypeString() {
        return senderType;
    }

    public void setSenderType(SenderTypeEnum senderTypeEnum) {
        this.senderTypeEnum = senderTypeEnum;
    }

    public void setSenderTypeString(String senderType) {
        this.senderType = senderType;
    }

    public CharacterNotificationsResponse text(String text) {

        this.text = text;
        return this;
    }

    /**
     * text string
     * 
     * @return text
     **/
    @javax.annotation.Nullable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CharacterNotificationsResponse timestamp(OffsetDateTime timestamp) {

        this.timestamp = timestamp;
        return this;
    }

    /**
     * timestamp string
     * 
     * @return timestamp
     **/
    @javax.annotation.Nonnull
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public CharacterNotificationsResponse typeString(String type) {

        this.type = type;
        return this;
    }

    public CharacterNotificationsResponse type(TypeEnum typeEnum) {

        this.typeEnum = typeEnum;
        return this;
    }

    /**
     * type string
     * 
     * @return type
     **/
    @javax.annotation.Nonnull
    public TypeEnum getType() {
        if (typeEnum == null) {
            typeEnum = TypeEnum.fromValue(type);
        }
        return typeEnum;
    }

    public String getTypeString() {
        return type;
    }

    public void setType(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public void setTypeString(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterNotificationsResponse characterNotificationsResponse = (CharacterNotificationsResponse) o;
        return Objects.equals(this.isRead, characterNotificationsResponse.isRead)
                && Objects.equals(this.notificationId, characterNotificationsResponse.notificationId)
                && Objects.equals(this.senderId, characterNotificationsResponse.senderId)
                && Objects.equals(this.senderType, characterNotificationsResponse.senderType)
                && Objects.equals(this.text, characterNotificationsResponse.text)
                && Objects.equals(this.timestamp, characterNotificationsResponse.timestamp)
                && Objects.equals(this.type, characterNotificationsResponse.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRead, notificationId, senderId, senderType, text, timestamp, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CharacterNotificationsResponse {\n");
        sb.append("    isRead: ").append(toIndentedString(isRead)).append("\n");
        sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
        sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
        sb.append("    senderType: ").append(toIndentedString(senderType)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("is_read");
        openapiFields.add("notification_id");
        openapiFields.add("sender_id");
        openapiFields.add("sender_type");
        openapiFields.add("text");
        openapiFields.add("timestamp");
        openapiFields.add("type");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("notification_id");
        openapiRequiredFields.add("sender_id");
        openapiRequiredFields.add("sender_type");
        openapiRequiredFields.add("timestamp");
        openapiRequiredFields.add("type");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj
     *            JSON Object
     * @throws IOException
     *             if the JSON Object is invalid with respect to
     *             CharacterNotificationsResponse
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (!CharacterNotificationsResponse.openapiRequiredFields.isEmpty()) { // has
                                                                                   // required
                                                                                   // fields
                                                                                   // but
                                                                                   // JSON
                                                                                   // object
                                                                                   // is
                                                                                   // null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in CharacterNotificationsResponse is not found in the empty JSON string",
                                CharacterNotificationsResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CharacterNotificationsResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `CharacterNotificationsResponse` properties. JSON: %s",
                                entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the
        // JSON string
        for (String requiredField : CharacterNotificationsResponse.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format(
                        "The required field `%s` is not found in the JSON string: %s", requiredField,
                        jsonObj.toString()));
            }
        }
        if (!jsonObj.get("sender_type").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `sender_type` to be a primitive type in the JSON string but got `%s`", jsonObj
                            .get("sender_type").toString()));
        }
        if ((jsonObj.get("text") != null && !jsonObj.get("text").isJsonNull())
                && !jsonObj.get("text").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `text` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("text").toString()));
        }
        if (!jsonObj.get("type").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format(
                    "Expected the field `type` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("type").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CharacterNotificationsResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes
                             // 'CharacterNotificationsResponse' and its
                             // subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CharacterNotificationsResponse> thisAdapter = gson.getDelegateAdapter(this,
                    TypeToken.get(CharacterNotificationsResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<CharacterNotificationsResponse>() {
                @Override
                public void write(JsonWriter out, CharacterNotificationsResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CharacterNotificationsResponse read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CharacterNotificationsResponse given an JSON string
     *
     * @param jsonString
     *            JSON string
     * @return An instance of CharacterNotificationsResponse
     * @throws IOException
     *             if the JSON string is invalid with respect to
     *             CharacterNotificationsResponse
     */
    public static CharacterNotificationsResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CharacterNotificationsResponse.class);
    }

    /**
     * Convert an instance of CharacterNotificationsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
