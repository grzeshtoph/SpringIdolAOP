package com.springinaction.springidol.performers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java coder implementation for the {@link Coder} interface.
 */
public class JavaCoder implements Coder {
    private static final Logger LOG = LoggerFactory.getLogger(JavaCoder.class);

    @Override
    public String code() {
        LOG.info("Coding in Java perfectly for over 10 yrs.");
        return "string ping";
    }
}
