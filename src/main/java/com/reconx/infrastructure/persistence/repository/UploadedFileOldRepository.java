package com.reconx.infrastructure.persistence.repository;

import com.reconx.infrastructure.persistence.entity.UploadedFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UploadedFileOldRepository extends JpaRepository<UploadedFileEntity, UUID> {}
