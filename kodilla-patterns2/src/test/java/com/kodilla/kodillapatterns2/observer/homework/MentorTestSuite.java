package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        StudentsTasks module19 = new StudentsTasks("Moduł 19");
        StudentsTasks module20 = new StudentsTasks("Moduł 20");
        StudentsTasks module21 = new StudentsTasks("Moduł 21");
        StudentsTasks module22 = new StudentsTasks("Moduł 22");
        Mentor kamil = new Mentor("Kamil Kalandyk");
        Mentor maciek = new Mentor("Maciej Prokopiuk");
        module19.registerObserver(kamil);
        module20.registerObserver(kamil);
        module21.registerObserver(kamil);
        module22.registerObserver(maciek);
        //When
        module19.addTask("Zadanie 19.1");
        module19.addTask("Zadanie 19.2");
        module20.addTask("Zadanie 20.4");
        module21.addTask("Zadanie 21.3");
        module21.addTask("Zadanie 21.4");
        module21.addTask("Zadanie 21.5");
        module22.addTask("Zadanie 22.1");
        //Then
        assertEquals(6, kamil.getUpdateCount());
        assertEquals(1, maciek.getUpdateCount());
    }
}