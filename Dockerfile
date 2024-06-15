#
# Build stage
#
FROM gradle:8-jdk21 AS builder
WORKDIR /
COPY . ./
RUN gradle build --no-daemon

LABEL org.name="sidoma"
#
# Package stage
#
FROM openjdk:21-jdk-slim
COPY --from=builder build/libs .
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/webtech-sose24-0.0.1-SNAPSHOT.jar"]