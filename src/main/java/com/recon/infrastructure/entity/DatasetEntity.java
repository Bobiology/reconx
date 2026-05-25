package com.recon.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "datasets")
@Getter @Setter
public class DatasetEntity {

    @Id
    private UUID id;

    private String name;
    private String fileType;

    @Column(columnDefinition = "TEXT")
    private String schemaJson;

    private LocalDateTime createdAt;
}
