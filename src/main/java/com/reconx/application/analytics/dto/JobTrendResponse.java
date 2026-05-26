package com.reconx.application.analytics.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobTrendResponse {
    private LocalDate date;
    private long jobs;
}
