package ru.geekbrains.spring.market.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.models.Order;
import ru.geekbrains.spring.market.repositories.OrderRepository;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);
    }
}
