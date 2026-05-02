
/*
 * Javadoc:
 *
 * SampleActuatorApplication is the main entry point of the sample actuator application.
 * It is a Spring Boot application that uses the SpringBootApplication annotation
 * to indicate that it is a bootstrappable Spring application.
 * The application is configured to enable properties from the ServiceProperties class.
 * It contains a single health indicator bean, helloHealthIndicator,
 * which returns a Health object with a status of UP and a detail "hello" with value "world".
 *
 * The main method is the entry point of the application,
 * which is invoked by the SpringApplication.run method to start the application.
 */

// BEGIN_UPDATE_1
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@Configuration
public class SampleActuatorApplication {

    @Resource
    private ServiceProperties serviceProperties;

    @PostConstruct
    public void initialize() {
        // Initialization logic here
    }

    @PreDestroy
    public void shutdown() {
        // Shutdown logic here
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

    public static void configureVariables(Map<String, String> properties) {
        // Configuration logic here
    }

}
// END_UPDATE_1
/*
 * Javadoc:
 *
 * SampleActuatorApplication is the main entry point of the sample actuator application.
 * It is a Spring Boot application that uses the SpringBootApplication annotation
 * to indicate that it is a bootstrappable Spring application.
 * The application is configured to enable properties from the ServiceProperties class.
 * It contains a single health indicator bean, helloHealthIndicator,
 * which returns a Health object with a status of UP and a detail "hello" with value "world".
 *
 * The main method is the entry point of the application,
 * which is invoked by the SpringApplication.run method to start the application.
 * The @Resource annotation is used to inject the ServiceProperties instance.
 * The @PostConstruct annotation is used to mark a method annotated with it
 * as being called after the Spring container has finished initializing its beans.
 * The @PreDestroy annotation is used to mark a method annotated with it
 * as being called before the Spring container has finished destroying its beans.
 * The configureVariables method is used to configure application properties.
 */