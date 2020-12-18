package ru.geekbrains.spring.market.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.spring.market.soap.elements.orders.GetOrdersRequest;
import ru.geekbrains.spring.market.soap.elements.orders.GetOrdersResponse;
import ru.geekbrains.spring.market.soap.service.OrderWSService;


@Endpoint
public class OrdersEndpoint {

    public static final String NAMESPACE_URL = "http://geekbrains.ru/spring/market/soap/elements/orders";

    private final OrderWSService orderWSService;

    public OrdersEndpoint(OrderWSService orderWSService) {
        this.orderWSService = orderWSService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getOrdersRequest")
    @ResponsePayload
    public GetOrdersResponse getOrdersResponse(@RequestPayload GetOrdersRequest request) {
        GetOrdersResponse response = new GetOrdersResponse();
        orderWSService.getAllOrderWS().forEach(orderWS -> response.getOrders().add(orderWS));
        return response;
    }

}
