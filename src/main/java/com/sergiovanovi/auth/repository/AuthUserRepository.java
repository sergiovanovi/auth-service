package com.sergiovanovi.auth.repository;

import com.sergiovanovi.auth.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Long> {
}
