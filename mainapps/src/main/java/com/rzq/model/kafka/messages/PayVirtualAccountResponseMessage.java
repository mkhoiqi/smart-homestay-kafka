package com.rzq.model.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayVirtualAccountResponseMessage {
    private String virtualAccount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String status;

    private Long amount;

    private LocalDateTime virtualAccountExpiredAt;

    private String payorNumber;
}
