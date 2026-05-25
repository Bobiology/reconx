package com.reconx.application.file;

import com.reconx.infrastructure.persistence.entity.UploadedFileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    UploadedFileEntity store(MultipartFile file);
}
