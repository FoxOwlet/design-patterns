package com.foxowlet.patterns.gof.composite.menu;


public class Main {
    public static void main(String[] args) {
        MenuItem rootMenu = new MenuGroup("root")
                .addItem(new DoSthMenuItem())
                .addItem(new DoOtherMenuItem())
                .addItem(new DoYetAnotherMenuItem())
                .addItem(new MenuGroup("Submenu")
                        .addItem(new DoOneMenuItem())
                        .addItem(new DoTwoMenuItem())
                        .addItem(new ExitMenuItem()))
                .addItem(new ExitMenuItem());

        rootMenu = new LoopMenu(rootMenu);

        rootMenu.execute();
    }
}
