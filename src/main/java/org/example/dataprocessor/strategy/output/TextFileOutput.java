package org.example.dataprocessor.strategy.output;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileOutput implements OutputStrategy {
    @Override
    public void output(double value) {
        try {
            Path path = Paths.get("target/result.txt");
            Files.createDirectories(path.getParent());
            Files.writeString(path, "Result = " + value, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
