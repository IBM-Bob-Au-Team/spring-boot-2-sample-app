
```

```java
package sample.actuator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties for the sample service.
 *
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 1, max = 100, message = "Name should be between 1 and 100 characters")
    private String name = "World";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name the name of the service
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the service.
     *
     * @return the name of the service
     */
    public String getName() {
        return this.name;
    }
}
```