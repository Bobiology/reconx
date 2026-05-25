package com.recon.infrastructure.service.impl;

import com.recon.infrastructure.entity.ReconciliationJobEntity;
import com.recon.infrastructure.repository.JobRepository;
import com.recon.infrastructure.service.ReconciliationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReconciliationServiceImpl implements ReconciliationService {

    private final JobRepository repo;

    @Override
    public ReconciliationJobEntity createJob(UUID left, UUID right) {

        ReconciliationJobEntity job = new ReconciliationJobEntity();
        job.setId(UUID.randomUUID());
        job.setLeftDatasetId(left);
        job.setRightDatasetId(right);
        job.setStatus("PENDING");
        job.setCreatedAt(LocalDateTime.now());

        return repo.save(job);
    }
}
