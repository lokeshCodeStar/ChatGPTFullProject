# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory to /app
MAINTAINER baeldung.com


# Copy the build artifact from the build stage to /app
COPY target/DemoChatGptApp-0.0.1-SNAPSHOT.jar /app

# Expose the port that the application listens on
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "/app.jar"]
