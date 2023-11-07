package com.foxowlet.patterns.gof.decorator.format;

import com.foxowlet.patterns.demo.format.PlainText;
import com.foxowlet.patterns.demo.format.ResourceFileWriter;
import com.foxowlet.patterns.gof.decorator.format.html.BoldText;
import com.foxowlet.patterns.gof.decorator.format.html.CodeBlock;
import com.foxowlet.patterns.gof.decorator.format.html.ItalicText;


public class Main {

    public static void main(String[] args) {
        String htmlFormatted = new StringBuilder()
                .append(new PlainText("Some ").asString())
                .append(new BoldText(new ItalicText(new PlainText("bold"))).asString())
                .append(new BoldText(new PlainText(" and ")).asString())
                .append(new ItalicText(new PlainText("italic")).asString())
                .append(new PlainText(" text. And ").asString())
                .append(new CodeBlock(new BoldText(new PlainText("new Code()"))).asString())
                .toString();

        new ResourceFileWriter().write(htmlFormatted);
    }
}
