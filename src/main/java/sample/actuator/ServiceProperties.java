
/*
 * Copyright 2012-2022 the original author or authors.
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

import jakarta.validation.constraints.NotNull;

import jakarta.validation.Valid;

import jakarta.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

	/**
	 * Name of the service.
	 */
	@NotBlank
	@NotNull
	@Size(min = 1, max = 100)
	private String name = "World";

	/**
	 * Sets the name of the service.
	 *
	 * @param name the name of the service
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the service.
	 *
	 * @return the name of the service
	 */
	public String getName() {
		return this.name;
	}

}