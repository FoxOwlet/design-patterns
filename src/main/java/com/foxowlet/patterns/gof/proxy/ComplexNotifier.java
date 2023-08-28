package com.foxowlet.patterns.gof.proxy;

import lombok.SneakyThrows;

public class ComplexNotifier implements Notifier {
    @SneakyThrows
    public ComplexNotifier() {
        System.out.println("Configuring notifier...");
        Thread.sleep(3000);
    }

    public void notify(Object message) {
        System.out.println("Sending notification: " + message);
    }
}
