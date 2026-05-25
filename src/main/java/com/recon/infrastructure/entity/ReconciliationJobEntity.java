package com.recon.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "recon_jobs")
@Getter @Setter
public class ReconciliationJobEntity {

    @Id
    private UUID id;

    private UUID leftDatasetId;
    private UUID rightDatasetId;

    private String status;
    private int matched;
    private int unmatched;

    private LocalDateTime createdAt;
}
