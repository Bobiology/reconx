package com.recon.domain.model;

import java.util.UUID;

public class ReconciliationRecord {
    private UUID id;
    private UUID jobId;

    private String leftRecord;
    private String rightRecord;

    private String status; // MATCHED, UNMATCHED
}
