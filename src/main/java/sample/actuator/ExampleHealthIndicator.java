
import jakarta.annotation.PostConstruct;

package sample.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

	/**
	 * Initializes the health indicator.
	 */
	@PostConstruct
	public void init() {

	}

	/**
	 * Returns the health status of the application.
	 * @return the health status
	 */
	@Override
	public Health health() {
		return Health.up().withDetail("counter", 42).build();
	}
}