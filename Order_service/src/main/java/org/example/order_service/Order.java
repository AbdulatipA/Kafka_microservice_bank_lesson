package org.example.order_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private long id;

    private long userId;
    private double totalAmount;
    @ElementCollection
    private List<OrderItem> orderItems;


    @Override
    public String toString() {
        return "Order: " + '\n' +
                "id = " + id + '\n' +
                "userId = " + userId + '\n' +
                "totalAmount = " + totalAmount + '\n' +
                "orderItems = " + orderItems;
    }
}
