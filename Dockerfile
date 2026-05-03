
#FROM eclipse-temurin:17-jdk-alpine
FROM eclipse-temurin:17-jdk-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/spring-boot-application.jar /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1