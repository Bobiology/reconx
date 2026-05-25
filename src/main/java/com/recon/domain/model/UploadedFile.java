package com.recon.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class UploadedFile {
    public UUID id;
    public String fileName;
    public String path;
    public long size;
    public LocalDateTime uploadedAt;
}
