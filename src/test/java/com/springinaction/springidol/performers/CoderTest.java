package com.springinaction.springidol.performers;

import com.google.common.base.Strings;
import com.springinaction.springidol.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Test case for {@link Coder} interface and its usage.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CoderTest {
    @Autowired
    private Coder duke;
    @Autowired
    private Coder faultyDuke;

    @Test
    public void codersTest() throws Exception {
        assertNotNull(duke);
        assertNotNull(faultyDuke);
    }

    @Test
    public void codeTest() {
        assertFalse(Strings.isNullOrEmpty(duke.code()));
        assertFalse(Strings.isNullOrEmpty(faultyDuke.code()));
    }
}
