package com.foxowlet.patterns.gof.composite.menu;

public class DoOtherMenuItem implements MenuItem {
    @Override
    public String name() {
        return "Do other";
    }

    @Override
    public void execute() {
        System.out.println("do other");
    }
}
