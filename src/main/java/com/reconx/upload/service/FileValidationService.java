package com.reconx.upload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileValidationService {

    private static final List<String> ALLOWED_TYPES =
            List.of(
                    "text/csv",
                    "application/vnd.ms-excel",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
            );

    public void validate(MultipartFile file) {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new RuntimeException("Unsupported file type");
        }

        if (file.getSize() > 50_000_000) {
            throw new RuntimeException("File exceeds limit");
        }
    }
}
