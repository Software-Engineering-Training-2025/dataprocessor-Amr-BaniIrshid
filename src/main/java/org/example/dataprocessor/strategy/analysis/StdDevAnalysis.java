package org.example.dataprocessor.strategy.analysis;

import org.example.dataprocessor.enums.AnalysisType;

import java.util.List;

public class StdDevAnalysis implements AnalysisStrategy {
    @Override
    public double analyze(List<Integer> data) {
        double mean = AnalysisType.MEAN.analyze(data);

        if(Double.isNaN(mean)) return Double.NaN;

        double variance = data.stream()
                .mapToDouble(i -> Math.pow( i-mean , 2))
                .average()
                .orElse(Double.NaN);

        return Math.sqrt(variance);
    }
}
