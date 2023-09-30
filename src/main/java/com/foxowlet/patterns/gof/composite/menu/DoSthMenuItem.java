package com.foxowlet.patterns.gof.composite.menu;

public class DoSthMenuItem implements MenuItem {
    @Override
    public String name() {
        return "Do sth";
    }

    @Override
    public void execute() {
        System.out.println("do sth");
    }
}
