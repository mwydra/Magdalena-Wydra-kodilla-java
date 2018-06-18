package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testHawaiianPizzaCost(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamComponent(theOrder);
        theOrder = new PineappleComponent(theOrder);
        theOrder = new CornComponent(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(19), calculatedCost);
    }
    @Test
    public void testHawaiianPizzaDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamComponent(theOrder);
        theOrder = new PineappleComponent(theOrder);
        theOrder = new CornComponent(theOrder);
        //When
        String orderDescription = theOrder.getOrder();
        //Then
        assertEquals("Your pizza consists of: paste, tomato sauce, cheese, ham, pineapple, corn", orderDescription);
    }
    @Test
    public void testFarmerPizzaCost(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiComponent(theOrder);
        theOrder = new PepperComponent(theOrder);
        theOrder = new MushroomsComponent(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }
    @Test
    public void testFarmerPizzaDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiComponent(theOrder);
        theOrder = new PepperComponent(theOrder);
        theOrder = new MushroomsComponent(theOrder);
        //When
        String orderDescription = theOrder.getOrder();
        //Then
        assertEquals("Your pizza consists of: paste, tomato sauce, cheese, salami, pepper, mushrooms", orderDescription);
    }
    @Test
    public void testVegetarianPizzaCost(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PepperComponent(theOrder);
        theOrder = new MushroomsComponent(theOrder);
        theOrder = new CornComponent(theOrder);
        theOrder = new ExtraCheese(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21), calculatedCost);
    }
    @Test
    public void testVegetarianPizzaDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PepperComponent(theOrder);
        theOrder = new MushroomsComponent(theOrder);
        theOrder = new CornComponent(theOrder);
        theOrder = new ExtraCheese(theOrder);
        //When
        String orderDescription = theOrder.getOrder();
        //Then
        assertEquals("Your pizza consists of: paste, tomato sauce, cheese, pepper, mushrooms, corn, extra cheese", orderDescription);
    }
}
