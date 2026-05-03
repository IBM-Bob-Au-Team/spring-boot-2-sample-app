
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
/*
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.health.HealthContribution;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.HeapDump;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
public class SampleActuatorConfig {

	private static final Logger log = LoggerFactory.getLogger(SampleActuatorConfig.class);

	private final ServiceProperties serviceProperties;

	public SampleActuatorConfig(ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	@Bean
	@HealthContribution(id = "docker")
	public HealthIndicator dockerHealth() {
		return () -> {
			Health health = Health.up();
			if (!serviceProperties.isDockerEnabled()) {
				health = health.status(Status.DOWN).withDetail("reason", "Service is not deployed within a Docker container");
			}
			return health;
		};
	}

	@Bean
	@HealthContribution(id = "database")
	public HealthIndicator databaseHealth() {
		return () -> {
			Health health = Health.up();
			if (serviceProperties.isDatabaseEnabled()) {
				health = health.status(Status.UNKNOWN);
			} else {
				health = health.status(Status.DOWN).withDetail("reason", "No database configured");
			}
			return health;
		};
	}

	@Bean
	public ResponseEntity<byte[]> dumpHeap() {
		HeapDump heapDump = new HeapDump(serviceProperties.getHeapDumpPath());
		return ResponseEntity.ok()
				.headers(Headers.newFluentHeaders()
						.set(HttpHeaders.CONTENT_TYPE, "application/x-heapdump")
						.setHeader(HttpHeaders.PRAGMA, "no-cache"))
				.body(heapDump.dump());
	}

	@Bean
	public BeanPostProcessor getBeanPostProcessor() {
		return new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				if (beanName.equals("sample.actuator.SampleActuatorApplication")) {
					log.info("Initializing sample actuator application");
				}
				return bean;
			}

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if (beanName.equals("sample.actuator.SampleActuatorApplication")) {
					log.info("initialized sample actuator application");
				}
				return bean;
			}
		};
	}

	@Bean
	public HttpServletRequestFactory getRequestFactory() {
		return () -> new HttpServletRequestWrapper(HttpServletRequest.class) {
			@Override
			public String getHeader(String name) {
				if (name.equalsIgnoreCase("accept")) {
					return "application/vnd.openjdk.binary+heapdump";
				}
				return super.getHeader(name);
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
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication {

	/**
	 * Main method, that launches the Spring Boot application.
	 *
	 * @param args application arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SampleActuatorApplication.class, args);
	}

	/**
	 * Initializes and returns the health indicator for the "hello" endpoint.
	 *
	 * @return HealthIndicator for the "hello" endpoint
	 */
	@Bean
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {

			/**
			 * Returns the health status for the "hello" endpoint.
			 *
			 * @return Health status, with a detail "hello=world"
			 */
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
 *
 * Unless required by applicable law or agreed to in writing, software
/*
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.health.HealthContribution;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.HeapDump;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
public class SampleActuatorConfig {

	private static final Logger log = LoggerFactory.getLogger(SampleActuatorConfig.class);

	private final ServiceProperties serviceProperties;

	public SampleActuatorConfig(ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	/**
	 * Registers a health contribution for the "docker" endpoint.
	 *
	 * @return HealthIndicator for the "docker" endpoint
	 */
	@Bean
	@HealthContribution(id = "docker")
	public HealthIndicator dockerHealth() {
		return () -> {
			Health health = Health.up