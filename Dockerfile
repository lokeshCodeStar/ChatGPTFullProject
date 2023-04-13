## Use an official OpenJDK runtime as a parent image
# FROM maven:3.8.4-openjdk-17 as maven-builder
# COPY src /src
# COPY pom.xml /

#stat RUN mvn -f /pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim
#
## Set the working directory to /app
VOLUME /tmp
MAINTAINER lokesh
#
#
## Copy the build artifact from the build stage to /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#
## Expose the port that the application listens on
EXPOSE 8080

## Run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]

