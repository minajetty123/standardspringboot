# Use Maven for build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy project files and build the application
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK for runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]