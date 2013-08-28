package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.springframework.stereotype.Component;

/**
 * Magician implementation of {@link MindReader}.
 */
@Component
public class Magician implements MindReader {
    private String thoughts;

    @Override
    public void intercept(String thoughts) throws PerformanceException {
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
