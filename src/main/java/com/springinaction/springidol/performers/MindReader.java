package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;

/**
 * Mind reader interface.
 */
public interface MindReader {
    void intercept(String thoughts) throws PerformanceException;

    String getThoughts();
}
