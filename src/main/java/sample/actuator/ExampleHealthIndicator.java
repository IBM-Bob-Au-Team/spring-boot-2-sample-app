
/*
 * Javadoc:
 * <p>
 * This is an example Spring Boot health indicator that returns a healthy status with a custom detail.
 *
 * --}}
```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.annotation.concurrent.ThreadSafe;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org Accuracy;

@Component
@ThreadSafe
public class ExampleHealthIndicator implements HealthIndicator {

	private final Accuracy accuracy;

	@Inject
	public ExampleHealthIndicator(Accuracy accuracy) {
		this.accuracy = accuracy;
	}

	@PostConstruct
	public void init() {
		// Initialization code
	}

	@PreDestroy
	public void destroy() {
		// Cleanup code
	}

	@Override
	public Health health() {
		return Health.status(accuracy.getStatus()).withDetail("counter", accuracy.getCounter()).build();
	}

	/**
	 * This method returns a Spring Boot health status based on the accuracy status and a custom detail.
	 *
	 * @return the health status
	 */
}
```