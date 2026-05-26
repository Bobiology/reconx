package com.reconx.domain.reconciliation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReconciliationRecord {

    private String reference;
    private BigDecimal amount;
}
