package com.springinaction.springidol.performers;

import org.springframework.stereotype.Component;

/**
 * Volunteer for mind reading. Implements {@link Thinker}.
 */
@Component
public class Volunteer implements Thinker {
    private String thoughts;

    @Override
    public void thinkOf(String thoughts) {
        this.thoughts = thoughts;
    }
}
