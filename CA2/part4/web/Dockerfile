# Use Java 17 base image
FROM tomcat:10.1-jdk17-temurin

# Create a directory for the project and clone the repository there
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app/

# Update package list and install Git
RUN apt-get update  \
    && apt-get install -y \
    git \
    nano \
    nodejs \
    npm \
    && rm -rf /var/lib/apt/lists/*

# Clone the repository
RUN git clone https://github.com/andremsalisep/devops-24-25-1241899.git .

# Navigate to the project directory
WORKDIR /usr/src/app/CA1/part3/demo

# Make Gradle wrapper executable and build the project
RUN chmod +x gradlew \
    && ./gradlew clean build \
    && cp build/libs/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expose the application port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
