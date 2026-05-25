package com.recon.infrastructure.service;

import com.recon.infrastructure.entity.ReconciliationJobEntity;

import java.util.UUID;

public interface ReconciliationService {
    ReconciliationJobEntity createJob(UUID left, UUID right);
}
