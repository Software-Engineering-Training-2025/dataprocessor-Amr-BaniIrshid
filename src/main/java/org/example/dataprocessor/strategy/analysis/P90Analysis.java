package org.example.dataprocessor.strategy.analysis;

import org.example.selection.SelectionService;
import java.util.List;

public class P90Analysis implements AnalysisStrategy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return Double.NaN;

        int rank = (int) Math.ceil(0.9 * data.size());
        return SelectionService.select(data, rank);
    }
}