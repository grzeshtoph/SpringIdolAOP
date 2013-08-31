package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Additional AspectJ-based magician.
 */
@Component
@Aspect
public class CruelMagician implements MindReader {
    private static final Logger LOG = LoggerFactory.getLogger(CruelMagician.class);
    private String thoughts;

    @Pointcut("execution(* com.springinaction.springidol..*.Thinker.thinkOf(String)) && args(thoughts)")
    public void thinking(String thoughts) {
    }

    @Before("thinking(thoughts)")
    @Override
    public void intercept(String thoughts) throws PerformanceException {
        this.thoughts = thoughts;

        LOG.info("I am cruel magician! I can read the thoughts and now I will posses them forever: {}",
                this.getThoughts());
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
