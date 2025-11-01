package org.example.order_service_2;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.order_service_2.exceptions.NotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String serviceName = "order_service_2";

    public String create(Order order) {
        publishOrderCreatedEvent(order);
        log.info("Событие OrderCreatedEvent отправлено в топик order-events");
        return "Заказ создан";
    }

    public void publishOrderCreatedEvent(Order order){
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();

        orderCreatedEvent.setOrderId(order.getId());
        orderCreatedEvent.setUserId(order.getUserId());
        orderCreatedEvent.setOrderItems(order.getOrderItems());
        orderCreatedEvent.setTimestamp(LocalDateTime.now());
        orderCreatedEvent.setStatus("в работе");
        orderCreatedEvent.setServiceName(serviceName);
        orderCreatedEvent.setTotalAmount(order.getTotalAmount());

        kafkaTemplate.send("order-created-events", orderCreatedEvent);
        log.info("Событие отправленно в топик order-events: {}", orderCreatedEvent);
    }

    public Order findById(long id) {
        Order foudOrder = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с id: '%s' не найден".formatted(id))
                );

        return foudOrder;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order savingAnOrder(OrderSavedEvent orderSavedEvent) {
        Order order = new Order();

        order.setId(orderSavedEvent.getId());
        order.setUserId(orderSavedEvent.getUserId());
        order.setTotalAmount(orderSavedEvent.getTotalAmount());
        order.setOrderItems(orderSavedEvent.getOrderItems());

        return orderRepository.save(order);
    }
}
