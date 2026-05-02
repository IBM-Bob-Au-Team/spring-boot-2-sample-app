
Here is the updated Java file:

```java
package sample.actuator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@Validated
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @Size(min = 1, message = "Name must not be empty")
    @NotEmpty(message = "Name cannot be null")
    private String name = "World";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```