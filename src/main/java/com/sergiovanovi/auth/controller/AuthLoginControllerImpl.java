package com.sergiovanovi.auth.controller;

import com.sergiovanovi.auth.common.controller.AuthLoginController;
import com.sergiovanovi.auth.common.service.AuthLoginService;
import com.sergiovanovi.auth.dto.AuthLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logins")
public class AuthLoginControllerImpl implements AuthLoginController {

    @Autowired
    private AuthLoginService authLoginService;

    @Override
    @GetMapping
    public ResponseEntity<Page<AuthLoginDTO>> getAll(
            @PageableDefault(page = 1, size = 10)   //TODO
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "id")
            }) Pageable pageable) {
        return ResponseEntity.ok(authLoginService.getAll(pageable));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AuthLoginDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(authLoginService.getOne(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        authLoginService.deleteOne(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<AuthLoginDTO> save(@RequestBody AuthLoginDTO dto) {
        return ResponseEntity.ok(authLoginService.save(dto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AuthLoginDTO> update(@PathVariable("id") Long id, @RequestBody AuthLoginDTO dto) {
        AuthLoginDTO loginDTO = authLoginService.update(id, dto);
        if (loginDTO != null) {
            return ResponseEntity.ok(loginDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
