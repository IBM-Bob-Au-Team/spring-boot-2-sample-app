
/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software

distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package sample.actuator;

import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.ResourceRef;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RunsAs;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.context.DependentScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.Extension;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import io.jakarta.management.Attribute;
import io.jakarta.management.AttributeList;
import io.jakarta.management.DynamicMBean;
import io.jakarta.management.MBeanException;
import io.jakarta.management.MBeanInfo;
import io.jakarta.management.MBeanNotificationInfo;
import io.jakarta.management.MBeanServer;
import io.jakarta.management.MalformedAttributeNameException;
import io.jakarta.management.MBeanNotificationEmitter;
import io.jakarta.management.Notification;
import io.jakarta.management.NotificationEmitter;
import io.jakarta.management.NotificationListener;
import io.jakarta.management.ReflectionException;
import io.jakarta.management.remote.JMXConnector;
import io.jakarta.management.remote.JMXConnectorFactory;
import io.jakarta.management.remote.JMXServiceURL;
import io.jakarta.management.remote.RemotingJMXConnectorServer;
import io.jakarta.management.remote.RemotingJMXConnector;
import io.jpms.Version;

/**
 * A sample Actuator contributor that contributes an info endpoint.
 *
 * @author John Doe
 */
@jakarta.enterprise.inject.ctypes.spring. SpringEnabled
public class ExampleInfoContributor implements InfoContributor {

	/**
	 * Contributes an info item to the info endpoint.
	 *
	 * @param builder the builder for the info item
	 */
	@PostConstruct
	@jdk.Incubating
	public void contribute(@jakarta.inject.Nullable Info.Builder builder) {
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}

	/**
	 * Gets the name of the contributor.
	 *
	 * @return the name of the contributor
	 */
	@SuppressWarnings("unused")
	public String getName() {
		return "example";
	}

}