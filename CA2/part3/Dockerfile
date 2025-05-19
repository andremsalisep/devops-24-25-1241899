# Use a Gradle image with JDK 17 to build the application
 FROM gradle:jdk17 AS builder

 # Set the working directory for the build
 WORKDIR /CA2/Part3/

 # Clone the repository
 RUN git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git

 # Set the working directory to the cloned repository
 WORKDIR /CA2/Part3/gradle_basic_demo

 # Ensure the Gradle wrapper has the correct permissions
 RUN chmod +x gradlew

 # Build the application
 RUN ./gradlew build

 # Use a slim JRE image for the runtime
 FROM eclipse-temurin:17-jre

 # Set the working directory
 WORKDIR /app

 # Copy the built JAR file from the builder stage
 COPY --from=builder /CA2/Part3/gradle_basic_demo/build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

 # Expose the port the server will run on
 EXPOSE 59001

 # Set the entry point to run the server
 ENTRYPOINT ["java", "-cp", "/app/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]