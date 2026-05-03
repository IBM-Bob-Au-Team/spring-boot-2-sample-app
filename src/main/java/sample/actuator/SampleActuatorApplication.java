
/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorConfiguration {

	@PostConstruct
	public void init() {
		// Initialization logic
	}

	@PreDestroy
	public void destroy() {
		// Destruction logic
	}

	@Bean
	@ConditionalOnProperty(name = "sample.actuator.enabled", havingValue = "true")
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {

			@Override
			public Health health() {
				return Health.up().withDetail("hello", "world").build();
			}

		};
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.actuator")
public class ServiceProperties {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder();
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class SimpleHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("hello", "world").build();
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.actuator")
public class ServiceProperties {

	/*
	* Javadoc for the ServiceProperties class
	*
	* This class is responsible for holding configuration properties specific to the actuator sample.
    * It provides a way to store and retrieve configuration data for the application.
    *
	*/
	private String name;

	/**
	 * @return the name of the service
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set for the service
	 */
	public void setName(String name) {
		this.name = name;
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerConfiguration {

	@Bean
	public ApplicationRunner applicationRunner(RestTemplateBuilder restTemplateBuilder) {
		return args -> {
			// Runner logic
		};
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.actuator")
public class ServiceProperties {

	/*
	* Javadoc for the ServiceProperties class
	*
	* This class is responsible for holding configuration properties specific to the actuator sample.
    * It provides a way to store and retrieve configuration data for the application.
    *
	*/
	private String name;

	/**
	 * @return the name of the service
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set for the service
	 */
	public void setName(String name) {
		this.name = name;
	}

}

/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package sample.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.actuator")
public class ServiceProperties {

	/*
	* Javadoc for the ServiceProperties class
	*
	* This class is responsible for holding configuration properties specific to the actuator sample.
    * It provides a way to store and retrieve configuration data for the application.
    *
	*/
	private String name;

	/**
	 * @return the name of the service
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set for the service
	 */
	public void setName(String name) {
		this.name = name;
	}

}