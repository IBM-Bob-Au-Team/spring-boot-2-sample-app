
/*
 * End of file
 */

```java
package sample.actuator;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints. SIZE;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Properties for the service.
 *
 * @see ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
 */
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@Validated
public class ServiceProperties {

	/**
	 * Name of the service.
	 *
	 * @see #setName(String)
	 * @see #getName()
	 */
	@NotNull(message = "The name must not be null")
	@SIZE(min = 1, message = "The name must not be empty")
	private String name = "World";

	/**
	 * Sets the name of the service.
	 *
	 * @param name The new name of the service.
	 * @see #getName()
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the service.
	 *
	 * @return The name of the service.
	 * @see #setName(String)
	 */
	public String getName() {
		return this.name;
	}

}
```