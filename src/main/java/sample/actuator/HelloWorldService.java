
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
import org.springframework.stereotype.Service;

@Service
public class HelloWorldHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().build();
	}

}

```java
/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copying of the License at
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

import jakarta.annotation.Resource;
import jakarta.inject.Inject;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * An example service and actor to demonstrate a Spring Boot actuator.
 * Importantly it can also be used as a custom health indicator to
 * ensure that the container has something to say if you use it in Docker, Kubernetes, etc.
 */
@Service
public class HelloWorldService {

	/**
	 * Returns the greeting message.
	 *
	 * @return the greeting message
	 */
	public String getHelloMessage() {
		return "Spring boot says hello from a Docker container";
	}

}

/**
 * An example health indicator to demonstrate a Spring Boot actuator.
 * Importantly it can also be used as a custom health indicator to
 * ensure that the container has something to say if you use it in Docker, Kubernetes, etc.
 */
@Service
public class HelloWorldHealthIndicator implements HealthIndicator {

	/**
	 * Returns the current health of the system.
	 *
	 * @return the current health
	 */
	@Override
	public Health health() {
		return Health.up().build();
	}

}
```