package com.sergiovanovi.auth.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthService<T> {

    Page<T> getAll(Pageable pageable);

    T getOne(Long id);

    void deleteOne(Long id);

    T save(T dto);

    T update(Long id, T dto);
}
