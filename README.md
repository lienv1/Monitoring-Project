# Monitoring-Project
This project uses Spring Boot to simulate metrics, Prometheus for data collection, and Grafana for visualization. It includes an Alertmanager setup that notifies Slack when certain thresholds are exceeded.

![Diagram](https://raw.githubusercontent.com/lienv1/Monitoring-Project/main/Diagram.png?raw=true)

# Configuration
You can either use Slack or Email for notification

1. **Slack Notifications**:
Edit the slack_url file and insert your Slack webhook URL.

2. **Email Notifications**:
Use alertmanager-email.yml instead of alertmanager.yml to configure email notifications.

Choose the method that best fits your notification needs.

# Running as Docker Container with docker-compose
```
docker-compose -p monitor-project up -d
```
Grafana, Prometheus, and Alertmanager are accessible at http://localhost:3000, http://localhost:9090, and http://localhost:9093 respectively.

Use the requests in the api documentation to simulate the metrics.

# API Documentation

Access the Swagger API documentation at:
```
http://localhost:8080/swagger-ui/index.html
```
