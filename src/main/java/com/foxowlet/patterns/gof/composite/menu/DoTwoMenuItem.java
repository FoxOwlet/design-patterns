package com.foxowlet.patterns.gof.composite.menu;

public class DoTwoMenuItem implements MenuItem {
    @Override
    public String name() {
        return "Do two";
    }

    @Override
    public void execute() {
        System.out.println("do two");
    }
}
