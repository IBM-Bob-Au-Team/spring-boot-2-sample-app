
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
@jakarta.annotation.Description("A controller for handling requests for hello messages")
public class SampleController {

	private final HelloWorldService helloWorldService;

	public SampleController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> hello() {
		String message = this.helloWorldService.getHelloMessage();
		return Collections.singletonMap("message", message);
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> olleh(@Validated Message message) {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("message", message.getValue());
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return model;
	}

	@RequestMapping("/foo")
	@ResponseBody
	public String foo() {
		throw new IllegalArgumentException("Server error");
	}

	protected static class Message {

		@NotBlank(message = "Message value cannot be empty")
		private String value;

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
```