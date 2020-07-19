package com.sergiovanovi.auth.service;

import com.sergiovanovi.auth.dto.AuthUserDTO;
import com.sergiovanovi.auth.entity.AuthUserEntity;
import com.sergiovanovi.auth.repository.AuthUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthUserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AuthUserRepository authUserRepository;

    public AuthUserDTO save(AuthUserDTO authUserDTO) {
        AuthUserEntity authUserEntity = mapper.map(authUserDTO, AuthUserEntity.class);
        AuthUserDTO result = mapper.map(authUserRepository.save(authUserEntity), AuthUserDTO.class);
        return result;
    }

    public List<AuthUserDTO> getAll() {
        return authUserRepository
                .findAll()
                .parallelStream()
                .map(e -> mapper.map(e, AuthUserDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        authUserRepository.deleteAll();
    }
}
