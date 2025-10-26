package org.example.order_service_2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private long productId;
    private String productName;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "OrderItem " + '\n' +
                "productId = " + productId + '\n' +
                "productName = " + productName + '\n' +
                "price = " + price + '\n' +
                "quantity = " + quantity;
    }
}
