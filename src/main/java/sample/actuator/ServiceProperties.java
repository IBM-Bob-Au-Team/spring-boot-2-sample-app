
/*
 * End of file
 */

```java
package sample.actuator;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@Validated
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @NotBlank(message = "service.name.blank")
    @Size(min = 1, max = 50, message = "service.name.size")
    private String name = "World";

    /**
     * Generates the name of the service.
     *
     * @return the name of the service
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name the new name of the service
     */
    public void setName(String name) {
        this.name = name;
    }

}
```