package com.reconx.api;

import com.reconx.infrastructure.persistence.entity.ReconciliationJobEntity;
import com.reconx.application.reconciliation.ReconciliationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/recon")
@RequiredArgsConstructor
public class ReconciliationController {

    private final ReconciliationService service;

    @PostMapping("/jobs")
    public ReconciliationJobEntity createJob(
            @RequestParam UUID left,
            @RequestParam UUID right) {

        return service.createJob(left, right);
    }
}
