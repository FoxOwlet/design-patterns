package com.foxowlet.patterns.gof.composite.menu;

public class LoopMenu implements MenuItem {
    private final MenuItem item;

    public LoopMenu(MenuItem item) {
        this.item = item;
    }

    @Override
    public String name() {
        return item.name();
    }

    @Override
    public void execute() {
        while (true) {
            item.execute();
        }
    }
}
