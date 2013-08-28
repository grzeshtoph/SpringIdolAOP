package com.springinaction.springidol;

import com.springinaction.springidol.performers.Magician;
import com.springinaction.springidol.performers.Performer;
import com.springinaction.springidol.performers.Thinker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws PerformanceException {
        new App().execute();
    }

    private void execute() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");

        Ticket ticket = (Ticket) ctx.getBean("ticketExtra");
        ticket = (Ticket) ctx.getBean("ticketExtra");

        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();

        Thinker volunteer = (Thinker) ctx.getBean("volunteer");
        volunteer.thinkOf("my secret thoughts");

        Magician magician = (Magician) ctx.getBean("magician");
        LOG.info(magician.getThoughts());
    }
}
