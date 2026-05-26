package com.reconx.application.analytics.service;

import com.reconx.application.analytics.dto.*;

import java.util.List;

public interface DashboardAnalyticsService {
    DashboardSummaryResponse getSummary();
    List<JobTrendResponse> getJobTrends();
}
