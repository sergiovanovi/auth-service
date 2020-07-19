package com.sergiovanovi.auth.repository;

import com.sergiovanovi.auth.entity.AuthLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthLoginRepository extends JpaRepository<AuthLoginEntity, Long> {
}
