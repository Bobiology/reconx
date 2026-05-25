package com.reconx.infrastructure.persistence.repository;


import com.reconx.infrastructure.persistence.entity.DatasetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatasetRepository extends JpaRepository<DatasetEntity, UUID> {}
