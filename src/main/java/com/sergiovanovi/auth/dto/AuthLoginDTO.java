package com.sergiovanovi.auth.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthLoginDTO implements Serializable {

    private Long id;

    private String login;

    private String password;

    private Boolean enabled;

    private List<AuthSessionDTO> authSessions;
}
