package com.sergiovanovi.auth.common;

import com.sergiovanovi.auth.dto.AuthLoginDTO;
import com.sergiovanovi.auth.dto.AuthSessionDTO;
import com.sergiovanovi.auth.entity.AuthLoginEntity;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public class AuthModelMapper  extends ModelMapper {

    public AuthLoginDTO loginEntityToLoginDTO(AuthLoginEntity entity) {
        AuthLoginDTO result = new AuthLoginDTO();
        result.setId(entity.getId());
        result.setLogin(entity.getLogin());
        result.setPassword(entity.getPassword());
        result.setEnabled(entity.getEnabled());
        if (entity.getAuthSessions() != null) {
            result.setAuthSessions(entity.getAuthSessions().parallelStream()
                    .map(e -> map(e, AuthSessionDTO.class))
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
