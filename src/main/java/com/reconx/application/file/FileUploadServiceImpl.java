package com.reconx.application.file;

import com.reconx.infrastructure.persistence.entity.UploadedFileEntity;
import com.reconx.infrastructure.persistence.repository.UploadedFileRepository;
import com.reconx.application.file.FileUploadService;
import com.reconx.infrastructure.storage.LocalStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final LocalStorageService storage;
    private final UploadedFileRepository repo;

    @Override
    public UploadedFileEntity store(MultipartFile file) {

        String path = storage.store(file);

        UploadedFileEntity entity = new UploadedFileEntity();
        entity.setId(UUID.randomUUID());
        entity.setFileName(file.getOriginalFilename());
        entity.setPath(path);
        entity.setSize(file.getSize());
        entity.setUploadedAt(LocalDateTime.now());

        return repo.save(entity);
    }
}
