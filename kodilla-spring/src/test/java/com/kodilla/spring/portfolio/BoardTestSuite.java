package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        TaskList toDoList = (TaskList) context.getBean("toDoList");
        toDoList.addTask("Moduł 11");
        toDoList.addTask("Moduł 12");
        TaskList inProgressList = (TaskList) context.getBean("inProgressList");
        inProgressList.addTask("Moduł 10");
        TaskList doneList = (TaskList) context.getBean("doneList");
        doneList.addTask("Moduł 9");
        doneList.addTask("Moduł 8");
        doneList.addTask("Moduł 7");
        Board board = context.getBean(Board.class);
        //When
        board.printList();
        //Then
        Assert.assertEquals("[Moduł 11, Moduł 12]", toDoList.getTasks().toString());
        Assert.assertEquals("[Moduł 10]", inProgressList.getTasks().toString());
        Assert.assertEquals("[Moduł 9, Moduł 8, Moduł 7]", doneList.getTasks().toString());
    }
}
