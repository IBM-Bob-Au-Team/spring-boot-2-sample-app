
/*
 * JUnit test for ExampleHealthIndicator.
 */
package sample.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ExampleHealthIndicatorTest {

	private final ExampleHealthIndicator underTest = new ExampleHealthIndicator();

	@Test
	public void should_return_Health_up_when_OK() {
		Health health = underTest.health();

		assertThat(health.getStatus()).isEqualTo(Health.Status.UP);
		assertThat(health.getDetails()).containsEntry("counter", 42L);
	}

	@Test
	public void should_return_Health_down_when_KO() {
		underTest.health().setStatus(Health.Status.DOWN);
		Health health = underTest.health();

		assertThat(health.getStatus()).isEqualTo(Health.Status.DOWN);
		assertThat(health.getDetails()).doesNotContainKey("counter");
	}
}

Updated Java file:

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(ExampleHealthIndicator.class);

    private int counter = 0;

    @Resource
    @PostConstruct
    public void init(Logger logger) {
        this.logger = logger;
    }

    @Override
    @ConditionalOnProperty(name = "management.health.example.enabled", havingValue = "true", matchIfMissing = false)
    public Health health() {
        logger.info("Health indicator is being invoked.");
        return Health.up().withDetail("counter", counter).build();
    }

    /**
     * Sets the counter value for health check.
     *
     * @param counter the counter value
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
```