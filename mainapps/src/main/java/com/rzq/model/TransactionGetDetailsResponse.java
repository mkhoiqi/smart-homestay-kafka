package com.rzq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rzq.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionGetDetailsResponse {
    private String id;
    private Long amount;

    @JsonProperty("checkin_date")
    private LocalDate checkinDate;

    @JsonProperty("checkout_date")
    private LocalDate checkoutDate;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("last_action")
    private String lastAction;

    @JsonProperty("last_activity")
    private String lastActivity;

    @JsonProperty("number_of_rooms")
    private Integer numberOfRooms;
    private String status;

    @JsonProperty("virtual_account")
    private String virtualAccount;

    @JsonProperty("virtual_account_expired_at")
    private LocalDateTime virtualAccountExpiredAt;

    @JsonProperty("created_by")
    private UserDetailsResponse createdBy;
    private RoomCreateResponse room;

    @JsonProperty("additional_facilities")
    private Set<AdditionalFacilityCreateResponse> additionalFacilities;
    private Set<AuditResponse> audits;

}
