package com.foxowlet.patterns.gof.composite.menu;

public class ExitMenuItem implements MenuItem {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
