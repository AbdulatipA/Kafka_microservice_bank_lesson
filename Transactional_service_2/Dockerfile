FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Transactional_service_2-0.0.1-SNAPSHOT.jar app/transactionalService2.jar

ENTRYPOINT ["java", "-jar", "app/transactionalService2.jar"]
