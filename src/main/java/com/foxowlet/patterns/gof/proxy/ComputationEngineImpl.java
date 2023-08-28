package com.foxowlet.patterns.gof.proxy;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class ComputationEngineImpl implements ComputationEngine {
    private final Random random = new Random();

    @SneakyThrows
    @Override
    public ComputationResult compute(int input) {
        System.out.println("Doing some computations... ");
        if (random.nextInt(10) == 0) {
            throw new IllegalStateException("Something went wrong");
        }
        Thread.sleep(500);
        return new ComputationResult("some-tag", input * 42, getAdditionalInfo());
    }

    protected Map<String, Object> getAdditionalInfo() {
        System.out.println("Computing additional info...");
        return Map.of(
                "time", LocalDateTime.now(),
                "engine", this.getClass().getName(),
                "version", "2.1.3");
    }
}
