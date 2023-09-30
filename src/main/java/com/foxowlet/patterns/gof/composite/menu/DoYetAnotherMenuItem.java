package com.foxowlet.patterns.gof.composite.menu;

public class DoYetAnotherMenuItem implements MenuItem {
    @Override
    public String name() {
        return "Do yet another";
    }

    @Override
    public void execute() {
        System.out.println("do yet another");
    }
}
