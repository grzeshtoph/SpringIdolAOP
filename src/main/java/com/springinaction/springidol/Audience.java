package com.springinaction.springidol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exemplary AOP object.
 */
public class Audience {
    private static final Logger LOG = LoggerFactory.getLogger(Audience.class);

    public void takeSeats() {
        LOG.info("Audience is taking their seats.");
    }

    public void turnOffCellPhones() {
        LOG.info("Audience is turning off their cellphones.");
    }

    public void applaud() {
        LOG.info("CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund() {
        LOG.info("Boo! We want our money back!");
    }
}
