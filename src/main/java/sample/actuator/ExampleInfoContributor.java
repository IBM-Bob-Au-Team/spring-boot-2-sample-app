
UPDATE:

/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
```java
/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.annotation.nonnull;
import jakarta.annotation.Nonnull;
import jakarta.annotation.concurrent.ThreadSafe;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * A contributor to the actuator's info endpoint.
 *
 * @since 3.0
 */
@Component
@ThreadSafe
public class ExampleInfoContributor implements InfoContributor {

	/**
	 * Contributes information about the application to the actuator's info endpoint.
	 * @param builder the builder for the info object
	 * @see Info
	 */
	@Override
	public void contribute(@NonNull Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

}
```