package com.foxowlet.patterns.gof.composite.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGroup implements MenuItem {
    private final String name;
    private final List<MenuItem> items;
    private final Scanner scanner;

    public MenuGroup(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public MenuGroup addItem(MenuItem item) {
        items.add(item);
        return this;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void execute() {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, items.get(i).name());
        }
        int choice = scanner.nextInt();
        items.get(choice - 1).execute();
    }
}
