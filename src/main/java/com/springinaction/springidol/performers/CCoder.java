package com.springinaction.springidol.performers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-coder implementation of {@link Coder} interface.
 */
public class CCoder implements Coder {
    private static final Logger LOG = LoggerFactory.getLogger(CCoder.class);

    @Override
    public String code() {
        LOG.info("Coding quite good in C with long breaks");
        return "*args";
    }
}
