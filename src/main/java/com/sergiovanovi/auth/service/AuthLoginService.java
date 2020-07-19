package com.sergiovanovi.auth.service;

import com.sergiovanovi.auth.repository.AuthLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthLoginService {

    @Autowired
    private AuthLoginRepository authLoginRepository;
}
