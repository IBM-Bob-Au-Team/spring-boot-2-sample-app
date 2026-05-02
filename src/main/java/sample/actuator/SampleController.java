
```

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
	 * Handles GET requests for the root URL ("/") and returns a JSON object
	 * containing a "message" key with the value returned by the {@link
	 * HelloWorldService#getHelloMessage()} method.
	 *
	 * @return a JSON object containing a "message" key
	 */
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> hello() {
		return Collections.singletonMap("message",
				this.helloWorldService.getHelloMessage());
	}

	/**
	 * Handles POST requests for the root URL ("/") and returns a JSON object
	 * containing "message", "title", and "date" keys. The "message" key contains
	 * the value of the {@code value} field from the request body, the "title" key
	 * contains the string "Hello Home", and the "date" key contains the current
	 * date and time.
	 *
	 * @param message an object containing a "value" field
	 * @return a JSON object containing "message", "title", and "date" keys
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
	 * Handles GET requests for the "/foo" URL and throws an {@link
	 * IllegalArgumentException} with the message "Server error".
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
		 * Gets the value of the "value" field in the {@code Message} object.
		 *
		 * @return the value of the "value" field
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * Sets the value of the "value" field in the {@code Message} object.
		 *
		 * @param value the new value for the "value" field
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

}
```