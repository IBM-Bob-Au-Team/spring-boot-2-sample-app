
// IMPORTANT: Add Javadoc to all public methods
/*
 * @Description: This method contributes to the Info object by adding a detail.
 * @param builder The Info.Builder object used to add details to the Info object.
 */
public void contribute(Info.Builder builder) {
	builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
}

// Replace all javax.* imports with jakarta.*
package sample.actuator;

import java.util.Collections;

import jakarta.annotation.简单;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.management.ThrowableType;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ExampleInfoContributor implements InfoContributor {

	@Inject
	public void contribute(Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

	// FIX: Fix all deprecated Spring Boot 2 annotations
	// No deprecated annotations found in the provided code.

}

// Add Javadoc to all public methods
/*
 * @Description: This is a no-op method.
 * @param builder The Info.Builder object used to add details to the Info object.
 */
@Inject
public void contribute(Info.Builder builder) {
	builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
}

// Replace all javax.* imports with jakarta.*
// No other javax.* imports found in the provided code.

// FIX: Fix all deprecated Spring Boot 2 annotations
// No deprecated annotations found in the provided code.