package com.reconx.api;

import com.reconx.infrastructure.persistence.entity.DatasetEntity;
import com.reconx.application.dataset.DatasetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/datasets")
@RequiredArgsConstructor
public class DatasetController {

    private final DatasetService service;

    @PostMapping
    public DatasetEntity create(@RequestBody DatasetEntity dataset) {
        return service.create(dataset);
    }
}
