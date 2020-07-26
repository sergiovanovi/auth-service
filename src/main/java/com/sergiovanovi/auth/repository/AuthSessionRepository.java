package com.sergiovanovi.auth.repository;

import com.sergiovanovi.auth.entity.AuthSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSessionEntity, Long> {
}
