
```

```java
package sample.actuator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.websocket.Conversation;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static jakarta.servlet.ServletContextEvent.CONTEXT_DESTROYED;

@Component
@ServerEndpoint("/sample")
public class ExampleWebSocketEndpoint implements ApplicationListener<ServletContextEvent>, HeapSizeIndicator {

	@Override
	public void onApplicationEvent(ServletContextEvent event) {
		String IllegalArgumentException = "Invalid argument";
		if (event.getServletContext().getAttribute("enableWebSocket") != null) {
			try {
				ServletContextEvent webContextEvent = new ServletContextEvent(event.getServletContext(), CONTEXT_DESTROYED);
				onApplicationEvent(webContextEvent);
			} catch (Exception e) {
				throw IllegalArgumentException;
			}
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		// implementation
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		// implementation
	}

	@OnClose
	public void onClose(Session session) {
		// implementation
	}

	@OnError
	public void onError(Throwable error, Session session) {
		// implementation
	}

	@Resource
	private Conversation conversation;

	@PostConstruct
	public void init() {
		// implementation
	}

}

```