
Updated Java file for Spring Boot 3.x:

```java
package sample.actuator;

import jakarta.stereotype.Service;

/**
 * Provides a simple HelloWorld service.
 */
@Service
public class HelloWorldService {

    /**
     * Returns a hello message.
     *
     * @return a hello message
     */
    public String getHelloMessage() {
        return "Spring boot says hello from a Docker container";
    }
}
```