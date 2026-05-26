package com.reconx.upload.service;

import com.reconx.upload.entity.UploadedFile;
import com.reconx.upload.repository.UploadedFileRepository;
import com.reconx.upload.storage.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final FileStorageService storageService;
    private final UploadedFileRepository repository;
    private final FileValidationService validationService;

    public UploadedFile upload(MultipartFile file,
                               String uploadedBy) {

        validationService.validate(file);

        String storedName = storageService.store(file);

        UploadedFile uploadedFile =
                UploadedFile.builder()
                        .originalFileName(file.getOriginalFilename())
                        .storedFileName(storedName)
                        .fileType(file.getContentType())
                        .fileSize(file.getSize())
                        .uploadStatus("UPLOADED")
                        .uploadedAt(LocalDateTime.now())
                        .uploadedBy(uploadedBy)
                        .build();

        return repository.save(uploadedFile);
    }
}
