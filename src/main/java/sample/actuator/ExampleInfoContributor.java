
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

import java.util.Collections;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Sample context listener for demonstration purposes.
 */
@Component
public class ExampleServletContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ExampleServletContextListener.class);

	@Resource
	private WebApplicationContext webApplicationContext;

	@Value("${sample.actuator.example.key}")
	private String exampleKey;

	/**
	 * Initializes the listener.
	 * @throws Exception if an error occurs initializing the listener.
	 */
	@PostConstruct
	public void init() throws Exception {
		logger.info("Listening for context initialization events.");
	}

	/**
	 * Handles the context destroyed event.
	 * @param event the servlet context event.
	 */
	@PreDestroy
	public void destroy(@Nonnull ServletContextEvent event) {
		logger.info("Shutting down the example context listener.");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("Context initialized.");
		Info.Builder builder = Info.builder();
		builder.withId("example-context-listener");
		builder.withDetail("exampleKey", exampleKey);
		this.webApplicationContext.publishEvent(new InfoEvent(builder.build()));
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("Context destroyed.");
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

import jakarta.inject.Inject;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ExampleInfoContributor implements InfoContributor {

	@Inject
	private ExampleListener exampleListener;

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
		builder.withDetail("exampleListener", this.exampleListener.getDetails());
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

import jakarta.inject.Inject;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

	@Inject
	private ExampleListener exampleListener;

	@Override
	public Health health() {
		if (this.exampleListener.isHealthy()) {
			return Health.up().build();
		}
		else {
			return Health.down().build();
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

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthStatus extends AbstractHealthIndicator {

	@Override
	protected Status buildHealthStatus(String... details) {
		return Status.UP();
	}

}