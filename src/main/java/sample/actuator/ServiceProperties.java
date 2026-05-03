
/*
 * JUnit 4 test case
 */
package sample.actuator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.commons.util.StringUtils.repeat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableConfigurationProperties(ServiceProperties.class)
public class ServicePropertiesTest {

	@Autowired
	private ServiceProperties properties;

	@Test
	public void testName() {
		assertEquals("World", properties.getName());
	}

	@Test
	public void testNameWithCustomValue() {
		properties.setName("Spring Boot");
		assertEquals("Spring Boot", properties.getName());
	}
}

// Please migrate this Java file from Spring Boot 2.x to Spring Boot 3.x

```java
/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.annotation.>{% jakarta.annotation.SIGNAL_%
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import jakarta.inject.Singleton;
import org.springframework.context.annotation.Configuration;

/**
 * Service configuration properties.
 */
@Configuration(proxyBeanMethods = false)
@Singleton
public class ServiceConfigProperties {

	/**
	 * Name of the service.
	 */
	private String name;

	/**
	 * Gets the name of the service.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the service.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Configures the service properties.
	 * @throws Exception if an error occurs
	 */
	@PostConstruct
	public void configure() throws Exception {
		// Configuration logic here
	}

	/**
	 * Destroys the service properties.
	 */
	@PreDestroy
	public void destroy() {
		// Cleanup logic here
	}
}

/*
 * JUnit 5 test case
 */
package sample.actuator;

import jakarta.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ServiceConfigPropertiesTest {

	@Inject
	private ServiceConfigProperties properties;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testName() {
		assertEquals("World", properties.getName());
	}

	@Test
	void testNameWithCustomValue() {
		properties.setName("Spring Boot");
		assertEquals("Spring Boot", properties.getName());
	}
}
```