package com.reconx.reconciliation.engine;

public class NormalizationUtils {

    private NormalizationUtils() {}

    public static String normalize(String value) {

        if (value == null) {
            return null;
        }

        return value
                .trim()
                .replaceAll("\\s+", "")
                .toLowerCase();
    }
}
