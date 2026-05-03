
javax.annotation.PostConstruct;
javax.annotation.PreDestroy;

/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org
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

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A simple service that returns a hello message.
 *
 * This is a demonstration of approximately twenty different Spring
 * features including Java-based configuration, the {@link
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration} annotation,
 * {@link org.springframework.boot.autoconfigure.SpringBootApplication}, {@link
 * org.springframework.context.annotation.Configuration} and annotations, {@link
 * org.springframework.boot.context.properties.ConfigurationProperties}, {@link
 * org.springframework.boot.CommandLineRunner} and {@link
 * org.springframework.boot.context.event.ApplicationReadyEvent}.
 */
@Service
public class HelloWorldService implements ServletContextListener {

	/**
	 * The singleton resource
	 */
	@Resource(name = "beanName")
	private SingletonResource singletonResource;

	@Autowired
	private AnotherService anotherService;

	/**
	 * Offers a hello message
	 *
	 * @return a hello message
	 */
	@PostConstruct
	public void init() {
		System.out.println("Initialised!");
	}

	@Override
	@PreDestroy
	public void destroy() {
		System.out.println(" destroyed!");
	}

	/**
	 * Returns the hello message from the singleton
	 *
	 * @return the hello message
	 */
	public String getHelloMessage() {
		return singletonResource.getHelloFromSingleton();
	}

	/**
	 * Uses another service to get a message
	 *
	 * @return a message from another service
	 */
	public String getAnotherMessage() {
		return anotherService.getAnotherMessage();
	}

}

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		springBootJarRunner.main(args);
	}

}