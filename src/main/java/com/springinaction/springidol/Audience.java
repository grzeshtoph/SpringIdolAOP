package com.springinaction.springidol;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Exemplary AOP object.
 */
@Component
@Aspect
public class Audience {
    private static final Logger LOG = LoggerFactory.getLogger(Audience.class);

    @Pointcut("execution(* com.springinaction.springidol..*.Performer.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void takeSeats() {
        LOG.info("Audience is taking their seats.");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        LOG.info("Audience is turning off their cellphones.");
    }

    @AfterReturning("performance()")
    public void applaud() {
        LOG.info("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        LOG.info("Boo! We want our money back!");
    }

    @Around("performance()")
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
