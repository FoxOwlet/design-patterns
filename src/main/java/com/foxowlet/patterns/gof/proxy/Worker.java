package com.foxowlet.patterns.gof.proxy;

import java.util.Map;
import java.util.Random;

public class Worker {
    private final ComputationEngine computationEngine;
    private final Notifier notifier;

    public Worker(ComputationEngine computationEngine, Notifier notifier) {
        this.computationEngine = computationEngine;
        this.notifier = notifier;
    }

    public Map<String, Object> doWork() {
        try {
            return tryDoWork();
        } catch (Exception e) {
            notifier.notify(e.getMessage());
            return Map.of();
        }
    }

    private Map<String, Object> tryDoWork() {
        int input = getInput();
        ComputationResult result = computationEngine.compute(input);
        saveResult(result);
        return result.additionalInfo();
    }

    private int getInput() {
        return new Random().nextInt(10);
    }

    private void saveResult(ComputationResult result) {
        System.out.println("Saving result " + result.value());
    }
}
