package com.springinaction.springidol.critics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Main implementation of {@link CriticismEngine}.
 */
@Component
public class CriticismEngineImpl implements CriticismEngine {
    private static final Logger LOG = LoggerFactory.getLogger(CriticismEngineImpl.class);

    private String[] criticisms;

    @Value("#{criticismPool}")
    public void setCriticisms(String[] criticisms) {
        this.criticisms = criticisms;
    }

    @Override
    public String getCriticism() {
        final int i = (int) (Math.random() * criticisms.length);
        String criticism = criticisms[i];

        LOG.info("Criticism established: {}", criticism);

        return criticism;
    }
}
