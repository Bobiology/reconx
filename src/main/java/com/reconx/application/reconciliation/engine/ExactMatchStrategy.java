package com.reconx.application.reconciliation.engine;

import com.reconx.domain.reconciliation.ReconciliationRecord;

import java.util.*;

public class ExactMatchStrategy
        implements MatchingStrategy<ReconciliationRecord> {

    @Override
    public List<MatchResult<ReconciliationRecord>> match(
            List<ReconciliationRecord> left,
            List<ReconciliationRecord> right
    ) {

        Map<String, ReconciliationRecord> rightIndex = new HashMap<>();

        for (ReconciliationRecord record : right) {

            String key = buildKey(record);

            rightIndex.put(key, record);
        }

        List<MatchResult<ReconciliationRecord>> results =
                new ArrayList<>();

        for (ReconciliationRecord leftRecord : left) {

            String key = buildKey(leftRecord);

            ReconciliationRecord matched =
                    rightIndex.get(key);

            results.add(
                    new MatchResult<>(
                            leftRecord,
                            matched,
                            matched != null
                    )
            );
        }

        return results;
    }

    private String buildKey(ReconciliationRecord record) {

        return NormalizationUtils.normalize(
                record.getReference()
        ) + "_" + record.getAmount();
    }
}
