package ru.geekbrains.spring.market.save.orders.integration;


import lombok.AllArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.save.orders.dto.OrderDto;
import ru.geekbrains.spring.market.save.orders.services.OrderService;

import java.util.Map;

@AllArgsConstructor
@Component
public class OrderActivator {

    private OrderService orderService;

    @ServiceActivator(inputChannel = "ordersChannel")
    public void listenNewsChannel(@Payload OrderDto payload, @Headers Map<String,Object> headers){
        //System.out.println("Get order in message: " + payload);
        orderService.save(payload);
    }
}
