package com.recon.infrastructure.service.impl;

import com.recon.infrastructure.entity.DatasetEntity;
import com.recon.infrastructure.repository.DatasetRepository;
import com.recon.infrastructure.service.DatasetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DatasetServiceImpl implements DatasetService {

    private final DatasetRepository repo;

    @Override
    public DatasetEntity create(DatasetEntity dataset) {
        dataset.setId(UUID.randomUUID());
        dataset.setCreatedAt(LocalDateTime.now());
        return repo.save(dataset);
    }
}
