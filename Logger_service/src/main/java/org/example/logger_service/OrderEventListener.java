package org.example.logger_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderEventListener {

    @KafkaListener(
            topics = "order-created-events",
            groupId = "logger_service_group")
    public void handlerOrderCreatedEvent(@Payload OrderCreatedEvent orderCreatedEvent, Acknowledgment ack) {
        log.info("Событие получено: " + orderCreatedEvent);
        ack.acknowledge();
    }

    @KafkaListener(
            topics = "order-saved-events",
            groupId = "logger_service_group")
    public void handlerOrderSavedEvent(@Payload OrderSavedEvent orderSavedEvent, Acknowledgment ack) {
        log.info("Событие получено: " + orderSavedEvent);
        ack.acknowledge();
    }
}
