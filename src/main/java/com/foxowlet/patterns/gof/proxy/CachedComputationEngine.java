package com.foxowlet.patterns.gof.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachedComputationEngine implements ComputationEngine {
    private final Map<Integer, ComputationResult> cache;
    private final ComputationEngine engine;

    public CachedComputationEngine(ComputationEngine engine) {
        this.engine = engine;
        cache = new HashMap<>();
    }

    @Override
    public ComputationResult compute(int input) {
        return cache.computeIfAbsent(input, engine::compute);
    }
}
