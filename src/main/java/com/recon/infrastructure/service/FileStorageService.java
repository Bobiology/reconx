package com.recon.infrastructure.service;

import com.recon.infrastructure.entity.UploadedFileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    UploadedFileEntity store(MultipartFile file);
}
