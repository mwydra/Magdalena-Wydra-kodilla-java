package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        ExtraFoodShopOrder extraFoodShopOrder = new ExtraFoodShopOrder();
        extraFoodShopOrder.process();

        HealthyShopOrder healthyShopOrder = new HealthyShopOrder();
        healthyShopOrder.process();

        GlutenFreeShopOrder glutenFreeShopOrder = new GlutenFreeShopOrder();
        glutenFreeShopOrder.process();
    }
}
