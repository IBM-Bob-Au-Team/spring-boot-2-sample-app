
# Update Dockerfile for Spring Boot 3
FROM eclipse-temurin:17-jdk-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app/spring-boot-application.jar

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

# Add Spring Boot 3-specific dependencies if needed
# RUN mvn io.spring.dependency-management:dependency-management-plugin:2.1.1.RELEASE:goOffline

# Healthcheck for Spring Boot 3
HEALTHCHECK --interval=1m --timeout=3s --start-period=5s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Exclude unnecessary Maven artifacts
# FROM alpine
# RUN apk --no-cache add ca-certificates
# COPY --from=MAVEN_TOOLCHAIN /app/spring-boot-application.war /app/spring-boot-application.war
# EXPOSE 8080
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/spring-boot-application.war"]
# HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Update Dockerfile to use release version of Java 17
# FROM eclipse-temurin:17.0.1-jdk

# Ensure that the application runs with the latest security patches
# RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-17-eclipse-temurin/bin/java 100
# RUN java -XshowSettings:props -version

# Add a non-root user for security reasons and switch to it
# Argon4 is just an example; replace it with the actual desired user and group
ARG USER_NAME=argon4
ARG USER_UID=1001
ARG USER_GID=1001

RUN groupadd -g ${USER_GID} ${USER_NAME} && \
    useradd -u ${USER_UID} -g ${USER_GID} -d /home/${USER_NAME} -s /sbin/nologin ${USER_NAME} && \
    chown -R ${USER_NAME}:${USER_NAME} /app && \
    usermod -aG docker ${USER_NAME}

USER ${USER_NAME}

# Exclude unnecessary Maven artifacts
# FROM alpine
# RUN apk --no-cache add ca-certificates
# COPY --from=MAVEN_TOOLCHAIN /app/spring-boot-application.war /app/spring-boot-application.war
# EXPOSE 8080
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/spring-boot-application.war"]
# HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Update Dockerfile to use release version of Java 17
# FROM eclipse-temurin:17.0.1-jdk

# Ensure that the application runs with the latest security patches
# RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-17-eclipse-temurin/bin/java 100
# RUN java -XshowSettings:props -version

# Add a non-root user for security reasons and switch to it
# Argon4 is just an example; replace it with the actual desired user and group
ARG USER_NAME=argon4
ARG USER_UID=1001
ARG USER_GID=1001

RUN groupadd -g ${USER_GID} ${USER_NAME} && \
    useradd -u ${USER_UID} -g ${USER_GID} -d /home/${USER_NAME} -s /sbin/nologin ${USER_NAME} && \
    chown -R ${USER_NAME}:${USER_NAME} /app && \
    usermod -aG docker ${USER_NAME}

USER ${USER_NAME}

# Update Dockerfile for Spring Boot 3
FROM eclipse-temurin:17-jdk-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app/spring-boot-application.jar

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

# Add Spring Boot 3-specific dependencies if needed
# RUN mvn io.spring.dependency-management:dependency-management-plugin:2.1.1.RELEASE:goOffline

# Healthcheck for Spring Boot 3
HEALTHCHECK --interval=1m --timeout=3s --start-period=5s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Update Dockerfile to use release version of Java 17
# FROM eclipse-temurin:17.0.1-jdk

# Exclude unnecessary Maven artifacts
# FROM alpine
# RUN apk --no-cache add ca-directories
# COPY --from=MAVEN_TOOLCHAIN /app/spring-boot-application.war /app/spring-boot-application.war
# EXPOSE 8080
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/spring-boot-application.war"]
# HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

# Add a non-root user for security reasons and switch to it
# Argon4 is just an example; replace it with the actual desired user and group
ARG USER_NAME=argon4
ARG USER_UID=1001
ARG USER_GID=1001

RUN groupadd -g ${USER_GID} ${USER_NAME} && \
    useradd -u ${USER_UID} -g ${USER_GID} -d /home/${USER_NAME} -s /sbin/nologin ${USER_NAME} && \
    chown -R ${USER_NAME}:${USER_NAME} /app && \
    usermod -aG docker ${USER_NAME}

USER ${USER_NAME}

FROM eclipse-temurin:17-jdk-alpine