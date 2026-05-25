package com.reconx.api;

import com.reconx.infrastructure.persistence.entity.UploadedFileEntity;
import com.reconx.application.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final FileUploadService service;

    @PostMapping("/upload")
    public UploadedFileEntity upload(@RequestParam MultipartFile file) {
        return service.store(file);
    }
}
