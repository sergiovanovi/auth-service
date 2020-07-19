package com.sergiovanovi.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_LOGIN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTH_LOGIN")
    @SequenceGenerator(name = "SEQ_AUTH_LOGIN", sequenceName = "SEQ_AUTH_LOGIN")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;
}
