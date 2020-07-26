package com.sergiovanovi.auth.service;

import com.sergiovanovi.auth.common.service.AuthLoginService;
import com.sergiovanovi.auth.dto.AuthLoginDTO;
import com.sergiovanovi.auth.entity.AuthLoginEntity;
import com.sergiovanovi.auth.entity.AuthSessionEntity;
import com.sergiovanovi.auth.repository.AuthLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthLoginServiceImpl implements AuthLoginService {

    @Autowired
    private AuthLoginRepository authLoginRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<AuthLoginDTO> getAll(Pageable pageable) {
        return authLoginRepository.findAll(pageable)
                .map(e -> mapper.map(e, AuthLoginDTO.class));
    }

    @Override
    public AuthLoginDTO getOne(Long id) {
        return mapper.map(authLoginRepository.getOne(id), AuthLoginDTO.class);
    }

    @Override
    public void deleteOne(Long id) {
        authLoginRepository.deleteById(id);
    }

    @Override
    public AuthLoginDTO save(AuthLoginDTO dto) {
        AuthLoginEntity authLoginEntity = mapper.map(dto, AuthLoginEntity.class);
        return mapper.map(authLoginRepository.save(authLoginEntity), AuthLoginDTO.class);
    }

    @Override
    public AuthLoginDTO update(Long id, AuthLoginDTO dto) {
        AuthLoginEntity result = authLoginRepository.findById(id).orElse(null);
        if (result != null) {
            result.setLogin(dto.getLogin());
            result.setPassword(dto.getPassword());
            result.setEnabled(dto.getEnabled());
            if (dto.getAuthSessions() != null) {
                result.setAuthSessions(dto.getAuthSessions().parallelStream()
                        .map(e -> mapper.map(e, AuthSessionEntity.class))
                        .collect(Collectors.toList()));
            }
            return mapper.map(authLoginRepository.save(result), AuthLoginDTO.class);
        }
        return null;
    }
}
