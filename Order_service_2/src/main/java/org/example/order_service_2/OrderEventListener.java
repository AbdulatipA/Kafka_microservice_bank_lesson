package org.example.order_service_2;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderEventListener {
    private final OrderService orderService;

    @KafkaListener(
            topics = "order-saved-events",
            groupId = "order_service_2_group")
    public void handlerOrderSavedEvent(OrderSavedEvent orderSavedEvent) {
        orderService.savingAnOrder(orderSavedEvent);
        log.info("Событие OrderSavedEvent получено, заказ сохранен");
    }
}
