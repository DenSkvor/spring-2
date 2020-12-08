package ru.geekbrains.spring.market.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.spring.market.Cart;
import ru.geekbrains.spring.market.models.Client;
import ru.geekbrains.spring.market.models.Order;
import ru.geekbrains.spring.market.models.OrderItem;
import ru.geekbrains.spring.market.services.ClientService;
import ru.geekbrains.spring.market.services.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private Cart cart;
    private ClientService clientService;
    private OrderService orderService;

    @GetMapping
    public String showOrderForm(){
        return "order_form";
    }

    @PostMapping
    public String showOrderForm(Model model,
                                @RequestParam(name = "phNum", required = false) String phoneNumber,
                                @RequestParam(required = false) String address){
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);
        return "order_form";
    }

    @PostMapping("/show")
    public String showOrder(Model model,
                            @RequestParam(name = "phNum") String phoneNumber,
                            @RequestParam String address){
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);

        return "order";
    }

    @PostMapping("/confirm")
    public String confirmOrder(Principal principal,
                               @RequestParam(name = "phNum") String phoneNumber,
                               @RequestParam String address){

        Client client = clientService.findByName(principal.getName());
        Integer totalCost = cart.getTotalCost();
        List<OrderItem> orderItems = cart.getContainer();
        Order order = new Order(client, phoneNumber, address, totalCost, orderItems);

        orderService.addOrder(order);
        cart.clear();

        return "redirect:/products";
    }
}
