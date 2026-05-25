package com.reconx.application.reconciliation.engine;

import lombok.Getter;

@Getter
public class MatchResult<T> {

    private final T left;
    private final T right;
    private final boolean matched;

    public MatchResult(T left, T right, boolean matched) {
        this.left = left;
        this.right = right;
        this.matched = matched;
    }

}
