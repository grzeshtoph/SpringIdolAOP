package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * A faulty juggle. Throws exception when performing.
 */
@Component("faultyDuke")
public class FaultyJuggler extends Juggler {
    private static final Logger LOG = LoggerFactory.getLogger(FaultyJuggler.class);

    @Override
    public void perform() throws PerformanceException {
        try {
            throw new PerformanceException("something went wrong");
        } catch (PerformanceException pe) {
            LOG.error("something went wrong. sorry!");
            throw pe;
        }
    }
}
