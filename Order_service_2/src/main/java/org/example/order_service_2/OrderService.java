package org.example.order_service_2;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private final String serviceName = "order_service-2";

    @Transactional
    public String create(Order order) {
        publishOrderCreatedEvent(String.valueOf(order.getId()), order);
        log.info("Событие OrderCreatedEvent отправлено в топик order-events");
        return "Заказ создан";
    }

    public void publishOrderCreatedEvent(String orderId, Order order){
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();

        orderCreatedEvent.setOrderId(order.getId());
        orderCreatedEvent.setUserId(order.getUserId());
        orderCreatedEvent.setOrderItems(order.getOrderItems());
        orderCreatedEvent.setTimestamp(LocalDateTime.now());
        orderCreatedEvent.setStatus("в работе");
        orderCreatedEvent.setServiceName(serviceName);
        orderCreatedEvent.setTotalAmount(order.getTotalAmount());

//        kafkaTemplate.send("order-events", orderId, orderCreatedEvent);

        kafkaTemplate.executeInTransaction(t -> {
            t.send("order-events", orderCreatedEvent);
            return null;
        });

        log.info("Событие OrderCreatedEvent отправляется в топик order-events");
    }
}
