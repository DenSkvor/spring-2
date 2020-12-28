package ru.geekbrains.spring.market.save.orders.dto;

import lombok.Data;


@Data
public class OrderItemDto {

    private Long id;

    private String product;

    private Integer quantity;

    private Integer productPrice;

    private Integer totalCost;


    @Override
    public String toString() {
        return "OrderItemDto{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", totalCost=" + totalCost +
                '}';
    }
}
