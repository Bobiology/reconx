package com.recon.api;

import com.recon.infrastructure.entity.DatasetEntity;
import com.recon.infrastructure.service.DatasetService;
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
