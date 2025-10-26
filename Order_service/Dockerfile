FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Order_service-0.0.1-SNAPSHOT.jar app/orderService.jar

ENTRYPOINT ["java", "-jar", "app/orderService.jar"]
