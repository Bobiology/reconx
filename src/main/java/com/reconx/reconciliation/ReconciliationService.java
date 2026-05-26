package com.reconx.reconciliation;

import com.reconx.infrastructure.persistence.entity.ReconciliationJobEntity;

import java.util.UUID;

public interface ReconciliationService {
    ReconciliationJobEntity createJob(UUID left, UUID right);
}
