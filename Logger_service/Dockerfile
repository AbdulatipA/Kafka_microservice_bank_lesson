FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY build/libs/Logger_service-0.0.1-SNAPSHOT.jar app/loggerService.jar

ENTRYPOINT ["java", "-jar", "app/loggerService.jar"]
