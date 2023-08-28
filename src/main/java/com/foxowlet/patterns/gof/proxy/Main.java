package com.foxowlet.patterns.gof.proxy;


import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ComputationEngineImpl engine = new LazyInfoComputationEngine();
        Worker worker = new Worker(new CachedComputationEngine(engine), new LazyComplexNotifier());
        Map<String, Object> additionalInfo = null;
        for (int i = 0; i < 20; i++) {
            additionalInfo = worker.doWork();
        }
        if (additionalInfo != null) {
            System.out.println(additionalInfo);
        }
    }
}
