
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/* Javadoc:
 * @ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
 * - Annotates a configuration class to be bound to a prefix in the environment.
 * - Use the 'ignoreUnknownFields' attribute to specify whether unknown properties
 *   should be ignored or not.
 *
 * @SpringBootApplication
 * - A convenience annotation that combines @Configuration, @EnableAutoConfiguration,
 *   and @ComponentScan.
 * - It scans for components within the package of the annotated class and for
 *   any packages that it specifies using @ComponentScan.
 */

// Spring Boot 3.x migration:

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.boot.context.properties.BindTo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceProperties {

	/**
	 * Name of the service.
	 */
	@BindTo("name")
	private String name = "World";

	/**
	 * Sets the name of the service.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the service.
	 * @return the name of the service
	 */
	public String getName() {
		return this.name;
	}

	@PostConstruct
	public void init() {
		// Initialization logic
	}

	@PreDestroy
	public void destroy() {
		// Destruction logic
	}

}

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}