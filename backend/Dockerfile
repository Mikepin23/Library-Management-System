# Use a Java runtime as a parent image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built jar (will be provided by Maven build)
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application (the entrypoint is overridden by docker-compose for wait-for-it)
ENTRYPOINT ["java", "-jar", "app.jar"]
