FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Logger_service-0.0.1-SNAPSHOT.jar app/loggerService.jar

ENTRYPOINT ["java", "-jar", "app/loggerService.jar"]
