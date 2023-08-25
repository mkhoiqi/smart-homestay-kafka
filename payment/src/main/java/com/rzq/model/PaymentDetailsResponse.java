package com.rzq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailsResponse {
    @JsonProperty("virtual_account")
    private String virtualAccount;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("update_at")
    private LocalDateTime updatedAt;

    private String status;

    private Long amount;

    @JsonProperty("virtual_account_expired_at")
    private LocalDateTime virtualAccountExpiredAt;

    @JsonProperty("payor_number")
    private String payorNumber;

    @JsonProperty("transaction_id")
    private String transactionId;
}
