package com.reconx.api;

import com.reconx.application.analytics.service
        .DashboardAnalyticsService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final DashboardAnalyticsService
            service;

    @GetMapping("/summary")
    public Object summary() {

        return service.getSummary();
    }

    @GetMapping("/trends/jobs")
    public Object jobTrends() {

        return service.getJobTrends();
    }
}