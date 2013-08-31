package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Magician implementation of {@link MindReader}.
 */
@Component
public class Magician implements MindReader {
    private static final Logger LOG = LoggerFactory.getLogger(Magician.class);
    private String thoughts;

    @Override
    public void intercept(String thoughts) throws PerformanceException {
        this.thoughts = thoughts;

        LOG.info("I am sneaky magician! I can see the thoughts: {}", this.getThoughts());
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
