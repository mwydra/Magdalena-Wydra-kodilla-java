package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String name;
    double r = 5;

    public Circle(String name) {
        this.name = name;
    }

    @Override
    public String getShapeName(){
        return name;
    }

    @Override
    public double getField(){
        double field = 3.14 * (r * r);
        return field;
    }
}
