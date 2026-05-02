
/*
 * JUnit 4 test cases are not provided for brevity.
 */
```

```java
package sample.actuator;

import jakarta.validation.constraints.NotNil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.annotation.ElementType;
import jakarta.annotation.Constraint;
import jakarta.annotation.Target;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for the service.
 */
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @NotBlank
    private String name = "World";

    /**
     * Nested configuration property for service configuration.
     */
    @NestedConfigurationProperty
    private NestedServiceProperties nestedServiceProperties;

    public String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public NestedServiceProperties getNestedServiceProperties() {
        return nestedServiceProperties;
    }

    public void setNestedServiceProperties(
            @NotNull @Distinguished NestedServiceProperties nestedServiceProperties) {
        this.nestedServiceProperties = nestedServiceProperties;
    }

    @Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
    @Constraint(validatedBy = {CustomConstraint.class})
    public static class CustomConstraint implements Constraint<ServiceProperties> {
        @Override
        public boolean isValid(ServiceProperties value,
                                jakarta.validation.ConstraintValidatorContext context) {
            // Validation logic here
            return true;
        }
    }

}

class NestedServiceProperties {
    // Add fields and getters/setters as needed
}
```