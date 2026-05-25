package com.reconx.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReconciliationJob {
    public UUID id;
    public UUID leftDatasetId;
    public UUID rightDatasetId;
    public String status;
    public int matched;
    public int unmatched;
    public LocalDateTime createdAt;
}
