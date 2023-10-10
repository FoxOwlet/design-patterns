package com.foxowlet.patterns.demo.format;

import com.foxowlet.patterns.gof.composite.format.TextSequence;
import com.foxowlet.patterns.gof.decorator.format.html.BoldText;
import com.foxowlet.patterns.gof.decorator.format.html.CodeBlock;
import com.foxowlet.patterns.gof.decorator.format.html.ItalicText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    private static final OpenOption[] openOptions = {
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
    };

    public static void main(String[] args) throws IOException {
        Text html = new TextSequence(
                new PlainText("Some "),
                new BoldText(new TextSequence(
                        new ItalicText(new PlainText("bold")),
                        new PlainText(" and ")
                )),
                new ItalicText(new PlainText("italic")),
                new PlainText(" text. And "),
                new CodeBlock(new BoldText(new PlainText("new Code()")))
        );
//        String htmlFormatted = new StringBuilder()
//                .append(new PlainText("Some ").asString())
//                .append(new BoldText(new ItalicText(new PlainText("bold"))).asString())
//                .append(new BoldText(new PlainText(" and ")).asString())
//                .append(new ItalicText(new PlainText("italic")).asString())
//                .append(new PlainText(" text. And ").asString())
//                .append(new CodeBlock(new BoldText(new PlainText("new Code()"))).asString())
//                .toString();
        String htmlFormatted = html.asString();

        writeResourceFile(htmlFormatted);
    }

    private static void writeResourceFile(String htmlFormatted) throws IOException {
        Path filePath = makeResourceFilePath();
        writeFile(filePath, htmlFormatted);
    }

    private static Path makeResourceFilePath() {
        return Path.of("src", "main", "resources", "demo", "format", "text.html");
    }

    private static void writeFile(Path filePath, String htmlFormatted) throws IOException {
        Files.createDirectories(filePath.getParent());
        Files.writeString(filePath, htmlFormatted, openOptions);
    }
}
