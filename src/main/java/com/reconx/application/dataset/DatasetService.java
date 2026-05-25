package com.reconx.application.dataset;

import com.reconx.infrastructure.persistence.entity.DatasetEntity;

public interface DatasetService {
    DatasetEntity create(DatasetEntity dataset);
}
