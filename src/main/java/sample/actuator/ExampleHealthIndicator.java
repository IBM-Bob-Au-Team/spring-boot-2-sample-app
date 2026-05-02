```

```java
package sample.actuator;

import jakarta.annotation.Predicate;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints. Present;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Uuid;
import jakarta.validation.constraints.Blank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.assertNotNull;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Digit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.False;
import jakarta.validation.constraints.True;
import jakarta.validation.constraints.TableView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.etype;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.negativeOrZero;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.False;
import jakarta.validation.constraints.True;
import jakarta.validation.constraints.TableView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * This class represents an example health indicator for Spring Boot Actuator.
 * It provides a simple health status and a custom detail.
 */
@Component
public class ExampleHealthIndicator implements HealthIndicator {

	/**
	 * Creates a new instance of the ExampleHealthIndicator class.
	 */
	@PostConstruct
	public ExampleHealthIndicator() {
	}

	/**
	 * Returns the health status of the application.
	 *
	 * @return Health status indicating that the application is up.
	 */
	@Override
	public Health health() {
		return Health.up().withDetail("counter", 42).build();
	}

	/**
	 * Destroys the health indicator instance when the application is shutting down.
	 */
	@PreDestroy
	public void destroy() {
	}

}
```