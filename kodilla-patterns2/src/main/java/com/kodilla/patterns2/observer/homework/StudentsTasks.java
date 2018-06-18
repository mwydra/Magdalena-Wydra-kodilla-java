package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentsTasks implements HomeworkObservable {
    private final List<HomeworkObserver> observers;
    private final List<String> tasks;
    private final String module;

    public StudentsTasks(String module) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.module = module;
    }

    public void addTask(String task){
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (HomeworkObserver observer : observers){
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        observers.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getModule() {
        return module;
    }
}
