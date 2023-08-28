package com.foxowlet.patterns.gof.proxy;


public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker(new ComputationEngineImpl(), new ComplexNotifier());
        for (int i = 0; i < 5; i++) {
            worker.doWork();
        }
    }
}
