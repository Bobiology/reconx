package com.reconx.application.analytics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardSummaryResponse {

    private long totalJobs;

    private long completedJobs;

    private long failedJobs;

    private long totalMatchedRecords;

    private long totalUnmatchedRecords;

    private double successRate;

}
