/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.troja.eve.esi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.io.Serializable;

/**
 * blocked object
 */
@ApiModel(description = "blocked object")
public class ChatChannelsBlocked implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("accessor_id")
    private Integer accessorId = null;

    /**
     * accessor_type string
     */
    public enum AccessorTypeEnum {
        CHARACTER("character"),

        CORPORATION("corporation"),

        ALLIANCE("alliance");

        private String value;

        AccessorTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static AccessorTypeEnum fromValue(String text) {
            for (AccessorTypeEnum b : AccessorTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("accessor_type")
    private AccessorTypeEnum accessorType = null;

    @JsonProperty("end_at")
    private OffsetDateTime endAt = null;

    @JsonProperty("reason")
    private String reason = null;

    public ChatChannelsBlocked accessorId(Integer accessorId) {
        this.accessorId = accessorId;
        return this;
    }

    /**
     * ID of a blocked channel member
     * 
     * @return accessorId
     **/
    @ApiModelProperty(example = "null", required = true, value = "ID of a blocked channel member")
    public Integer getAccessorId() {
        return accessorId;
    }

    public void setAccessorId(Integer accessorId) {
        this.accessorId = accessorId;
    }

    public ChatChannelsBlocked accessorType(AccessorTypeEnum accessorType) {
        this.accessorType = accessorType;
        return this;
    }

    /**
     * accessor_type string
     * 
     * @return accessorType
     **/
    @ApiModelProperty(example = "null", required = true, value = "accessor_type string")
    public AccessorTypeEnum getAccessorType() {
        return accessorType;
    }

    public void setAccessorType(AccessorTypeEnum accessorType) {
        this.accessorType = accessorType;
    }

    public ChatChannelsBlocked endAt(OffsetDateTime endAt) {
        this.endAt = endAt;
        return this;
    }

    /**
     * Time at which this accessor will no longer be blocked
     * 
     * @return endAt
     **/
    @ApiModelProperty(example = "null", value = "Time at which this accessor will no longer be blocked")
    public OffsetDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(OffsetDateTime endAt) {
        this.endAt = endAt;
    }

    public ChatChannelsBlocked reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Reason this accessor is blocked
     * 
     * @return reason
     **/
    @ApiModelProperty(example = "null", value = "Reason this accessor is blocked")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChatChannelsBlocked chatChannelsBlocked = (ChatChannelsBlocked) o;
        return Objects.equals(this.accessorId, chatChannelsBlocked.accessorId)
                && Objects.equals(this.accessorType, chatChannelsBlocked.accessorType)
                && Objects.equals(this.endAt, chatChannelsBlocked.endAt)
                && Objects.equals(this.reason, chatChannelsBlocked.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessorId, accessorType, endAt, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChatChannelsBlocked {\n");

        sb.append("    accessorId: ").append(toIndentedString(accessorId)).append("\n");
        sb.append("    accessorType: ").append(toIndentedString(accessorType)).append("\n");
        sb.append("    endAt: ").append(toIndentedString(endAt)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}