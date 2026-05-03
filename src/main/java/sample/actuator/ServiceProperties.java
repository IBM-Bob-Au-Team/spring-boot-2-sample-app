
/*
 * Javadoc for the class:
 *
 * Class ServiceProperties is used to store properties for a service.
 * It is configured using the prefix "service" and does not ignore unknown properties.
 *
 * Javadoc for the method getName:
 *
 * This method returns the name of the service.
 *
 * Javadoc for the method setName:
 *
 * This method sets the name of the service.
 */

```java
/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.annotation. mgos.ConfigurationProperties;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @Size(min = 1, max = 100, message = "{service.name.size}")
    @NotBlank(message = "{service.name.blank}")
    private String name = "World";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/*
 * Javadoc for the class:
 *
 * Class ServiceProperties is used to store properties for a service.
 * It is configured using the prefix "service" and does not ignore unknown properties.
 *
 * Javadoc for the method getName:
 *
 * This method returns the name of the service.
 *
 * Javadoc for the method setName:
 *
 * This method sets the name of the service.
 */
```