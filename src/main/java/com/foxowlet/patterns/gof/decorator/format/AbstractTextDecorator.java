package com.foxowlet.patterns.gof.decorator.format;

import com.foxowlet.patterns.demo.format.Text;

public abstract class AbstractTextDecorator implements Text {
    private final Text text;

    protected AbstractTextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String rawContent() {
        return text.rawContent();
    }

    @Override
    public String asString() {
        return text.asString();
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
        return text.chatAt(idx);
    }
}
