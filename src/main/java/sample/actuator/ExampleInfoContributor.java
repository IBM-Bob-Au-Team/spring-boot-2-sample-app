```

```java
package sample.actuator;

import jakarta.annotation.NonNull;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

/**
 * Contributes an info endpoint that exposes some example data.
 */
@Singleton
public class ExampleInfoContributor implements InfoContributor {

	@Resource
	private SomeService someService;

	@Inject
	public ExampleInfoContributor(SomeService someService) {
		this.someService = someService;
	}

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

}
```