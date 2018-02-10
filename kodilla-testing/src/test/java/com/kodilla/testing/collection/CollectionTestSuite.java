package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

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
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //When
        ArrayList<Integer> result = exterminator.exterminate(numbers);
        //Then
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 15; i++){
            numbers.add(i);
        }
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(2);
        test.add(4);
        test.add(6);
        test.add(8);
        test.add(10);
        test.add(12);
        test.add(14);
        //When
        ArrayList<Integer> result = exterminator.exterminate(numbers);
        //Then
        Assert.assertEquals(7, result.size());
        Assert.assertEquals(test, result);
    }
}
