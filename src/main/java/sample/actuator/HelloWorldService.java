
/*
 * Sample Actuator application to demonstrate health status
 */
package sample.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ActuatorApplication {

	public static void main(String[] args) throws Exception {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(ActuatorApplication.class)
			.build()
			.run(args)) {
			ActuatorApplication application = context.getBean(ActuatorApplication.class);
			System.out.println("Let's inspect the bean status:");
			System.out.println(" - " + application);
			System.out.println(" - " + context);
			System.out.println(" - " + application.getHelloService());
//START SNIPPET: sample
System.out.println(" - " + application.health());
//END SNIPPET: sample
		}
	}

}

package sample.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

@ConditionalOnProperty(name = "management.endpoints.web.exposure.include",
		havingValue = "health,info")
public class HelloWorldHealthIndicator implements HealthIndicator {

	private final HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldHealthIndicator(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@Override
	public Health health() {
		if (helloWorldService.getHelloMessage() == null || helloWorldService.getHelloMessage().isEmpty()) {
			return Health.down().build();
		}
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

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ActuatorApplication implements ServletContextInitializer<ServletContext> {

	@Autowired
	private ServletContext servletContext;

	@PostConstruct
	public void init() {
		System.out.println("Actuator application initialized.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Actuator application destroyed.");
	}

	@Bean
	public ServletWebServerFactory webServerFactory() {
		return new TomcatServletWebServerFactory();
	}

	public static void main(String[] args) throws Exception {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(ActuatorApplication.class)
				.build()
				.run(args)) {
			ActuatorApplication application = context.getBean(ActuatorApplication.class);
			System.out.println("Let's inspect the bean status:");
			System.out.println(" - " + application);
			System.out.println(" - " + context);
			System.out.println(" - " + application.getHelloService());
//START SNIPPET: sample
			Health health = application.health();
			System.out.println(" - " + health);
//END SNIPPET: sample
		}
	}

	@Override
	public void onStartup(ServletContext servletContext) throws Exception {
		this.servletContext = servletContext;
	}

}

package sample.actuator;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

public class HelloWorldHealthIndicator implements HealthIndicator {

	@Inject
	private HelloWorldService helloWorldService;

	public HelloWorldHealthIndicator(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@Override
	public Health health() {
		if (helloWorldService.getHelloMessage() == null || helloWorldService.getHelloMessage().isEmpty()) {
			return Health.down().build();
		}
		return Health.up().build();
	}

}

package sample.actuator;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService {

	

	@Inject
	public HelloWorldService() {
	}

	@Resource
	public void setServletContext(ServletContext servletContext) {
	}

	public String getHelloMessage() {
		return "Spring boot says hello from a Docker container";
	}

}
```