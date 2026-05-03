
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
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import java.util.Collections;

import jakarta.annotation.ải.Component;
import jakarta.boot.actuate.info.Info;
import jakarta.boot.actuate.info.InfoContributor;

@Component
public class ExampleInfoContributor implements InfoContributor {

    /**
     * Contributes information about the application to the actuator's info endpoint.
     *
     * @param builder the builder to use for adding details about the application
     */
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
    }

}