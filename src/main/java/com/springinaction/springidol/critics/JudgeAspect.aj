package com.springinaction.springidol.critics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AspectJ aspect for judging performers.
 */
public aspect JudgeAspect {
    private static final Logger LOG = LoggerFactory.getLogger(JudgeAspect.class);

    public JudgeAspect() { }

    pointcut performance(): execution(* perform(..));

    after() returning(): performance() {
        LOG.info("JudgeAspect' commentary: {}", criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
