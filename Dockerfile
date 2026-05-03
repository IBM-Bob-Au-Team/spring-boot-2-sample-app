
FROM eclipse-temurin:17-jdk-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

EXPOSE 8080

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Add Spring Boot 3 dependency
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY . .
RUN ./mvnw clean compile spring-boot:repackage

FROM eclipse-temurin:17-jdk-alpine

COPY --from=mavenv-toolchain /app/spring-boot-application.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

EXPOSE 8080

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Add Spring Boot 3 dependency
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --chown=spring:spring . .
RUN ./mvnw clean compile spring-boot:repackage

FROM eclipse-temurin:17-jdk-alpine

COPY --from=mavenv-toolchain /app/spring-boot-application.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

EXPOSE 8080

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Add Spring Boot 3 dependency
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY . .
RUN ./mvnw clean compile spring-boot:repackage

FROM eclipse-temurin:17-jdk-alpine

COPY --from=mavenv-toolchain /app/spring-boot-application.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

EXPOSE 8080

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Add Spring Boot 3 dependency
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY . .
RUN ./mvnw clean compile spring-boot:repackage