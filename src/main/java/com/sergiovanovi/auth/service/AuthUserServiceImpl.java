package com.sergiovanovi.auth.service;

import com.sergiovanovi.auth.common.service.AuthUserService;
import com.sergiovanovi.auth.dto.AuthUserDTO;
import com.sergiovanovi.auth.repository.AuthUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<AuthUserDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public AuthUserDTO getOne(Long id) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public AuthUserDTO save(AuthUserDTO dto) {
        return null;
    }

    @Override
    public AuthUserDTO update(Long id, AuthUserDTO dto) {
        return null;
    }
}
