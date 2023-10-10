package com.foxowlet.patterns.gof.decorator.format.html;

import com.foxowlet.patterns.gof.decorator.format.AbstractTextDecorator;
import com.foxowlet.patterns.demo.format.Text;

public class ItalicText extends AbstractTextDecorator {
    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String asString() {
        return "<i>" + super.asString() + "</i>";
    }
}
