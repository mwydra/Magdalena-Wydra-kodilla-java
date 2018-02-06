package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        //System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calc = new Calculator();

        int resultAdd = calc.add(5, 18);
        int resultSubstract = calc.subtract(20, 3);

        if(resultAdd == 23){
            System.out.println("test add OK");
        } else {
            System.out.println("Add error!");
        }

        if(resultSubstract == 17){
            System.out.println("test substract OK");
        } else {
            System.out.println("Substract error!");
        }
    }
}
