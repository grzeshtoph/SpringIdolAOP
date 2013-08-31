package com.springinaction.springidol.critics;

import com.google.common.base.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test case for {@link CriticismEngine}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CriticismEngineTest {
    @Autowired
    private CriticismEngine criticismEngine;
    @Autowired
    private ApplicationContext ctx;
    private List<String> criticismPool;

    @Before
    public void setUp() throws Exception {
         criticismPool = (List<String>) ctx.getBean("criticismPool");
    }

    @Test
    public void engineTest() {
        assertNotNull(criticismEngine);
    }

    @Test
    public void getCriticismTest() {
        String criticism = criticismEngine.getCriticism();
        assertFalse(Strings.isNullOrEmpty(criticism));
        assertTrue(criticismPool.contains(criticism));

        criticism = criticismEngine.getCriticism();
        assertFalse(Strings.isNullOrEmpty(criticism));
        assertTrue(criticismPool.contains(criticism));

        criticism = criticismEngine.getCriticism();
        assertFalse(Strings.isNullOrEmpty(criticism));
        assertTrue(criticismPool.contains(criticism));
    }
}
