package com.reconx.upload.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "uploaded_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String storedFileName;

    private String fileType;

    private Long fileSize;

    private String uploadStatus;

    private LocalDateTime uploadedAt;

    private String uploadedBy;
}
