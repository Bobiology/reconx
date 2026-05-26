package com.reconx.application.reconciliation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReconciliationExecutor {

    @Async
    public void execute(String jobId) {

        log.info(
                "Starting async reconciliation job {}",
                jobId
        );

        try {

            Thread.sleep(3000);

            log.info(
                    "Completed reconciliation job {}",
                    jobId
            );

        } catch (Exception e) {

            log.error(
                    "Job execution failed",
                    e
            );
        }
    }
}
