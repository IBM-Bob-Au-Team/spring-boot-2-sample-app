
```

```java
package sample.actuator;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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
	 * Returns a JSON response containing a sample hello message.
	 *
	 * @return a JSON map with a single key "message" and value from HelloWorldService
	 */
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> hello() {
		return Collections.singletonMap("message",
				this.helloWorldService.getHelloMessage());
	}

	/**
	 * Processes a POST request to generate a personalized JSON response.
	 *
	 * @param message a validated, non-empty user-provided message
	 * @return a JSON map with keys "message", "title", and "date"
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
	 * An example method for handling a request to "/foo", which throws an exception.
	 *
	 * @return an unwanted server error response
	 * @throws IllegalArgumentException in case of an unexpected processing error
	 */
	@RequestMapping("/foo")
	@ResponseBody
	public String foo() {
		throw new IllegalArgumentException("Server error");
	}

	protected static class Message {

		@NotBlank(message = "Message value cannot be empty")
		private String value;

		/**
		 * Gets the value of the user-provided message.
		 *
		 * @return the message value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Sets the value of the user-provided message.
		 *
		 * @param value the new message value
		 */
		public void setValue(String value) {
			this.value = Objects::requireNonNull;
		}
	}

}
```