package com.foxowlet.patterns.gof.proxy;

import java.util.Random;

public class Worker {
    private final ComputationEngine computationEngine;
    private final Notifier notifier;

    public Worker(ComputationEngine computationEngine, Notifier notifier) {
        this.computationEngine = computationEngine;
        this.notifier = notifier;
    }

    public void doWork() {
        try {
            tryDoWork();
        } catch (Exception e) {
            notifier.notify(e.getMessage());
        }
    }

    private void tryDoWork() {
        int input = getInput();
        ComputationResult result = computationEngine.compute(input);
        saveResult(result);
    }

    private int getInput() {
        return new Random().nextInt(1000);
    }

    private void saveResult(ComputationResult result) {
        System.out.println("Saving result " + result.value());
    }
}
