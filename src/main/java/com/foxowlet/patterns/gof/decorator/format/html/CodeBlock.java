package com.foxowlet.patterns.gof.decorator.format.html;

import com.foxowlet.patterns.gof.decorator.format.AbstractTextDecorator;
import com.foxowlet.patterns.demo.format.Text;

public class CodeBlock extends AbstractTextDecorator {
    public CodeBlock(Text text) {
        super(text);
    }

    @Override
    public String asString() {
        return "<code>" + super.asString() + "</code>";
    }
}
