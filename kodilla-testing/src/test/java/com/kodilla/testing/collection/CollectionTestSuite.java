package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    OddNumbersExterminator test = new OddNumbersExterminator();
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end\n");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        ArrayList<Integer> result = test.exterminate(numbers);
        System.out.println("Result list size = " + result.size());
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        for (int i = 1; i <= 15; i++){
            numbers.add(i);
        }
        ArrayList<Integer> result = test.exterminate(numbers);
        System.out.println("Result list size = " + result.size());
    }
}
