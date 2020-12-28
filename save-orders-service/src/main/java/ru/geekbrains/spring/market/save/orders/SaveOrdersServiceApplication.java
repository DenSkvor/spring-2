package ru.geekbrains.spring.market.save.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@IntegrationComponentScan
@SpringBootApplication
public class SaveOrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveOrdersServiceApplication.class, args);
	}

}
