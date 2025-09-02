package org.example.dataprocessor.strategy.analysis;

import org.example.selection.SelectionService;
import java.util.List;


public class MedianAnalysis implements AnalysisStrategy {
    @Override
    public double analyze(List<Integer> data) {
        if (data == null || data.isEmpty())
            return Double.NaN;

        int n = data.size();
        int mid = n / 2;

        if ((n & 1) == 1)  return SelectionService.select(data, mid + 1);

        int lower = SelectionService.select(data, mid);
        int upper = SelectionService.select(data, mid + 1);
        return (lower + upper) / 2.0;
    }
}
