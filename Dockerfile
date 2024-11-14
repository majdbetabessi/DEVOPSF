# Use a base image with Maven and JDK pre-installed for Java projects
FROM maven:3.8.6-eclipse-temurin-17 as build

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the working directory
COPY . .

# Build the project using Maven
RUN mvn clean package

# Define the base runtime image with a JDK
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled files from the build stage
COPY --from=build /app /app

# Expose the application port (8081 as per your configuration)
EXPOSE 8081

# Define the default command to run the application
CMD ["java", "-jar", "target/tpfoyer.jar"]
