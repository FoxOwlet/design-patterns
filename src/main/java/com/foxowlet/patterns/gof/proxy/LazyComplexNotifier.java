package com.foxowlet.patterns.gof.proxy;

public class LazyComplexNotifier implements Notifier {
    private ComplexNotifier notifier = null;

    @Override
    public void notify(Object message) {
        ensureInitialized();
        notifier.notify(message);
    }

    private void ensureInitialized() {
        if (notifier == null) {
            notifier = new ComplexNotifier();
        }
    }
}
