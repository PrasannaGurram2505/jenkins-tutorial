# Use OpenJDK base image
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/java-jenkins-docker-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
