package ru.geekbrains.spring.market.controllers;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.market.models.Client;
import ru.geekbrains.spring.market.services.ClientService;

import java.security.Principal;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping
    public String showClientInfo(Principal principal,
                                   Model model){
        Client client = clientService.findByName(principal.getName());
        model.addAttribute("name", client.getName());
        model.addAttribute("phoneNumber", client.getPhoneNumber());
        model.addAttribute("email", client.getEmail());
        return "client";
    }
}
