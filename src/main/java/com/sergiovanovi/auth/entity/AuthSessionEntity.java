package com.sergiovanovi.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AUTH_SESSION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTH_SESSION")
    @SequenceGenerator(name = "SEQ_AUTH_SESSION", sequenceName = "SEQ_AUTH_SESSION")
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "EXPIRED_DATE")
    private LocalDate expiredDate;

    @Column(name = "LOGIN_ID")
    private Long loginId;
}
