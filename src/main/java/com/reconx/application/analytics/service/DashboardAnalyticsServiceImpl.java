package com.reconx.application.analytics.service;

import com.reconx.application.analytics.dto.*;
import com.reconx.infrastructure.persistence.repository
        .ReconciliationJobRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardAnalyticsServiceImpl
        implements DashboardAnalyticsService {

    private final ReconciliationJobRepository
            repository;

    @Override
    public DashboardSummaryResponse getSummary() {

        DashboardSummaryResponse response =
                new DashboardSummaryResponse();

        long total =
                repository.count();

        response.setTotalJobs(total);

        response.setCompletedJobs(
                repository.countByStatus(
                        "COMPLETED"
                )
        );

        response.setFailedJobs(
                repository.countByStatus(
                        "FAILED"
                )
        );

        response.setTotalMatchedRecords(
                repository.sumMatchedRecords()
        );

        response.setTotalUnmatchedRecords(
                repository.sumUnmatchedRecords()
        );

        double successRate = total == 0
                ? 0
                : (
                (double)
                        response.getCompletedJobs()
                        / total
        ) * 100;

        response.setSuccessRate(successRate);

        return response;
    }

    @Override
    public List<JobTrendResponse>
    getJobTrends() {

        List<JobTrendResponse> trends =
                new ArrayList<>();

        for (int i = 6; i >= 0; i--) {

            JobTrendResponse trend =
                    new JobTrendResponse();

            trend.setDate(
                    LocalDate.now().minusDays(i)
            );

            trend.setJobs(
                    repository.countJobsByDate(
                            trend.getDate()
                    )
            );

            trends.add(trend);
        }

        return trends;
    }
}
