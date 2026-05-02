
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
 */

package sample.actuator;

import jakarta.annotation.PostConstruct;

@jakarta.annotation.Service
public class HelloWorldService {

	/**
	 * Returns a hello message from Spring Boot.
	 * @return the hello message
	 */
	@PostConstruct
	public String getHelloMessage() {
		return "Spring boot says hello from a Docker container";
	}

}
```