package com.sergiovanovi.auth.config;

import com.sergiovanovi.auth.dto.AuthLoginDTO;
import com.sergiovanovi.auth.dto.AuthSessionDTO;
import com.sergiovanovi.auth.entity.AuthLoginEntity;
import com.sergiovanovi.auth.entity.AuthSessionEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class MapperConfig {

    private ModelMapper inner = new ModelMapper();

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(AuthLoginDTO.class, AuthLoginEntity.class)
                .addMappings(m -> m.skip(AuthLoginEntity::setAuthSessions))
                .setPropertyConverter(loginDtoToEntityConverter());
        modelMapper.createTypeMap(AuthLoginEntity.class, AuthLoginDTO.class)
                .addMappings(m -> m.skip(AuthLoginDTO::setAuthSessions))
                .setPropertyConverter(loginEntityToDtoConverter());

        return modelMapper;
    }

    public Converter<AuthLoginDTO, AuthLoginEntity> loginDtoToEntityConverter() {
        return context -> {
            List<AuthSessionDTO> authSessions = context.getSource().getAuthSessions();
            if (authSessions != null) {
                context.getDestination().setAuthSessions(authSessions.parallelStream()
                        .map(e -> inner.map(e, AuthSessionEntity.class))
                        .collect(Collectors.toList()));
            }
            return context.getDestination();
        };
    }

    public Converter<AuthLoginEntity, AuthLoginDTO> loginEntityToDtoConverter() {
        return context -> {
            List<AuthSessionEntity> authSessions = context.getSource().getAuthSessions();
            if (authSessions != null) {
                context.getDestination().setAuthSessions(authSessions.parallelStream()
                        .map(e -> inner.map(e, AuthSessionDTO.class))
                        .collect(Collectors.toList()));
            }
            return context.getDestination();
        };
    }
}
