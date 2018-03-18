package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "Shopping";
    public static final String PAINTING = "Painting";
    public static final String DRIVING = "Driving";

    public final Task makeTask(final String taskClass){
        switch (taskClass){
            case SHOPPING:
                return new ShoppingTask("Shopping", "mleko", 12);
            case PAINTING:
                return new PaintingTask("Painting", "czerwony", "autobus");
            case DRIVING:
                return new DrivingTask("Driving", "Paryż", "pociąg");
            default:
                 return null;
        }
    }
}
