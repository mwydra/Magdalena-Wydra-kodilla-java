package com.kodilla.testing.shape;

import org.junit.*;
import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    private static int counter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("Starting all tests...");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("The end.");
    }

    @Before
    public void beforeTest(){
        counter++;
        System.out.println("Test " + counter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle("koło");
        //When
        collector.addFigure(circle);
        //Then
        Assert.assertEquals(circle, circle);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Triangle triangle = new Triangle("trójkąt");
        collector.addFigure(triangle);
        //When
        Shape figure = collector.getFigure(0);
        //Then
        Assert.assertEquals(triangle, figure);
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square square = new Square("kwadrat");
        collector.addFigure(square);
        //When
        boolean result = collector.removeFigure(square);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle("koło");
        Triangle triangle = new Triangle("trójkąt");
        Square square = new Square("kwadrat");
        collector.addFigure(circle);
        collector.addFigure(triangle);
        collector.addFigure(square);
        //When
        ArrayList<String> test = collector.showFigures();
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("koło");
        expected.add("trójkąt");
        expected.add("kwadrat");
        //Then
        Assert.assertEquals(expected, test);
    }
}
