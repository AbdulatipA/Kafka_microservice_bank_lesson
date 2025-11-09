# Урок microservice_bank_lesson

## Задача
Релизовать работу с двумя kafka брокерами. Создать дубликаты сервисов через docker-compose не копирую сервисы напрямую (через ctrl+c)

## Требования к заданию
- один сервис для логгирования данных
- три order сервиса для создания заказов
- три transactional сервис для сохранения заказов в бд
- три брокера


### Сервисы

>[Logger_service (consumer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Logger_service/src/main/java/org/example/logger_service)

>[Order_service (producer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Order_service/src/main/java/org/example/order_service)

>[Transactional_service (consumer)](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/tree/main/Transactional_service/src/main/java/org/example/transactional_service)

>[.env переменные окружения](https://github.com/AbdulatipA/Kafka_microservice_bank_lesson/blob/main/.env)



