# Use the Liberica JDK 21 as the base image
FROM bellsoft/liberica-openjdk-alpine:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
