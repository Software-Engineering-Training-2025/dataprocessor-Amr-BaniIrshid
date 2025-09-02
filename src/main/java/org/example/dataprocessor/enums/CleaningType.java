package org.example.dataprocessor.enums;

import org.example.dataprocessor.strategy.cleaning.CleaningStrategy;

import java.util.List;

public enum CleaningType {
    /** Drop all values < 0 */
    REMOVE_NEGATIVES(data -> data.stream()
            .filter(value -> value>=0)
            .toList()),

    /** Replace all values < 0 with 0 */
    REPLACE_NEGATIVES_WITH_ZERO(data -> data.stream()
            .map(value-> value < 0 ? 0 : value)
            .toList()) ;

    private final CleaningStrategy strategy;

    CleaningType(CleaningStrategy strategy) {
        this.strategy = strategy;
    }

    public  List<Integer> clean(List<Integer> data){
        return strategy.clean(data);
    }
}