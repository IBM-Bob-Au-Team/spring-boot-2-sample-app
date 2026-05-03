
```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * A sample health indicator implementation for Spring Boot Actuator.
 *
 * This health indicator reports a simple up status with a custom detail.
 */
@Component
@WebServlet(urlPatterns = "/health", name = "health")
public class ExampleHealthIndicator implements HealthIndicator {

	private final ServletContext servletContext;

	/**
	 * Constructs a new health indicator with a reference to the servlet context.
	 *
	 * @param servletContext the servlet context
	 */
	@Inject
	public ExampleHealthIndicator(@Resource(name = ServletContext.CLASS_NAME) ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@PostConstruct
	void init() {
		// Initialization code can be added here.
	}

	@PreDestroy
	void shutdown() {
		// Shutdown code can be added here.
	}

	@Override
	public Health health() {
		return Health.up().withDetail("counter", 42).build();
	}

}
```