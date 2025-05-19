# Use a Gradle image with JDK 21 to build the application
FROM gradle:jdk21 AS builder

# Set the working directory
WORKDIR /app

# Copy the JAR file from the host machine to the Docker image
COPY gradle_basic_demo/build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

# Expose the port the server will run on
EXPOSE 59001

# Set the entry point to run the server
ENTRYPOINT ["java", "-cp", "/app/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]