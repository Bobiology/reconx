package com.recon.infrastructure.repository;

import com.recon.infrastructure.entity.UploadedFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<UploadedFileEntity, UUID> {}
