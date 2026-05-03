
```

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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication {

    /**
     * Main entry point for the Spring Boot application.
     *
     * <p>
     * Runs the application on the command line using SpringApplication.
     *
     * @param args Command line arguments
     */
    @PostConstruct
    public void initialize(String[] args) {
        SpringApplication.run(SampleActuatorApplication.class, args);
    }

    /**
     * Pre-destruction callback for the Spring Boot application.
     */
    @PreDestroy
    public void shutdown() {
        // Perform any necessary cleanup tasks here.
    }

    /**
     * Indicates that the given resource should be injected into this component.
     *
     * @param resource The resource to be injected
     */
    @Resource
    private void bindResource(Object resource) {
        // Keep the reference to the resource.
    }

    /**
     * Creates a sample HealthIndicator bean.
     *
     * @return An instance of HealthIndicator implementing the health check functionality.
     */
    @Bean
    @ConditionalOnMissingBean
    public HealthIndicator helloHealthIndicator() {
        return new HealthIndicator() {

            /**
             * Returns the current health state of the application.
             *
             * @return The health state of the application.
             */
            @Override
            public Health health() {
                return Health.up().withDetail("hello", "world").build();
            }

        };
    }

}
```