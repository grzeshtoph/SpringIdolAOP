package com.springinaction.springidol;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

import java.util.regex.Pattern;

/**
 * Static utilities for unit tests.
 */
public final class TestUtils {
    private static final String SONG_PATTERN = "song=[a-zA-Z! ]+\\,";
    private static final String REPLACEMENT = "song=<SONG>,";
    private static final Pattern PATTERN = Pattern.compile(SONG_PATTERN);

    private TestUtils() {
    }

    /**
     * Replaces a random song with fixed value.
     *
     * @param toStringValue random toString output with song name to be replaced
     * @return toString output with fixed song name
     */
    public static final String replaceSong(String toStringValue) {
        return PATTERN.matcher(toStringValue).replaceAll(REPLACEMENT);
    }

    /**
     * Gets the target object that is hidden behind the Spring AOP proxy.
     *
     * @param proxy       Spring AOP proxy object
     * @param targetClass the class to cast the target object to
     * @param <T>         type of the object to return
     * @return the object behind the proxy
     * @throws Exception Might be thrown when getting target object
     */
    public static <T> T getTargetObjectBehindSpringProxy(Object proxy, Class<T> targetClass) throws Exception {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return (T) ((Advised) proxy).getTargetSource().getTarget();
        } else {
            return (T) proxy;
        }
    }
}
