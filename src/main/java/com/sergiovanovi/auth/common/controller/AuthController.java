package com.sergiovanovi.auth.common.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AuthController<T> {

    ResponseEntity<Page<T>> getAll(Pageable pageable);

    ResponseEntity<T> getOne(Long id);

    ResponseEntity deleteOne(Long id);

    ResponseEntity<T> save(T dto);

    ResponseEntity<T> update(Long id, T dto);

}
