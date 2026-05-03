
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.4</version>
	</parent>

	<groupId>sample</groupId>
	<artifactId>actuator</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<name>sample-actuator</name>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
	</div>
	</dependencies>
</project>

```java
/*
 * Copyright 2012-2023 the original author or authors.
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

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.annotation.security.secured;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * A simple Spring Boot application that demonstrates the use of actuator endpoints.
 *
 * @author [Your Name]
 */
@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication {

	/**
	 * Main entry point for the application.
	 *
	 * @param args command line arguments
	 */
	@PostConstruct
	public void initialize(String[] args) {
		SpringApplication.run(SampleActuatorApplication.class, args);
	}

	/**
	 * Destroys the application when it is stopped.
	 *
	 * @throws ServletException if an error occurs during shutdown
	 */
	@PreDestroy
	public void destroy() throws ServletException {
		// Perform any cleanup tasks here
	}

	/**
	 * A custom health indicator that returns a healthy status.
	 *
	 * @return a custom health indicator
	 */
	@Bean
	@ConditionalOnMissingBean(HealthIndicator.class)
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {

			/**
			 * Returns the health status of the application.
			 *
			 * @return the health status
			 */
			@Override
			public Health health() {
				return Health.up().withDetail("hello", "world").build();
			}
		};
	}

	/**
	 * A simple servlet that demonstrates the use of Spring Security annotations.
	 *
	 * @author [Your Name]
	 */
	@Component
	@WebServlet("/secure")
	@RolesAllowed("USER")
	@secured("ROLE_USER")
	public static class SecureServlet extends HttpServlet {

		@Resource(name = "sampleServletConfig")
		private SampleServletConfig sampleServletConfig;

		/**
		 * Handles HTTP GET requests for the "/secure" path.
		 *
		 * @param request the incoming HTTP request
		 * @param response the outgoing HTTP response
		 * @throws ServletException if an error occurs processing the request
		 * @throws IOException if an error occurs writing the response
		 */
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().write("Hello, secure world!");
		}
	}
}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-parent</artifactId>
		<version>2.6.8</version>
	</parent>

	<groupId>sample</groupId>
	<artifactId>actuator</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<name>sample-actuator</name>

	<properties>
		<java.version>17</java.version>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
	</div>
	</dependencies>
</project>
```