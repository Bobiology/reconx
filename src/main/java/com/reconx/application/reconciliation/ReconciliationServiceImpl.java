package com.reconx.application.reconciliation;

import com.reconx.infrastructure.persistence.entity.ReconciliationJobEntity;
import com.reconx.infrastructure.persistence.repository.ReconciliationJobRepository;
import com.reconx.application.reconciliation.ReconciliationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReconciliationServiceImpl implements ReconciliationService {

    private final ReconciliationJobRepository repo;

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
