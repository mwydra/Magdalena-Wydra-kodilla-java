package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double add = calculator.add(5, 9);
        double sub = calculator.sub(15, 6);
        double mul = calculator.mul(7, 9);
        double div = calculator.div(89, 3);
        //Then
        Assert.assertEquals(14, add, 0);
        Assert.assertEquals(9, sub, 0);
        Assert.assertEquals(63, mul, 0);
        Assert.assertEquals(29.666666666666668, div, 0.00001);

    }
}
