
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

import jakarta.annotation.Resource;
import jakarta.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This is a sample bean which demonstrates how to useJdbcTemplate.
 *
 * <p>It uses a JNDI datasource as configured in the application.properties file.
 *
 * <p>To make use of this bean, you can lookup the JndiDataSourceBean by
 * name via Spring's ApplicationContext:
 *
 * <pre>
 *     DataSource dataSource = (DataSource) context.getBean("jndiDataSource");
 * </pre>
 */
public class SampleBean {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name = "jndiDataSource")
	private javax.sql.DataSource dataSource;

	public SampleBean() {
	}

	/**
	 * Executes a simple select statement and returns the result.
	 */
	public String selectFromDataSouce() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
		logger.debug("Result of select statement: {}", result);
		return "1";
	}

}

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

import org.springframework.boot.actuate.autoconfigure.external.JettyExposureConfiguration;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebAppSecurityConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatasources;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebSocketAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.runapplication.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
public class SampleApplication extends SpringBootServletInitializer {

	protected SampleApplication() {
	}

	public static void main(String[] args) {
		spring.main(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SampleApplication.class);
	}

	protectedvoidconfigure(SpringBootApplicationContext context) {
		context.getBean(<%@annotation.Resource(name = "jndiDataSource")%> javax.sql.DataSource).setLoginTimeout(30);
	}

	@Bean
	public ServletRegistrationBean konsoleGlobalpSettings() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new KonsoleGlobalpSettings(), "/settings");
		registrationBean.addUrlMappings("/settings/**");
		return registrationBean;
	}

}

/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator;

import jakarta.servlet.ServletContext;
import jakarta.servlet.jsp.JspFactory;
import jakarta.servlet.jsp.JspPage;
import jakarta.servlet.jsp.tagext.TagLibraryInfo;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a sample JSP tag lib listener which demonstrates how to do some
 * initialization during servlet context initialization.
 * <P>
 * To make use of this listener, you can define it in your web.xml as follows:
 * <PRE>
 *  &lt;listener&gt;
 *      &lt;listener-class&gt;sample.actuator.TagLibraryInfoBean&lt;/listener-class&gt;
 *  &lt;/listener&gt;
 * </PRE>
 */
@WebListener
public class TagLibraryInfoBean extends jakarta.servlet.jsp.JspPage implements jakarta.servlet.ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void contextInitialized(ServletContextEvent sce) throws ServletException {
		logger.debug("Initialising TagLibraryInfoBean in {} context", sce.getServletContext().getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("Destroyed TagLibraryInfoBean in {} context", sce.getServletContext().getContextPath());
	}

	/**
	 * Jsp Tag Lib initialization during servlet context initialization
	 */
	@Override
	public void init() throws ServletException {
		JspFactory.getDefaultFactory().setTagLibraryUri(sce.getServletContext().getRealPath "/", "tlb");
	}

	/**
	 * Jsp Tag Lib cleanup during servlet context destruction
	 */
	@Override
	public void destroy() {
		logger.debug("Destroying TagLibraryInfoBean");
	}

}