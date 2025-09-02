package org.example.dataprocessor.strategy.cleaning;

import java.util.List;

public interface CleaningStrategy {
    List<Integer> clean(List<Integer> data);
}
