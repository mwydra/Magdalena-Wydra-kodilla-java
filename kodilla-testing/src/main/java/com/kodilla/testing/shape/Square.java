package com.kodilla.testing.shape;

public class Square implements Shape {
    private String name;
    double a = 4, b = 7;

    public Square(String name) {
        this.name = name;
    }

    @Override
    public String getShapeName(){
        return name;
    }

    @Override
    public double getField(){
        double field = a * b;
        return field;
    }
}
