# Printing Application

This is a Spring Boot based application for printing service POC that provides.
- Dockerization current printing service via docker and docker-compose
- Deploy the target application into K8S via Helm template
- Implement the communication between printing service and other serivces, such as mtext under same K8S cluster
- Integrating other data model via openAPI to make sure all of interfaces works as expected
  
## Features
- Built with Spring Boot 3.2.0
- REST API with `/api/healthz` endpoint
- Dockerized with `Dockerfile` and `docker-compose.yml`
- Configurable via `application.properties`
- Maven-based build system

## Project Structure
```
.
├── src/main/java/com/verti/printing
│   ├── PrintingApplication.java
│   ├── controller
│   │   ├── *.java //relevant to controller java classes
│   ├── service
│   │   ├── *.java //relevant to service java classes
├── src/main/resources
│   ├── application.properties
├── pom.xml
├── Dockerfile
├── docker-compose.yml
```

## Requirements
- Java 17+
- Maven 3+
- Docker (for containerized deployment)

## Getting Started

#### Using Maven
```sh
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

#### Running with Spring Boot
```sh
mvn spring-boot:run
```

The service will be available at:  
```
http://localhost:8080
```

### 3. API Endpoints

| Method | Endpoint        | Description            |
|--------|---------------|------------------------|
| GET    | `/api/healthz` | Health check endpoint |

Test with:
```sh
curl http://localhost:8080/api/healthz
```

### 4. Running with Docker
#### Build and Run the Container
```sh
docker build -t printing-app .
docker run -p 8080:8080 printing-app
```

#### Using Docker Compose
```sh
docker-compose up -d
```

### 5. Configuration
Modify `src/main/resources/application.properties` to adjust the application settings:

```properties
server.port=8080
spring.application.name=springboot-standard
```

### 6. Running openAPI via springdoc

```properties
shttp://localhost:8080/swagger-ui.html
http://localhost:8080/v3/api-docs
```
