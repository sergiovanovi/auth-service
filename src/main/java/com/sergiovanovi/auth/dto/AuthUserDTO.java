package com.sergiovanovi.auth.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthUserDTO implements Serializable {

    private Long id;

    private AuthLoginDTO authLogin;

    private String nickName;

    private String email;

    private String phone;
}
