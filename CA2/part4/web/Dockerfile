# Use Java 17 base image
FROM tomcat:10.1-jdk17-temurin

# Install git
RUN apt-get update \
    && apt-get install -y \
    git \
    nano \
    nodejs \
    npm \
    && rm -rf /var/lib/apt/lists/*

# Create working directory
WORKDIR /usr/src/app

# Clone the repository
RUN git clone https://github.com/andremsalisep/devops-24-25-1241899.git .

# Navigate to the project directory
WORKDIR /usr/src/app/CA1/part3/demo

# Make Gradle wrapper executable and build the project
RUN chmod +x gradlew \
    && ./gradlew war \
    && cp build/libs/demo-0.0.1-SNAPSHOT-plain.war /usr/local/tomcat/webapps/demo-0.0.1-SNAPSHOT.war

# Expose the application port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
