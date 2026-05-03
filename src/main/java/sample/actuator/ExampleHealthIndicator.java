
/*
 * Updated Java file:
 */

package sample.actuator;

import jakarta.inject.Inject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.actuate.autoconfigure.health.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.health.HealthIndicatorConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.BindTo;
import org.springframework.boot.context.properties.bind.BindingAnnotation;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.TerminationLocalBinding;
import org.springframework.boot.context.typeinfo.TypeMatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
@ConditionalOnWebApplication
@HealthIndicatorConfiguration
public class ExampleHealthIndicator implements HealthIndicator {

	@Inject
	private Environment environment;

	@Bean
	@Primary
	@BindTo(Value.class)
	@BindingAnnotation
	public int getCounter() {
		return environment.getProperty("sample.actuator.counter", Integer.class, 42);
	}

	@PostConstruct
	public void init() {
		// Additional initialization code can be added here.
	}

	@PreDestroy
	public void destroy() {
		// Additional cleanup code can be added here.
	}

	@Override
	public Health health() {
		return Health.up().withDetail("counter", getCounter()).build();
	}

}