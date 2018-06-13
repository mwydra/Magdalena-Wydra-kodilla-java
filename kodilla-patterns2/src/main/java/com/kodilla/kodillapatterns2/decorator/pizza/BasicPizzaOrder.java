package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }

    @Override
    public String getOrder() {
        return "Your pizza consists of: paste, tomato sauce, cheese";
    }
}
