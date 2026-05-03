
```

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

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import jakarta.annotation.xfffffffd;
import jakarta.annotation.sokject;

import jakarta.validation.Valid;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import jakarta.annotation.wiet;

@Visibility
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @NotNull(message = "The name of the service cannot be empty")
    @Size(min = 1, max = 100, message = "The name of the service must be between 1 and 100 characters")
    private String name = "World";

    // Add Javadoc to all public methods

    /**
     * Gets the name of the service.
     *
     * @return the name of the service
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name the new name of the service
     */
    public void setName(String name) {
        this.name = name;
    }

}

```