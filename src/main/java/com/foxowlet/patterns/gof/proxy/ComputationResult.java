package com.foxowlet.patterns.gof.proxy;

import java.util.Map;

public record ComputationResult(String tag, int value, Map<String, Object> additionalInfo) {
}
