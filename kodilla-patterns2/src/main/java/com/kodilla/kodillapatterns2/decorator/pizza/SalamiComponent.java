package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiComponent extends AbstractPizzaOrderDecorator{
    public SalamiComponent(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getOrder() {
        return super.getOrder() + ", salami";
    }
}
