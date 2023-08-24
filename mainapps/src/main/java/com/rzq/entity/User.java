package com.rzq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @Column(length = 20)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Column(length = 50)
    private String name;

    private String token;

    @Column(name = "token_expired_at")
    private Long tokenExpiredAt;

    @NotNull
    @Column(name = "is_employees")
    private Boolean isEmployees;

    @OneToMany(mappedBy = "createdBy")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "createdBy")
    private Set<Audit> audits;

}
