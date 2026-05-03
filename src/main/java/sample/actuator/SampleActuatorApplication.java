
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
```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceHealthIndicator;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication {

	@Resource
	private DataSource dataSource;

	@PostConstruct
	public void init() {
		// Initialize the application
	}

	@Bean
	@ConditionalOnMissingBean
	public DataSourceHealthIndicator dataSourceHealthIndicator() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return new DataSourceHealthIndicator(dataSource);
	}

	@Bean
	@ConditionalOnMissingBean
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