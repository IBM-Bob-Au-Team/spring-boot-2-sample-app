
/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
/*

```java
package sample.actuator;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;

import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Description("A controller for handling requests for hello messages")
public class SampleController {

	private final HelloWorldService helloWorldService;

	public SampleController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	/**
	 * Returns a JSON response containing a hello message.
	 *
	 * @return a JSON response containing a hello message.
	 */
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> hello() {
		return Collections.singletonMap("message",
				this.helloWorldService.getHelloMessage());
	}

	/**
	 * Handles POST requests for hello messages and returns a JSON response.
	 *
	 * @param message the message to be processed
	 * @return a JSON response containing the message value, title, and date
	 */
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> olleh(@Validated Message message) {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("message", message.getValue());
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return model;
	}

	/**
	 * Returns a JSON response with a server error.
	 *
	 * @return a JSON response with a server error.
	 */
	@RequestMapping("/foo")
	@ResponseBody
	public String foo() {
		throw new IllegalArgumentException("Server error");
	}

	protected static class Message {

		/**
		 * Ensures that the message value is not null or empty.
		 *
		 * @param value the message value
		 * @return this object (for method chaining)
		 */
		@NotBlank(message = "Message value cannot be empty")
		private String value;

		/**
		 * Returns the message value.
		 *
		 * @return the message value
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Sets the message value.
		 *
		 * @param value the message value
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

}
```