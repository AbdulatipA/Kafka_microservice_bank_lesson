FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Order_service_2-0.0.1-SNAPSHOT.jar app/orderService2.jar

ENTRYPOINT ["java", "-jar", "app/orderService2.jar"]
