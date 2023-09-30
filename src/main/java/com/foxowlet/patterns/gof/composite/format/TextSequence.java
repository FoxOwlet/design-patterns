package com.foxowlet.patterns.gof.composite.format;

import com.foxowlet.patterns.demo.format.Text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextSequence implements Text {
    private final List<Text> subtexts;

    public TextSequence(Text... subtexts) {
        this(Arrays.asList(subtexts));
    }

    public TextSequence(List<Text> subtexts) {
        this.subtexts = subtexts;
    }

    @Override
    public String rawContent() {
        return subtexts.stream()
                .map(Text::rawContent)
                .collect(Collectors.joining());
    }

    @Override
    public String asString() {
        return subtexts.stream()
                .map(Text::asString)
                .collect(Collectors.joining());
    }

    @Override
    public String substring(int from) {
        return rawContent().substring(from);
    }

    @Override
    public String substring(int from, int to) {
        return rawContent().substring(from, to);
    }

    @Override
    public char chatAt(int idx) {
        return rawContent().charAt(idx);
    }
}
