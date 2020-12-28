package ru.geekbrains.spring.market.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("/integration/order-integration.xml")
public class OrderIntegrationConfig {

}
