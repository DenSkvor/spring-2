package ru.geekbrains.spring.market.save.orders.services;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.save.orders.dto.OrderDto;

import java.io.File;
import java.io.IOException;

@Service
public class OrderService {

    public void save(OrderDto order) {
        File orderFolder = new File("C:\\Users\\Денис\\Desktop");

        File orderFile = new File(orderFolder, order.getId() + ".json");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(orderFile, order);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
