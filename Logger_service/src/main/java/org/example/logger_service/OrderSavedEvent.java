package org.example.logger_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSavedEvent {
    private long id;
    private long userId;
    private double totalAmount;
    private List<OrderItem> orderItems;

    @Override
    public String toString() {
        return "OrderSavedEvent: " + '\n' +
                "id = " + id + '\n' +
                "userId = " + userId + '\n' +
                "totalAmount = " + totalAmount + '\n' +
                "orderItems = " + orderItems;
    }
}
