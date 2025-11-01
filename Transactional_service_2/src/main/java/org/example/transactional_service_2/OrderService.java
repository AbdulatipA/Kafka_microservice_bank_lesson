package org.example.transactional_service_2;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Data
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional("transactionManager")
    public Order orderSave(OrderCreatedEvent orderCreatedEvent) {
        Order order = new Order();
        OrderSavedEvent orderSavedEvent = new OrderSavedEvent();

        order.setUserId(orderCreatedEvent.getUserId());
        order.setTotalAmount(orderCreatedEvent.getTotalAmount());
        order.setOrderItems(orderCreatedEvent.getOrderItems());

        Order orderSaved = orderRepository.save(order);

        publishOrderSavedEvent(orderSavedEvent, orderSaved);

        return orderSaved;
    }

    public void publishOrderSavedEvent(OrderSavedEvent orderSavedEvent, Order order) {
        orderSavedEvent.setId(order.getId());
        orderSavedEvent.setUserId(order.getUserId());
        orderSavedEvent.setTotalAmount(order.getTotalAmount());
        orderSavedEvent.setOrderItems(order.getOrderItems());


        kafkaTemplate.send("order-saved-events", orderSavedEvent);
    }
}