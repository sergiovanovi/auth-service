package com.sergiovanovi.auth.service;

import com.sergiovanovi.auth.common.service.AuthSessionService;
import com.sergiovanovi.auth.dto.AuthSessionDTO;
import com.sergiovanovi.auth.entity.AuthSessionEntity;
import com.sergiovanovi.auth.repository.AuthSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthSessionServiceImpl implements AuthSessionService {

    @Autowired
    private AuthSessionRepository authSessionRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<AuthSessionDTO> getAll(Pageable pageable) {
        return authSessionRepository.findAll(pageable)
                .map(e -> mapper.map(e, AuthSessionDTO.class));
    }

    @Override
    public AuthSessionDTO getOne(Long id) {
        return mapper.map(authSessionRepository.findById(id).orElse(new AuthSessionEntity()), AuthSessionDTO.class);
    }

    @Override
    public void deleteOne(Long id) {
        authSessionRepository.deleteById(id);
    }

    @Override
    public AuthSessionDTO save(AuthSessionDTO authSessionDTO) {
        AuthSessionEntity authSessionEntity = mapper.map(authSessionDTO, AuthSessionEntity.class);
        return mapper.map(authSessionRepository.save(authSessionEntity), AuthSessionDTO.class);
    }

    @Override
    public AuthSessionDTO update(Long id, AuthSessionDTO authSessionDTO) {
        AuthSessionEntity authSessionEntity = authSessionRepository.findById(id).orElse(null);
        if (authSessionEntity != null) {
            authSessionEntity.setLoginId(authSessionDTO.getLoginId());
            authSessionEntity.setToken(authSessionDTO.getToken());
            authSessionEntity.setRefreshToken(authSessionDTO.getRefreshToken());
            authSessionEntity.setExpiredDate(authSessionDTO.getExpiredDate());
            return mapper.map(authSessionRepository.save(authSessionEntity), AuthSessionDTO.class);
        }
        return null;
    }
}
