package com.reconx.infrastructure.storage;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.*;
import java.util.UUID;

@Component
public class LocalStorageService {

    public String store(MultipartFile file) {
        try {
            String baseDir = "/Users/mac/Documents/iLIFE/PERSONAL/SH/ReconX/uploads/";
            Files.createDirectories(Paths.get(baseDir));

            String id = UUID.randomUUID().toString();
            String path = baseDir + id + "_" + file.getOriginalFilename();

            file.transferTo(new File(path));

            return path;
        } catch (Exception e) {
            throw new RuntimeException("File storage failed", e);
        }
    }
}
