package com.sergiovanovi.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserEntity {

    @Id
    private Long id;

    @Column(name = "NICKNAME")
    private String nickName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId
    @JoinColumn(name = "id")
    private AuthLoginEntity authLogin;
}
