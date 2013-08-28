package com.springinaction.springidol.performers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * One of the implementations of {@link Contestant}.
 */
public class GraciousContestant implements Contestant {
    private static final Logger LOG = LoggerFactory.getLogger(GraciousContestant.class);

    private String award;

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public void receiveAward() {
        LOG.info("Contestant received {}", award);
    }
}
