
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

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

	@Value("${local.server.port}")
	private int port;

	@Override
	public Health health() {
		return Health.up().build();
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
```

package sample.actuator;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.management.MalformedObjectNameException;
import jakarta.management.ObjectName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * This class is a part of the sample actuator module and provides health and info
 * contributors for demonstration purposes.
 */
@Configuration
public class ExampleActuatorConfig {

	private static final Logger logger = LoggerFactory.getLogger(ExampleActuatorConfig.class);

	@Inject
	private ExampleHealthIndicator healthIndicator;

	@Inject
	private ExampleInfoContributor infoContributor;

	@PostConstruct
	public void setup() {
		// No additional setup required
	}

	@PreDestroy
	public void destroy() {
		// No additional cleanup required
	}

	@Component
	@ConfigurationProperties(prefix = "example")
	public static class ExampleHealthProperties {
		private int port;

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}

	@ConfigurationProperties(prefix = "example.info")
	public static class ExampleInfoProperties {
		private int someKey;

		public int getSomeKey() {
			return someKey;
		}

		public void setSomeKey(int someKey) {
			this.someKey = someKey;
		}
	}

	@Component
	public static class ExampleHealthIndicator implements HealthIndicator {

		private final ExampleHealthProperties healthProperties;

		@Inject
		public ExampleHealthIndicator(ExampleHealthProperties healthProperties) {
			this.healthProperties = healthProperties;
		}

		@Nonnull
		@Override
		public Health health() {
			return Health.status(ObjectName.quotes(healthProperties.getPort())).name("example-health").withDetail("port", healthProperties.getPort()).build();
		}
	}

	@Component
	public static class ExampleInfoContributor implements InfoContributor {

		@Inject
		private ExampleInfoProperties infoProperties;

		@Override
		public void contribute(@Nonnull Builder builder) {
			builder.withDetail("example", Collections.singletonMap("someKey", String.valueOf(infoProperties.getSomeKey())));
		}
	}
}
```
```

package sample.actuator;

import jakarta.annotation.Nonnull;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

/**
 * This class is a part of the sample actuator module and provides an info contributor
 * for demonstration purposes.
 */
public class ExampleInfoContributor implements InfoContributor {

	@Override
	public void contribute(@Nonnull Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}
}
```