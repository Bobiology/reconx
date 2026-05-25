package com.reconx.infrastructure.persistence.repository;

import com.reconx.infrastructure.persistence.entity.ReconciliationJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReconciliationJobRepository extends JpaRepository<ReconciliationJobEntity, UUID> {}
