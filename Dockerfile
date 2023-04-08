## Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim
#
## Set the working directory to /app
MAINTAINER lokesh
#
#
## Copy the build artifact from the build stage to /app
WORKDIR /
COPY target/DemoChatGptApp-0.0.1-SNAPSHOT.jar /app.jar
#
## Expose the port that the application listens on
EXPOSE 8080

## Run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]

