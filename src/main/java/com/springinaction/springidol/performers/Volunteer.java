package com.springinaction.springidol.performers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Volunteer for mind reading. Implements {@link Thinker}.
 */
@Component
public class Volunteer implements Thinker {
    private static final Logger LOG = LoggerFactory.getLogger(Volunteer.class);
    private String thoughts;

    @Override
    public void thinkOf(String thoughts) {
        this.thoughts = thoughts;

        LOG.info("Voluntarily thinking of {}", thoughts);
    }
}
