FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Transactional_service-0.0.1-SNAPSHOT.jar app/transactionalService.jar

ENTRYPOINT ["java", "-jar", "app/transactionalService.jar"]
