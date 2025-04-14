# Use a Java 8 base image
FROM openjdk:8-jdk-alpine

# Copy the jar file into the container
COPY EmployeeManagementSystem/target/*.jar EmployeeManagementSystem-0.0.1.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "/EmployeeManagementSystem-0.0.1.jar"]