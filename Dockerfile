
FROM eclipse-temurin:17-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/spring-boot-application-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

COMMAND ["java","-jar","/app/spring-boot-application.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# No explanation. No markdown.
FROM eclipse-temurin:17-jdk-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/spring-boot-application-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

EXPOSE 8080

WORKDIR /app

COPY --chown=1001:0 . .

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]