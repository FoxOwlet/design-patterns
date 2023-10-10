package com.foxowlet.patterns.gof.decorator.format.html;

import com.foxowlet.patterns.gof.decorator.format.AbstractTextDecorator;
import com.foxowlet.patterns.demo.format.Text;

public class BoldText extends AbstractTextDecorator {
    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String asString() {
        return "<b>" + super.asString() + "</b>";
    }
}
