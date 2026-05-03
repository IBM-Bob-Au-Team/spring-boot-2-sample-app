
/*
 * JUnit 5 test codegen. Do not add any imports.
 */
package sample.actuator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class HelloWorldServiceTest {

	@Autowired
	private final HelloWorldService helloWorldService = new HelloWorldService();

	@Test
	void testHelloWorld() {
		String result = helloWorldService.getHelloMessage();
		assertThat(result).isEqualTo("Spring boot says hello from a Docker container");
	}

}

/*
 * End of file.
 */
```

```java
package sample.actuator;

import jakarta.annotation.Component;

@Component
public class HelloWorldService {

    /**
     * Returns a greeting message.
     *
     * @return String containing the greeting message.
     */
    public String getHelloMessage() {
        return "Spring boot says hello from a Docker container";
    }

}

/*
 * JUnit 5 test codegen. Do not add any imports.
 */
package sample.actuator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class HelloWorldServiceTest {

    @Autowired
    private final HelloWorldService helloWorldService = new HelloWorldService();

    @Test
    void testHelloWorld() {
        String result = helloWorldService.getHelloMessage();
        assertThat(result).isEqualTo("Spring boot says hello from a Docker container");
    }

}
```