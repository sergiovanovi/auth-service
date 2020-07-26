package com.sergiovanovi.auth.controller;

import com.sergiovanovi.auth.common.controller.AuthSessionController;
import com.sergiovanovi.auth.dto.AuthSessionDTO;
import com.sergiovanovi.auth.service.AuthSessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
public class AuthSessionControllerImpl implements AuthSessionController {

    @Autowired
    private AuthSessionServiceImpl authSessionService;

    @Override
    @GetMapping
    public ResponseEntity<Page<AuthSessionDTO>> getAll(
            @PageableDefault(page = 1, size = 10)  //TODO
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "loginId"),
                    @SortDefault(sort = "expiredDate")
            }) Pageable pageable) {
        return ResponseEntity.ok(authSessionService.getAll(pageable));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AuthSessionDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(authSessionService.getOne(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        authSessionService.deleteOne(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<AuthSessionDTO> save(@RequestBody AuthSessionDTO authSessionDTO) {
        return ResponseEntity.ok(authSessionService.save(authSessionDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AuthSessionDTO> update(@PathVariable("id") Long id, @RequestBody AuthSessionDTO authSessionDTO) {
        AuthSessionDTO sessionDTO = authSessionService.update(id, authSessionDTO);
        if (sessionDTO != null) {
            return ResponseEntity.ok(sessionDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
