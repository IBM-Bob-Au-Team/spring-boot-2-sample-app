
```

```java

/*
 * Copyright 2012-2023 the original author or authors.
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
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sample Actuator application demonstrating a basic HealthIndicator.
 */
@Configuration
@SpringBootApplication(exclude = {WebFluxConfiguration.class})
@Singleton
public class SampleActuatorApplication {

	@Resource
	private ServiceProperties serviceProperties;

	@PostConstruct
	public void init() {
		System.out.println("Service properties: " + serviceProperties);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method called.");
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