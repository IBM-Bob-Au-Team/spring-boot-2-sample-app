
FROM eclipse-temurin:17-jdk-alpine

ENV MAVEN_HOME /usr/lib/maven
ENV MAVEN_CONFIG /root/.m2
ENV PATH ${MAVEN_HOME}/bin:${PATH}

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/spring-boot-application-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1