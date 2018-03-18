package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShopping(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask("Shopping");
        //Then
        Assert.assertEquals("Kupuję: mleko w ilości: 12.0", shopping.executeTask());
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask("Painting");
        //Then
        Assert.assertEquals("Maluję: autobus w kolorze: czerwony", painting.executeTask());
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask("Driving");
        //Then
        Assert.assertEquals("Jadę do: Paryż pojazdem: pociąg", driving.executeTask());
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertEquals(true, driving.isTaskExecuted());
    }
}
