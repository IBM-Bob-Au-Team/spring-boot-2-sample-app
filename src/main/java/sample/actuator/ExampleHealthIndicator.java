
/*
 *  Updated Java code:
 *
 *
 * package sample.actuator;
 *
 * import jakarta.annotation.PostConstruct;
 * import jakarta.annotation.PreDestroy;
 * import jakarta.annotation.Resource;
 * import jakarta.inject.Inject;
 * import jakarta.management.PagingEnumerator;
 * import jakarta.management.ObjectName;
 * import jakarta.management.ModelMBeanOperationInfo;
 * import jakarta.management.JpdaDebuggerConnector;
 *
 * import org.springframework.boot.actuate.health.Health;
 * import org.springframework.boot.actuate.health.HealthIndicator;
 * import org.springframework.boot.actuate.health.composite.CompositeHealthIndicator;
 * import org.springframework.boot.actuate.health.AbstractHealthIndicator;
 * import org.springframework.beans.factory.annotation.Value;
 * import org.springframework.stereotype.Component;
 *
 * @Component
 * public class ExampleHealthIndicator extends AbstractHealthIndicator {
 *
 *     private final int counter;
 *
 *     @Inject
 *     public ExampleHealthIndicator(@Value("${counter:42}") int counter) {
 *         this.counter = counter;
 *     }
 *
 *     @PostConstruct
 *     public void init() {
 *         // initialization code
 *     }
 *
 *     @PreDestroy
 *     public void destroy() {
 *         // cleanup code
 *     }
 *
 *     @Override
 *     protected Health doHealthCheck() {
 *         return Health.status(getStatus()).withDetail("counter", counter).build();
 *     }
 *
 *     public void setCounter(int counter) {
 *         this.counter = counter;
 *     }
 *
 *     public int getCounter() {
 *         return counter;
 *     }
 *
 *     public void setController(Health.Builder builder) {
 *         builder.status(getStatus()).detail("counter", counter);
 *     }
 *
 *     @Override
 *     public String getDescription() {
 *         return "Example health indicator";
 *     }
 * }
 */