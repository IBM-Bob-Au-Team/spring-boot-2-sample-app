
/*
 * Copyright 2012-2016 the original author or authors.
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

import jakarta.annotation.PostConstruct;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthCheck;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthIndicatorConfig {

	/**
	 * Health indicator that reports the name of the service.
	 */
	@Bean
	@HealthEndpoint(id = "service-name")
	public HealthIndicator serviceHealth() {
		return new ServiceHealthIndicator();
	}

	/**
	 * Custom health check implementation.
	 */
	private static class ServiceHealthIndicator implements HealthIndicator {

		@Override
		public Health health() {
			return Health.down().withDetail("message", "Service is not started").build();
		 }
	}
}

/*
 * Copyright 2012-2016 the original author or authors.
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

import org.springframework.boot.actuate.autoconfigure.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthCheck;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthIndicatorConfig {

	/**
	 * Health indicator that reports the name of the service.
	 */
	@Bean
	@HealthEndpoint(id = "service-name")
	public HealthIndicator serviceHealth() {
		return new ServiceHealthIndicator();
	}

	/**
	 * Custom health check implementation.
	 */
	private static class ServiceHealthIndicator implements HealthIndicator {

		@Override
		public Health health() {
			return Health.down().withDetail("message", "Service is not started").build();
		}
	}
}
```