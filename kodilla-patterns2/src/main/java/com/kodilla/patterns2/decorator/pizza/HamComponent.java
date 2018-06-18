package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamComponent extends AbstractPizzaOrderDecorator{
    public HamComponent(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + ", ham";
    }
}
