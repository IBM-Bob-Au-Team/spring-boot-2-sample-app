
```

```java
//////////////////////////////////////////////////////////////////////////////
// Copyright 2012-2021 the original author or authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//////////////////////////////////////////////////////////////////////////////

package sample.actuator;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.resource.Resource;
import jakarta.annotation.resource.ResourceRef;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A sample {@link InfoContributor} that contributes a piece of information.
 */
@Configuration
@ConditionalOnMissingBean(InfoContributor.class)
public class ExampleInfoContributor implements InfoContributor {

	@PostConstruct
	public void init() {
	}

	@PreDestroy
	public void close() {
	}

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

	@Nonnull
	@Override
	public String toString() {
		return "ExampleInfoContributor";
	}
}
```