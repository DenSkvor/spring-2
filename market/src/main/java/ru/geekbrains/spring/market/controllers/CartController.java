package ru.geekbrains.spring.market.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.spring.market.Cart;
import ru.geekbrains.spring.market.exceptions.ProductNotFoundException;
import ru.geekbrains.spring.market.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private ProductService productService;
    private Cart cart;

    @GetMapping
    public String showCart(){
        return "cart";
    }

    @GetMapping("/add")
    public void addProduct(
            @RequestParam Long id,
            HttpServletRequest request, HttpServletResponse response
            ) throws ProductNotFoundException, IOException {
        cart.add(productService.getProductById(id));
        response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("/del")
    public String delProduct(@RequestParam Long id){
        cart.delete(id);
        return "cart";
    }

    @GetMapping("/incr")
    public String incrementProduct(@RequestParam Long id){
        cart.add(id);
        return "cart";
    }

    @GetMapping("/decr")
    public String decrementProduct(@RequestParam Long id){
        cart.remove(id);
        return "cart";
    }
    

}
