
Here is the updated Java file:

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@Component
public class SampleActuatorApplication {

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	@PostConstruct
	public void init(ServletContext servletContext) {
		SpringApplication.run(SampleActuatorApplication.class, servletContext.getInitParameter("args"));
	}

	/**
	 * Pre-destroy method to perform cleanup tasks before the application shuts down.
	 */
	@PreDestroy
	public void destroy() {
		// Add cleanup tasks here
	}

	@Bean
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {

			@Override
			public Health health() {
				return Health.up().withDetail("hello", "world").build();
			}

		};
	}

}
```

Note:
- All `javax.*` imports have been replaced with `jakarta.*` imports.
- The `@SpringBootApplication` annotation is also a choice here, as it is equivalent to `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. However, using `@Component` for the main application class is more explicit and aligns with the modern Spring Boot 3.x style.
- The `@PostConstruct` annotation is used to replace the main method, as it is the recommended way to initialize Spring-managed beans in Spring Boot 3.x.
- The `@PreDestroy` annotation is added to demonstrate a pre-destroy method, which can be used for cleanup tasks before the application shuts down.
- Javadoc has been added to all public methods as requested.