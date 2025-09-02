package org.example.dataprocessor.enums;

import org.example.dataprocessor.strategy.analysis.*;

import java.util.List;

public enum AnalysisType {
    /** Arithmetic average; empty -> NaN */
    MEAN(data -> data.stream()
            .mapToDouble(i -> i)
            .average()
            .orElse(Double.NaN)),

    /** Median; even -> average of two middles; empty -> NaN */
    MEDIAN(new MedianAnalysis()),

    /** Population standard deviation (divide by N); empty -> NaN */
    STD_DEV(new StdDevAnalysis()),

    /** 90th percentile by nearest-rank: rank = ceil(0.90 * N) on sorted asc (1-based); empty -> NaN */
    P90_NEAREST_RANK(new P90Analysis()),

    /** Sum of top-3 frequency counts (order by count desc, tiebreak by value asc); empty -> 0.0 */
    TOP3_FREQUENT_COUNT_SUM(new Top3FrequentCountSumAnalysis());

    private final AnalysisStrategy strategy ;

    AnalysisType(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }
    public double analyze(List<Integer> data) {
        return strategy.analyze(data);
    }
}
