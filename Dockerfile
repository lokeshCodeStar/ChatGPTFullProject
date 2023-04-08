## Use an official OpenJDK runtime as a parent image
#FROM adoptopenjdk/openjdk11:alpine-jre
#
## Set the working directory to /app
#MAINTAINER lokesh
#
#
## Copy the build artifact from the build stage to /app
#COPY target/DemoChatGptApp-0.0.1-SNAPSHOT.jar /app
#
## Expose the port that the application listens on
#EXPOSE 8080
#
## Run the application when the container starts
#CMD ["java", "-jar", "/app.jar"]

FROM eclipse-temurin:17-jdk-alpine AS builder
# smoke test to verify if java is available
RUN java -version

COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/
RUN set -Eeux \
    && apk --no-cache add maven \
    # smoke test to verify if maven is available
    && mvn --version
RUN mvn package

# Stage 2 (to create a downsized "container executable", ~180MB)
FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add ca-certificates
WORKDIR /root/
COPY --from=builder /usr/src/myapp/target/app.jar .

EXPOSE 8123
ENTRYPOINT ["java", "-jar", "./app.jar"]