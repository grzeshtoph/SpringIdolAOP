package com.springinaction.springidol;

import com.springinaction.springidol.performers.CCoder;
import com.springinaction.springidol.performers.Coder;
import com.springinaction.springidol.performers.JavaCoder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * An aspect that provides new {@link Coder} functionalities to the peformers.
 */
@Component
@Aspect
public class CoderProvider {
    @DeclareParents(value = "com.springinaction.springidol..*.Juggler", defaultImpl = JavaCoder.class)
    public Coder javaCoder;

    @DeclareParents(value = "com.springinaction.springidol..*.FaultyJuggler", defaultImpl = CCoder.class)
    public Coder cCoder;
}
