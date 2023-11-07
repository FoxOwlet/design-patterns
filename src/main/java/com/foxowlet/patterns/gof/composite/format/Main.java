package com.foxowlet.patterns.gof.composite.format;

import com.foxowlet.patterns.demo.format.PlainText;
import com.foxowlet.patterns.demo.format.ResourceFileWriter;
import com.foxowlet.patterns.demo.format.Text;
import com.foxowlet.patterns.gof.decorator.format.html.BoldText;
import com.foxowlet.patterns.gof.decorator.format.html.CodeBlock;
import com.foxowlet.patterns.gof.decorator.format.html.ItalicText;


public class Main {

    public static void main(String[] args) {
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

        new ResourceFileWriter().write(html.asString());
    }
}
