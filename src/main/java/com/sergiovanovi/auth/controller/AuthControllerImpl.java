package com.sergiovanovi.auth.controller;

import com.sergiovanovi.auth.dto.AuthLoginDTO;
import com.sergiovanovi.auth.dto.AuthUserDTO;
import com.sergiovanovi.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthControllerImpl {

    @Autowired
    private AuthUserService authUserService;

    @GetMapping("/create")
    public ResponseEntity<AuthUserDTO> create() {

        AuthLoginDTO loginDTO = new AuthLoginDTO();
        loginDTO.setLogin("login");
        loginDTO.setPassword("password");

        AuthUserDTO userDTO = new AuthUserDTO();
        userDTO.setAuthLogin(loginDTO);
        userDTO.setNickName("nickname");
        userDTO.setEmail("email");
        userDTO.setPhone("phone");

        return ResponseEntity.ok(authUserService.save(userDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthUserDTO>> getAll() {
        return ResponseEntity.ok(authUserService.getAll());
    }

    @GetMapping("/delete")
    public ResponseEntity deleteAll() {
        authUserService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
