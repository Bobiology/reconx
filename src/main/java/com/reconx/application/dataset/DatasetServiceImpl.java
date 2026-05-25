package com.reconx.application.dataset;

import com.reconx.infrastructure.persistence.entity.DatasetEntity;
import com.reconx.infrastructure.persistence.repository.DatasetRepository;
import com.reconx.application.dataset.DatasetService;
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
