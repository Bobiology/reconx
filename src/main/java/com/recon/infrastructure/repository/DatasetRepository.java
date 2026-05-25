package com.recon.infrastructure.repository;


import com.recon.infrastructure.entity.DatasetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatasetRepository extends JpaRepository<DatasetEntity, UUID> {}
