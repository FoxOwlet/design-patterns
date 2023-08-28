package com.foxowlet.patterns.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class LazyInfoComputationEngine extends ComputationEngineImpl {
    @Override
    protected Map<String, Object> getAdditionalInfo() {
        //noinspection unchecked
        return (Map<String, Object>) Proxy.newProxyInstance(Map.class.getClassLoader(),
                new Class[]{ Map.class },
                new LazyInvocationHandler());
    }

    private class LazyInvocationHandler implements InvocationHandler {
        private Map<String, Object> data;

        private void ensureInitialized() {
            if (data == null) {
                data = LazyInfoComputationEngine.super.getAdditionalInfo();
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            ensureInitialized();
            return method.invoke(data, args);
        }
    }
}
