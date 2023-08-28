package com.foxowlet.patterns.gof.proxy;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class ComputationEngineImpl implements ComputationEngine {
    private final Random random = new Random();

    @Override
    public ComputationResult compute(int input) {
        System.out.print("Doing some computations... ");
        if (random.nextInt(10) == 0) {
            throw new IllegalStateException("Something went wrong");
        }
        return new ComputationResult("some-tag", input * 42, getAdditionalInfo());
    }

    private Map<String, Object> getAdditionalInfo() {
        return Map.of(
                "time", LocalDateTime.now(),
                "engine", this.getClass().getName(),
                "version", "2.1.3");
    }
}
