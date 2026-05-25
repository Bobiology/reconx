package com.recon.infrastructure.service.impl;

import com.recon.infrastructure.entity.UploadedFileEntity;
import com.recon.infrastructure.repository.FileRepository;
import com.recon.infrastructure.service.FileStorageService;
import com.recon.infrastructure.storage.LocalFileStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private final LocalFileStorage storage;
    private final FileRepository repo;

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
