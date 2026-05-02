
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
/*
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.actuator;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ConfigurationProperties(prefix = "health")
public class HealthEndpointsConfiguration {

	@Bean
	public ServletRegistrationBean<HealthEndpointsWebService> healthEndpointsRegistration(HealthEndpointsWebService healthEndpointsWebService) {
		ServletRegistrationBean<HealthEndpointsWebService> registration = new ServletRegistrationBean<>(healthEndpointsWebService);
		registration.addUrlPatterns("/actuator/health");
		return registration;
	}

	@PostConstruct
	public void initialize() {
		/* ... */
	}

	@PreDestroy
	public void destroy() {
		/* ... */
	}

}

/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "health")
public class HealthIndicatorConfig {

	@Bean
	public HealthIndicator exampleHealthIndicator() {
		return new ExampleHealthIndicator();
	}

}

// The updated Java file

package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for health endpoints.
 */
@Configuration
@ConditionalOnWebApplication
@ConfigurationProperties(prefix = "health")
public class HealthEndpointsConfiguration {

	/**
	 * Registers the health endpoints web service for the application.
	 *
	 * @return The servlet registration bean for the health endpoints.
	 */
	@Bean
	public ServletRegistrationBean<HealthEndpointsWebService> healthEndpointsRegistration(HealthEndpointsWebService healthEndpointsWebService) {
		ServletRegistrationBean<HealthEndpointsWebService> registration = new ServletRegistrationBean<>(healthEndpointsWebService);
		registration.addUrlPatterns("/actuator/health");
		return registration;
	}

	/**
	 * Initializes resources after the health endpoints are created.
	 */
	@PostConstruct
	public void initialize() {
		/* ... */
	}

	/**
	 * Releases resources before the application shuts down.
	 */
	@PreDestroy
	public void destroy() {
		/* ... */
	}

}

/**
 * Configures health indicators for the application.
 */
@Configuration
@ConfigurationProperties(prefix = "health")
public class HealthIndicatorConfig {

	/**
	 * Creates a bean for the example health indicator.
	 *
	 * @return The example health indicator bean.
	 */
	@Bean
	public HealthIndicator exampleHealthIndicator() {
		return new ExampleHealthIndicator();
	}

}

/**
 * Health indicator implementation.
 */
public class ExampleHealthIndicator implements HealthIndicator {

	/**
	 * Returns the health status for this health indicator.
	 *
	 * @return The health status.
	 */
	@Override
	public Health health() {
		return Health.up().withDetail("counter", 42).build();
	}

}