package com.springinaction.springidol;


import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Exemplary AOP object.
 */
@Component
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

    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("Starting to watch");
        StopWatch watch = new StopWatch("performance");

        watch.start();
        try {
            joinPoint.proceed();
        } finally {
            watch.stop();

            LOG.info("Performance finished");
            LOG.info(watch.shortSummary());
        }
    }
}
