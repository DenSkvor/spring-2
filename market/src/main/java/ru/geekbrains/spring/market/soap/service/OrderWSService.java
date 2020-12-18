package ru.geekbrains.spring.market.soap.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.models.Order;
import ru.geekbrains.spring.market.services.OrderService;
import ru.geekbrains.spring.market.soap.elements.orders.OrderWS;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class OrderWSService {

    private OrderService orderService;

    public List<OrderWS> getAllOrderWS(){
        return orderService.findAll().stream().map(order -> createOrderWS(order)).collect(Collectors.toList());
    }

    private OrderWS createOrderWS(Order order){
        OrderWS orderWS = new OrderWS();
        orderWS.setId(order.getId());
        orderWS.setClientName(order.getClient().getName());
        orderWS.setPhoneNumber(order.getPhoneNumber());
        orderWS.setAddress(order.getAddress());
        orderWS.setPrice(order.getPrice());
        return orderWS;
    }
}
