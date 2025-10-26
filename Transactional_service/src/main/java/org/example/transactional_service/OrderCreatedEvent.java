package org.example.transactional_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
    private long orderId;
    private long userId;
    private List<OrderItem> orderItems;
    private String status;
    private LocalDateTime timestamp;
    private String serviceName;
    private double totalAmount;


    @Override
    public String toString() {
        return "OrderCreatedEvent: " + '\n' +
                "orderId = " + orderId + '\n' +
                "userId = " + userId + '\n' +
                "orderItems = " + orderItems + '\n' +
                "status = " + status + '\n' +
                "timestamp = " + timestamp + '\n' +
                "serviceName = " + serviceName + '\n' +
                "totalAmount = " + totalAmount;
    }
}
