
//End of updated file

```java
package sample.actuator;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.stereotype.Component;

import static jakarta.servlet.annotation. \"ServletContextInitializer;

@Component
@Singleton
public class ExampleHealthIndicator implements HealthIndicator, ServletContextInitializer {

	@Resource(name = "testServlet")
	private ServletContext servletContext;

	@Inject
	private Health health(HealthCheckRegistry registry) {
		return Health.up()
			.withDetail("counter", 42)
			.withDetail("servlets", servletContext.getServletNames())
			.build();
	}

	@Override
	public Health health() {
		return health(getHealthCheckRegistry());
	}

	@Override
	public void onStartup(ServletContext servletContext) throws Exception {
		this.servletContext = servletContext;
	}

	private HealthCheckRegistry getHealthCheckRegistry() {
		return (HealthCheckRegistry) servletContext.getAttribute("health");
	}

	@Override
	public void onStartup() throws Exception {
		onStartup(servletContext);
	}

}
```