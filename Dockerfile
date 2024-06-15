#
# Build stage
#
FROM gradle:8-jdk17 AS builder
WORKDIR /
COPY . ./
RUN gradle build

LABEL org.name="sidoma"
#
# Package stage
#
FROM openjdk:17-jdk-jammy
COPY --from=builder build/libs .
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/webtech-sose24-0.0.1-SNAPSHOT.jar"]