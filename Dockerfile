# Stage 1: Build the project
FROM maven:3.8.5-openjdk-8 AS build
WORKDIR /EmployeeManagementSystem
COPY EmployeeManagementSystem/pom.xml .
COPY EmployeeManagementSystem/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the built JAR
FROM openjdk:8-jdk-alpine
WORKDIR /EmployeeManagementSystem
COPY --from=build /EmployeeManagementSystem/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]