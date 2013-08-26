package com.springinaction.springidol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test case for {@link Audience}
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AudienceTest {
    @Autowired
    private Audience audience;

    @Test
    public void methodsTest() {
        audience.takeSeats();
        audience.turnOffCellPhones();
        audience.applaud();
        audience.demandRefund();
    }
}
