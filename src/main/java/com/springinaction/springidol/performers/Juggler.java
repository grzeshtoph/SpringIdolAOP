package com.springinaction.springidol.performers;

import com.google.common.base.Objects;
import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Juggler performer.
 */
public class Juggler implements Performer {
    private static final Logger LOG = LoggerFactory.getLogger(Juggler.class);
    @Value("#{3 * 5}")
    private int beanBags = 3;
    private String performerName;
    @Value("duke@gmail.com")
    private String email;

    public int getBeanBags() {
        return beanBags;
    }

    public void setBeanBags(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void setBeanName(String s) {
        performerName = s;
    }

    public String getPerformerName() {
        return performerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void perform() throws PerformanceException {
        LOG.info("-----");
        LOG.info("Performance by '{}'", performerName);
        LOG.info("Email: {}", email);
        LOG.info("JUGGLING {} BEANBAGS", beanBags);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(performerName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Juggler) {
            if (this == obj) return true;

            Juggler that = (Juggler) obj;

            return Objects.equal(getEmail(), that.getEmail())
                    && Objects.equal(getPerformerName(), that.getPerformerName())
                    && Objects.equal(beanBags, that.beanBags);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("performerName", getPerformerName())
                .add("email", getEmail())
                .add("beanBags", beanBags).toString();
    }
}
