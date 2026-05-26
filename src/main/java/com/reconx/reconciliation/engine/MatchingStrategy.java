package com.reconx.reconciliation.engine;

import java.util.List;

public interface MatchingStrategy<T> {
    List<MatchResult<T>> match(List<T> left, List<T> right);
}
