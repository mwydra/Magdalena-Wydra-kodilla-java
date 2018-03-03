package com.kodilla.good.patterns.food2door;

public class ExtraFoodShopOrder implements OrderProcessor{
    Provider provider = new Provider("ExtraFoodShop", 12345);
    Order order = new Order(0, false);
    OrderRequest orderRequest = new OrderRequest("Cottage cheese", 200);

    @Override
    public Order process() {
        int orderID = order.getOrderID() + 1;
        boolean isOrder = true;
        System.out.println("Your order for " + orderRequest.getProductName() + " " + orderRequest.getQuantity() + " was send to provider " + provider.getProviderName());
        return new Order(orderID, isOrder);
    }
}
