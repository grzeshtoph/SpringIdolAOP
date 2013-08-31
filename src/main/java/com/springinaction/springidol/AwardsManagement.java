package com.springinaction.springidol;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * A class acting as an aspect, when preparing and giving the award to a performer.
 */
@Component
@Aspect
public class AwardsManagement {
    private static final Logger LOG = LoggerFactory.getLogger(AwardsManagement.class);

    @Pointcut("execution(* com.springinaction.springidol..*.Contestant.receiveAward(..))")
    public void awardReceiving() {
    }

    @Before("awardReceiving()")
    public void getTheDiploma() {
        LOG.info("Writing the diploma");
    }

    @Before("awardReceiving()")
    public void getTheCashPrize() {
        LOG.info("Stealing cash for the prize");
    }

    @AfterReturning("awardReceiving()")
    public void lockTheCashSafe() {
        LOG.info("Locking the cash safe");
    }

    @AfterReturning("awardReceiving()")
    public void lockTheDiplomaShelf() {
        LOG.info("Locking the diploma shelf");
    }
}
