package com.sergiovanovi.auth.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthSessionDTO implements Serializable {

    private Long id;

    private String token;

    private String refreshToken;

    private LocalDate expiredDate;

    private Long loginId;
}
