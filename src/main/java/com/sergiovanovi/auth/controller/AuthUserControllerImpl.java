package com.sergiovanovi.auth.controller;

import com.sergiovanovi.auth.common.controller.AuthUserController;
import com.sergiovanovi.auth.common.service.AuthUserService;
import com.sergiovanovi.auth.dto.AuthUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthUserControllerImpl implements AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @Override
    @GetMapping
    public ResponseEntity<Page<AuthUserDTO>> getAll(
            @PageableDefault(page = 1, size = 10)   //TODO
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "id")
            }) Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AuthUserDTO> getOne(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<AuthUserDTO> save(AuthUserDTO dto) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AuthUserDTO> update(@PathVariable("id") Long id, @RequestBody AuthUserDTO dto) {
        return null;
    }
}
