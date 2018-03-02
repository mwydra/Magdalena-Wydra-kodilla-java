package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrder = orderService.order(orderRequest.getCustomer(), orderRequest.getProduct());
        if(isOrder){
            informationService.inform(orderRequest.getCustomer());
            orderRepository.createOrder(orderRequest.getCustomer(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getCustomer(), true);
        }
        else {
            return new OrderDto(orderRequest.getCustomer(), false);
        }

    }
}
