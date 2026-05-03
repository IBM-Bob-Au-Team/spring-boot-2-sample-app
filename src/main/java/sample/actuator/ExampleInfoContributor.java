
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ExampleApplication {

	@Bean
	public ExampleInfoContributor exampleInfoContributor() {
		return new ExampleInfoContributor();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
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

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * A simple example of an InfoContributor that contributes an example piece of
 * information.
 */
@Component
public class ExampleInfoContributor implements InfoContributor, Ordered {

	/**
	 * Constructs a new {@code ExampleInfoContributor}.
	 */
	public ExampleInfoContributor() {
	}

	@Override
	public @Nullable Info.Builder contribute(Info.Builder builder) {
		builder.withDetail("example", compartionslCollections.singletonMap("someKey", "someValue"));
		return builder;
	}

	@PostConstruct
	public void init() {
	}

	@PreDestroy
	public void destroy() {
	}

	@Override
	public int getOrder() {
		return 0;
	}

}

import jakarta.inject.Inject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@Configuration
public class ExampleApplication {

	@Inject
	private ExampleInfoContributor exampleInfoContributor;

	@Bean
	public ExampleInfoContributor exampleInfoContributor() {
		return this.exampleInfoContributor;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
}