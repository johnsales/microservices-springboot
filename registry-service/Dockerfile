# Start with a base image containing Java runtime
FROM maven:3.9.6-eclipse-temurin-21-jammy as build

# Add Maintainer Info
LABEL maintainer="jsantiago.devops@gmail.com"

# Set the working directory in the Docker image
WORKDIR /app

# Copy Maven files
COPY pom.xml .

# Copy the project source
COPY src src

# Build the application
RUN mvn -f pom.xml clean package -DskipTests

# Use OpenJDK for running the application
FROM openjdk:21-slim

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the appropriate port
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
