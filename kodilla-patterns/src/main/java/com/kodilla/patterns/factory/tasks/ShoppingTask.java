package com.kodilla.patterns.factory.tasks;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ShoppingTask implements Task{
    final String taskName;
    final String whatToBuy;
    final double quantity;
    private int count = 0;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        count = count + 1;
        return "Kupuję: " + whatToBuy + " w ilości: " + quantity;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        boolean executed = false;
        if(count > 0){
            executed = true;
        }
        return executed;
    }
}
