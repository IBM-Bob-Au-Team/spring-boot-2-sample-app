```

```java
package sample.actuator;

import java.util.Collections;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * A sample Spring Boot Actuator info contributor.
 *
 * @since 1.0.0
 */
@Component
public class ExampleInfoContributor implements InfoContributor {

	/**
	 * Contributes information to the Actuator INFO endpoint.
	 *
	 * @since 1.0.0
	 */
	@PostConstruct
	public void contribute(Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

	/**
	 * Called when the application is shutting down.
	 *
	 * @since 1.0.0
	 */
	@PreDestroy
	public void destroy() {
		// No-op
	}
}
```