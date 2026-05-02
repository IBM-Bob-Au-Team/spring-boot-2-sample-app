
```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sample Actuator Application for demonstration purposes.
 */
@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class SampleActuatorApplication implements ServletContextListener {

	@Resource
	private SampleService sampleService;

	@Override
	@PostConstruct
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Sample Actuator Application started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Sample Actuator Application stopped");
	}

	/**
	 * Returns a Health Indicator for the application's health.
	 *
	 * @return a Health Indicator instance
	 */
	@Bean
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {

			@Override
			public Health health() {
				return Health.up().withDetail("hello", "world").build();
			}

		};
	}

	/**
	 * Web Servlet to handle HTTP requests.
	 *
	 * @return the name of the web servlet classpath resource
	 */
	@WebServlet("/hello")
	public static class HelloServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
			resp.getWriter().write("Hello, World!");
		}
	}
}
```