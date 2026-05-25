package com.reconx.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "files")
@Getter @Setter
public class UploadedFileEntity {

    @Id
    private UUID id;

    private String fileName;
    private String path;
    private long size;

    private LocalDateTime uploadedAt;
}
