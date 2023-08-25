package com.rzq.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "virtual_account")
    private String virtualAccount;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @NotNull
    private String status;

    @NotNull
    private Long amount;

    @NotNull
    @Column(name = "virtual_account_expired_at")
    private LocalDateTime virtualAccountExpiredAt;

    @Column(name = "payor_number")
    private String payorNumber;
}
