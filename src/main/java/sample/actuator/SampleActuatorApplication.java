
/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args Command line arguments
	 */
	@PostConstruct
	public void init(String[] args) {
		SpringApplication.run(SampleActuatorApplication.class, args);
	}

	/**
	 * Pre-destruction method to perform any cleanup tasks.
	 */
	@PreDestroy
	public void destroy() {
	}

	/**
	 * Bean method to provide a custom HealthIndicator implementation.
	 *
	 * @return An instance of the custom HealthIndicator
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

	@Resource(name = "myResource")
	private void setMyResource(MyResource myResource) {
	}

}
```