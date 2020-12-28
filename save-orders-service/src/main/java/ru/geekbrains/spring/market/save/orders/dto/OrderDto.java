package ru.geekbrains.spring.market.save.orders.dto;

import lombok.Data;
import java.util.List;


@Data
public class OrderDto {

    private Long id;

    private String client;

    private String phoneNumber;

    private String address;

    private Integer price;

    private List<OrderItemDto> orderItems;


    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", orderItems=" + orderItems +
                '}';
    }
}
