# Use Java 17 base image
FROM eclipse-temurin:17-jdk-jammy

# Create working directory
WORKDIR /usr/src/app

# Install git
RUN apt-get update && apt-get install -y git

# Clone the repository
RUN git clone https://github.com/andremsalisep/devops-24-25-1241899.git .

# Navigate to the project directory
WORKDIR /usr/src/app/CA1/part3/demo

# Make Gradle wrapper executable and build the project
RUN chmod +x gradlew && ./gradlew build

# Expose the application port
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.war"]
