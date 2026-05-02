
import org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcConfiguration {

	@Bean
	public DataSourceImpl dataSource() {
		return new DataSourceImpl();
	}

	@Bean
	public DataSourceConfiguration dataSourceConfiguration(DataSource dataSource) {
		return new DataSourceConfiguration() {
			@Override
			public DataSource dataSource() {
				return dataSource;
			}
		};
	}
}

// Import omitted for brevity

```

```java
package sample.actuator;

import jakarta.annotation.postconstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Modernized version of {@link SampleActuatorApplication}.
 */
@SpringBootApplication
@ConditionalOnClass(DataSource.class)
public class SampleActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleActuatorApplication.class, args);
	}

	/**
	 * A modernized version of the {@link #helloHealthIndicator()} method.
	 *
	 * @return A custom {@link HealthIndicator} that returns a healthy status.
	 */
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

/**
 * A modernized version of the {@code JdbcConfiguration} class.
 */
@Configuration
public class JdbcConfiguration {

	@Inject
	private DataSource dataSource;

	@PostConstruct
	public void init() {
		// No initialization needed for this example
	}

	@PreDestroy
	public void destroy() {
		// No cleanup needed for this example
	}

	/**
	 * A modernized version of the {@link #dataSource()} method.
	 *
	 * @return An instance of the {@link DataSourceImpl} class.
	 */
	@Bean
	public DataSourceImpl dataSource() {
		return new DataSourceImpl();
	}

	/**
	 * A modernized version of the {@link #dataSourceConfiguration(org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration)} method.
	 *
	 * @param dataSource Configuration for the data source.
	 * @return A configured {@link DataSourceConfiguration}.
	 */
	@Bean
	public DataSourceConfiguration dataSourceConfiguration(DataSource dataSource) {
		return new DataSourceConfiguration() {
			@Override
			public DataSource dataSource() {
				return dataSource;
			}
		};
	}
}
```