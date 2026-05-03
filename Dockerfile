
FROM eclipse-temurin:17-jdk-alpine

COPY --from=0 /app /app

COPY --from=MAVEN_TOOL_CHAIN /usr/share/maven/ /usr/share/maven/

WORKDIR /app
RUN feature:full-release

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1