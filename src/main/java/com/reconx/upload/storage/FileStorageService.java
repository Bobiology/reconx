package com.reconx.upload.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path root = Paths.get("uploads");

    public String store(MultipartFile file) {

        try {

            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }

            String storedName =
                    UUID.randomUUID() + "_" + file.getOriginalFilename();

            Files.copy(
                    file.getInputStream(),
                    root.resolve(storedName),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return storedName;

        } catch (IOException ex) {
            throw new RuntimeException("File storage failed", ex);
        }
    }
}
