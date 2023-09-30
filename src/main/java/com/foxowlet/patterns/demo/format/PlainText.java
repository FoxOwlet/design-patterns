package com.foxowlet.patterns.demo.format;

public class PlainText implements Text {
    private final String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String asString() {
        return text;
    }

    @Override
    public String substring(int from) {
        return text.substring(from);
    }

    @Override
    public String substring(int from, int to) {
        return text.substring(from, to);
    }

    @Override
    public char chatAt(int idx) {
        return text.charAt(idx);
    }
}
