package com.kodilla.good.patterns.food2door;

public class HealthyShopOrder implements OrderProcessor {
    Provider provider = new Provider("HealthyShop", 67890);
    Order order = new Order(0, false);
    OrderRequest orderRequest = new OrderRequest("Bio carrot", 900);

    @Override
    public Order process() {
        int orderID = order.getOrderID() + 1;
        boolean isOrder = true;
        System.out.println("Your order for " + orderRequest.getProductName() + " " + orderRequest.getQuantity() + " was send to provider " + provider.getProviderName());
        return new Order(orderID, isOrder);
    }
}
