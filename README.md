# Monitoring-Project
Simple project that uses Spring Boot to simulate metrics, Prometheus as data acquisition and Grafana to visualize the data.
# 1. Build Spring Boot API
For testing purpose, you don't need to build the project. Just use the default jar file.
To build the Spring Boot API, use Maven
```
mvn clean package
```
# 2. Build Docker
Build the API as Docker container
```
docker build -t springbootmetrics-image -f SpringBootMetrics/Dockerfile SpringBootMetrics
```
# Running as Docker Container with docker-compose
```
docker-compose -p monitor-project up -d
```
Grafana runs on http://localhost:3000 and Prometheus on http://localhost:9090

Use the requests in the api documentation to simulate the metrics.

# API Documentation

Access the Swagger API documentation at:
```
http://localhost:8080/swagger-ui/index.html
```
