# Урок microservice_bank_lesson

## задача
Релизовать работу с двумя kafka брокерами

## Требования к заданию
- один сервис для логгирования данных
- два order сервиса для отпрвки и создания заказов
- один transactional сервис для сохранения данных в базу
- два брокера


### Сервисы

>[Logger_service (consumer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Logger_service/src/main/java/org/example/logger_service)

>[Order_service (producer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Order_service/src/main/java/org/example/order_service)

>[Order_service_2 (producer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Order_service_2/src/main/java/org/example/order_service_2)

>[Transactional_service (consumer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Transactional_service/src/main/java/org/example/transactional_service)


