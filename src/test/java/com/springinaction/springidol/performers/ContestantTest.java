package com.springinaction.springidol.performers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static com.springinaction.springidol.performers.Contestant.*;
import static org.junit.Assert.assertNotNull;

/**
 * Test case for {@link Contestant}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ContestantTest {
    @Autowired
    private Properties awardFor;

    @Test
    public void awardForTest() {
        assertNotNull(awardFor);
        assertEquals(AWARD_FOR_JUGGLER, awardFor.getProperty("juggler"));
        assertEquals(AWARD_FOR_FAULTY_JUGGLER, awardFor.getProperty("faultyJuggler"));
    }
}
