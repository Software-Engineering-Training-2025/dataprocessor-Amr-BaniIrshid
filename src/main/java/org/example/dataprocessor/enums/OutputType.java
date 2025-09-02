package org.example.dataprocessor.enums;

import org.example.dataprocessor.strategy.output.OutputStrategy;
import org.example.dataprocessor.strategy.output.TextFileOutput;

public enum OutputType {
    /** Print "Result = <value>" to stdout */
    CONSOLE(value -> System.out.println("Result = " + value)),

    /** Write "Result = <value>" to target/result.txt (overwrite, create dirs) */
    TEXT_FILE(new TextFileOutput());

    private final OutputStrategy strategy;

    OutputType(OutputStrategy strategy) {
        this.strategy = strategy;
    }
    public void output(double value) {
        strategy.output(value);
    }
}
