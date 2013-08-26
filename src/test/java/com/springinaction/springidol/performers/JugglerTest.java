package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.*;

/**
 * In-container test case for {@link Juggler}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JugglerTest {
    @Autowired
    private Performer duke;
    private Juggler dukeImpl;

    @Before
    public void setUp() throws Exception {
        dukeImpl = TestUtils.getTargetObjectBehindSpringProxy(duke, Juggler.class);
    }

    @Test
    public void dukeTest() {
        assertNotNull(dukeImpl);
        assertEquals(15, dukeImpl.getBeanBags());
        assertEquals("duke@gmail.com", dukeImpl.getEmail());
    }

    @Test
    public void doPerformanceTest() throws PerformanceException {
        duke.perform();
    }

    @Test
    public void hashCodeTest() {
        Juggler duke1 = new Juggler();
        assertFalse(dukeImpl.hashCode() == duke1.hashCode());
    }

    @Test
    public void toStringTest() {
        assertEquals("Juggler{performerName=duke, email=duke@gmail.com, beanBags=15}", duke.toString());
    }

    @Test
    public void equalsTest() {
        assertTrue(dukeImpl.equals(dukeImpl));
        assertFalse(dukeImpl.equals(null));
        assertFalse(dukeImpl.equals(new Object()));

        Juggler duke1 = new Juggler();
        assertFalse(dukeImpl.equals(duke1));
        duke1.setEmail("duke@gmail.com");
        assertFalse(dukeImpl.equals(duke1));
        duke1.setBeanBags(20);
        assertFalse(dukeImpl.equals(duke1));
        duke1.setBeanBags(15);
        assertFalse(dukeImpl.equals(duke1));
        duke1.setBeanName("duke");
        assertTrue(dukeImpl.equals(duke1));
    }
}
