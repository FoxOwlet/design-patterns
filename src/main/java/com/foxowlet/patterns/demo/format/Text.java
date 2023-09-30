package com.foxowlet.patterns.demo.format;

public interface Text {
    String asString();

    String substring(int from);
    String substring(int from, int to);

    char chatAt(int idx);
}
