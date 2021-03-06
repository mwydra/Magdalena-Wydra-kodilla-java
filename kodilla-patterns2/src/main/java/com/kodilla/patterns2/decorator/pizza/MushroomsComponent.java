package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsComponent extends AbstractPizzaOrderDecorator{
    public MushroomsComponent(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(1));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + ", mushrooms";
    }
}
