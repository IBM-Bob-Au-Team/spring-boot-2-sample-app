
```java
package sample.actuator;

/**
 * This service provides a simple greeting message.
 */
@jakarta.annotation.Service
public class HelloWorldService {

    /**
     * Returns a greeting message.
     *
     * @return A greeting message.
     */
    public String getHelloMessage() {
        return "Spring boot says hello from a Docker container";
    }
}
```