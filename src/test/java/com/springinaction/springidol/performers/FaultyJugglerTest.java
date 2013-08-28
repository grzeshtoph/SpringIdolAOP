package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test case for {@link FaultyJuggler}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FaultyJugglerTest {
    @Autowired
    private Performer faultyDuke;

    @Test(expected = PerformanceException.class)
    public void performTest() throws PerformanceException {
        faultyDuke.perform();
    }
}
