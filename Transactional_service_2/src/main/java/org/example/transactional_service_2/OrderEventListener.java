package org.example.transactional_service_2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderEventListener {
    private final OrderService orderService;


    @KafkaListener(topics = "order-created-events", groupId = "transactional_service_group")
    public void handlerOrderCreatedEvent(@Payload OrderCreatedEvent orderCreatedEvent) {
        log.info("Событие OrderCreatedEvent получено, идет сохранение...");
        Order orderSaved = orderService.orderSave(orderCreatedEvent);
        log.info("Данные order_service сохранены в базу " + orderSaved);
    }
}
