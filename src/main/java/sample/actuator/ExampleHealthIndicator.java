
/*
 * For Spring Boot 3.x:
 */

package sample.actuator;

import jakarta.annotation.Nullable;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("sample.actuator")
@ConfigurationProperties(prefix = "health.example")
public class ExampleHealthIndicator implements HealthIndicator {

    @PositiveOrZero
    public Integer getCounter() {
        return 42;
    }

    @Nullable
    @Override
    public Health health() {
        return Health.up().withDetail("counter", getCounter()).build();
    }
}

/*
 * For Spring Boot 3.x with Javadoc annotations:
 */

package sample.actuator;

import jakarta.annotation.Nullable;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Example health indicator for Spring Boot Actuator.
 */
@Configuration
@ComponentScan("sample.actuator")
@ConfigurationProperties(prefix = "health.example")
public class ExampleHealthIndicator implements HealthIndicator {

    /**
     * Returns the counter value.
     * @return The counter value.
     */
    @PositiveOrZero
    public Integer getCounter() {
        return 42;
    }

    /**
     * Returns the health status with a detailed counter value.
     * @return The health status with a detailed counter value.
     */
    @Nullable
    @Override
    public Health health() {
        return Health.up().withDetail("counter", getCounter()).build();
    }
}