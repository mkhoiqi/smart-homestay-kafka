package com.rzq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailsRequest {
    @JsonProperty("virtual_account")
    private String virtualAccount;

    @JsonProperty("payor_number")
    private String payorNumber;
}
