package org.example.dataprocessor.strategy.analysis;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top3FrequentCountSumAnalysis implements AnalysisStrategy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return 0.0;
        return data.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(Long::longValue)
                .sum();
    }
}
