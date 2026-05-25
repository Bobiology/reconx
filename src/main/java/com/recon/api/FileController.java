package com.recon.api;

import com.recon.infrastructure.entity.UploadedFileEntity;
import com.recon.infrastructure.service.FileStorageService;
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

    private final FileStorageService service;

    @PostMapping("/upload")
    public UploadedFileEntity upload(@RequestParam MultipartFile file) {
        return service.store(file);
    }
}
