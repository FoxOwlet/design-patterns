package com.foxowlet.patterns.gof.builder.format;

import com.foxowlet.patterns.demo.format.PlainText;
import com.foxowlet.patterns.demo.format.Text;
import com.foxowlet.patterns.gof.composite.format.TextSequence;
import com.foxowlet.patterns.gof.decorator.format.html.BoldText;
import com.foxowlet.patterns.gof.decorator.format.html.CodeBlock;
import com.foxowlet.patterns.gof.decorator.format.html.ItalicText;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class TextBuilder {
    private final List<Text> elements;
    private final TextBuilder outer;

    public TextBuilder() {
        this(new ArrayList<>(), null);
    }

    private TextBuilder(TextBuilder outer) {
        this(new ArrayList<>(), outer);
    }

    private TextBuilder(List<Text> elements, TextBuilder outer) {
        this.elements = elements;
        this.outer = outer;
    }

    public TextBuilder text(String text) {
        elements.add(new PlainText(text));
        return this;
    }

    public TextBuilder text(Text text) {
        elements.add(text);
        return this;
    }

    public TextBuilder bold() {
        return applyFormatting(BoldText::new);
    }

    public TextBuilder italic() {
        return applyFormatting(ItalicText::new);
    }

    public TextBuilder code() {
        return applyFormatting(CodeBlock::new);
    }

    public TextBuilder sequence() {
        return new TextBuilder(this);
    }

    public TextBuilder end() {
        if (outer == null) {
            throw new IllegalStateException("Sequence was not started");
        }
        Text innerText = build();
        outer.text(innerText);
        return outer;
    }

    public Text build() {
        return new TextSequence(elements);
    }

    private TextBuilder applyFormatting(UnaryOperator<Text> formatting) {
        int index = elements.size() - 1;
        elements.set(index, formatting.apply(elements.get(index)));
        return this;
    }
}
