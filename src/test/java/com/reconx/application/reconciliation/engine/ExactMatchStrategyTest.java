package com.reconx.application.reconciliation.engine;

import com.reconx.domain.reconciliation.ReconciliationRecord;
import com.reconx.reconciliation.engine.ExactMatchStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExactMatchStrategyTest {

    @Test
    void shouldMatchRecords() {

        ReconciliationRecord left =
                new ReconciliationRecord();

        left.setReference(" ABC123 ");
        left.setAmount(new BigDecimal("100"));

        ReconciliationRecord right =
                new ReconciliationRecord();

        right.setReference("abc123");
        right.setAmount(new BigDecimal("100"));

        ExactMatchStrategy strategy =
                new ExactMatchStrategy();

        var results = strategy.match(
                List.of(left),
                List.of(right)
        );

        assertTrue(results.get(0).isMatched());
    }
}
