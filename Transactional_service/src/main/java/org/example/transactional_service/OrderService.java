package org.example.transactional_service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.transactional_service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Data
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;

    @Transactional
    public Order orderSave(OrderCreatedEvent orderCreatedEvent) {
        Order order = new Order();

        order.setUserId(orderCreatedEvent.getUserId());
        order.setTotalAmount(orderCreatedEvent.getTotalAmount());
        order.setOrderItems(orderCreatedEvent.getOrderItems());

        return orderRepository.save(order);
    }

    public Order findById(long id) {
        return orderRepository.findOrderWithItems(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с id: '%s' не найден".formatted(id))
        );
    }

    public void delete(long id) {
        orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Пользователь с id: '%s' не найден".formatted(id)));
        orderRepository.deleteById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAllWithOrderItems();
    }
}