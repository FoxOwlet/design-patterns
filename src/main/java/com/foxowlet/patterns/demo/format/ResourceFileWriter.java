package com.foxowlet.patterns.demo.format;

import com.foxowlet.patterns.gof.builder.format.TextBuilder;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ResourceFileWriter {
    private static final String DEFAULT_FILENAME = "text.html";
    private static final OpenOption[] openOptions = {
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
    };
    private final String filename;

    public ResourceFileWriter() {
        this(DEFAULT_FILENAME);
    }

    public ResourceFileWriter(String filename) {
        this.filename = filename;
    }

    @SneakyThrows
    public void write(String content) {
        writeResourceFile(content);
    }

    private void writeResourceFile(String content) throws IOException {
        Path filePath = makeResourceFilePath();
        writeFile(filePath, content);
    }

    private Path makeResourceFilePath() {
        return Path.of("src", "main", "resources", "demo", "format", filename);
    }

    private static void writeFile(Path filePath, String content) throws IOException {
        Files.createDirectories(filePath.getParent());
        Files.writeString(filePath, content, openOptions);
    }
}
