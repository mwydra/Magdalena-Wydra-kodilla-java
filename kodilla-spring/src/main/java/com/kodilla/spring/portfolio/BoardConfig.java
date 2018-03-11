package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDoList")
    TaskList theList;

    @Bean("toDoList")
    @Scope("prototype")
    public TaskList addToDoList(){
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList addInProgressList(){
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList addDoneList(){
        return new TaskList();
    }

    @Bean
    public Board addBoard(){
        return new Board(addToDoList(), addInProgressList(), addDoneList());
    }
}

