
```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Sample Actuator configuration for health endpoint.
 */
@Configuration
public class SampleActuatorConfig {

	@Autowired
	private SampleService sampleService;

	@PostConstruct
	public void init() {
		// initialization code
	}

	@Bean
	@ConditionalOnMissingBean
	public SampleHealthIndicator sampleHealthIndicator() {
		return new SampleHealthIndicator(sampleService);
	}

	@Resource
	private ServletContext servletContext;

	@Bean
	public HealthIndicator healthyHeaderHealthIndicator() {
		return request -> {
			try {
				HttpServletRequest request = RequestContextHolder.currentRequestAttributes().getRequest();
				HttpServletResponse response = ((ServletRequestAttributes) request).getResponse();
				response.addHeader("X-Health-Status", Status.UP.name());
				return Health.up().build();
			} catch (Exception e) {
				return Health.down().withDetail("error", e.getMessage()).build();
			}
		};
	}

}

```

```java
package sample.actuator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample servlet for health check.
 */
@WebServlet("/health")
public class HealthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(HealthServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setStatus(200);
		Health health = sampleService.getHealth();
		resp.getWriter().write("{\n" +
				"  \"status\": \"" + health.getStatus().name() + "\",\n" +
				"  \"details\": " + health. ToJson() + "\n" +
				"}");
	}

}

```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Sample health indicator.
 */
@Component
public class SampleHealthIndicator implements HealthIndicator {

	private final SampleService sampleService;

	@Autowired
	public SampleHealthIndicator(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@PostConstruct
	public void init() {
		// initialization code
	}

	@Override
	public Health health() {
		Health.Builder builder = Health.up();
		// add details here
		return builder.build();
	}

}

```

```java
package sample.actuator;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Sample health indicator.
 */
@Component
public class HealthIndicatorService implements HealthIndicator {

	@Autowired
	private SampleService sampleService;

	@Override
	public Health health() {
		Health.Builder builder = Health.up();
		// add details here
		return builder.build();
	}

}

```

```java
package sample.actuator;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Sample health indicator.
 */
@Component
public class AnotherHealthIndic