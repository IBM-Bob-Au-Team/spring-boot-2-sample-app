
# Updated Dockerfile
FROM eclipse-temurin:17-jdk-alpine

COPY pom.xml /tmp/
RUN mvn -B dependency:go-offline -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package

ENV SPRING_PROFILES_ACTIVE="docker"
ENV JAVA_OPTS="-XX:MaxRAMPercentage=80 -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080

RUN mkdir /app
COPY --from=0 /tmp/target/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Xmx512m","-Xms256m","-XX:NewSize=128m","-XX:MaxNewSize=128m","-XX:SurvivorRatio=8","-XX:+UseParallelGC","-XX:+UseStringDeduplication","-jar","/app/spring-boot-application.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1