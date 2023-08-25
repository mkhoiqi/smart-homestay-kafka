package com.rzq.model.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVirtualAccountRequestMessage {
    private Long amount;
    private String transactionId;
}
