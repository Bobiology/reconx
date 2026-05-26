package com.reconx.upload.repository;

import com.reconx.upload.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileRepository
        extends JpaRepository<UploadedFile, Long> {
}