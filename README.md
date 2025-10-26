# Урок microservice_bank_lesson

## задача
Работы с 2 kafka брокерами

## Требования к заданию
один сервис для логгирования данных
два order сервиса для отпрвки и создания заказов
один transactional сервис для сохранения данных в базу
2 брокера



### Сервисы

>[Logger_service (producer)](https://gitlab.com/ataev0461/my_docker-compose_lesson/-/tree/main/Person_service/src/main/java/org/example/person_service?ref_type=heads)

>[Order_service (consumer)](https://gitlab.com/ataev0461/my_docker-compose_lesson/-/tree/main/Group_service/src/main/java/org/example/group_service?ref_type=heads)

>[Order_service_2](https://gitlab.com/ataev0461/my_docker-compose_lesson/-/tree/main/Gateway_service/src/main/java/org/example/gateway_service?ref_type=heads)

>[Transactional_service](https://gitlab.com/ataev0461/my_docker-compose_lesson/-/tree/main/Gateway_service/src/main/java/org/example/gateway_service?ref_type=heads)


