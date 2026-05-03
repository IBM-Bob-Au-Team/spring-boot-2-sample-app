
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
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication implements ServletContextListener {

	@Resource
    private SampleApplicationProperties properties;

    @Override
    @PostConstruct
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Sample application initialized with properties: " + properties);
    }

    @Override
    @PreDestroy
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Sample application destroyed");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Application context refreshed");
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Application context closed");
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleActuatorApplication.class, args);
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