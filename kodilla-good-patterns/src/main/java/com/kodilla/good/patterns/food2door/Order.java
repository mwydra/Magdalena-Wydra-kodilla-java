package com.kodilla.good.patterns.food2door;

public class Order {
    private int orderID;
    boolean isOrder;

    public Order(int orderID, boolean isOrder) {
        this.orderID = orderID;
        this.isOrder = isOrder;
    }

    public int getOrderID() {
        return orderID;
    }

    public boolean isOrder() {
        return isOrder;
    }
}
