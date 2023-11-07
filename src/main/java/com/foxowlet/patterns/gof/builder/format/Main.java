package com.foxowlet.patterns.gof.builder.format;

import com.foxowlet.patterns.demo.format.ResourceFileWriter;
import com.foxowlet.patterns.demo.format.Text;

public class Main {

    public static void main(String[] args) {
        Text html = new TextBuilder()
                .text("Some ")
                .sequence()
                .text("bold").italic()
                .text(" and ")
                .end().bold()
                .text("italic").italic()
                .text(" text. And ")
                .text("new Code()").bold().code()
                .build();

        new ResourceFileWriter().write(html.asString());
    }
}
