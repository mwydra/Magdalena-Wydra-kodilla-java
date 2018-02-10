package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name;
    double a = 8, h = 5;

    public Triangle(String name) {
        this.name = name;
    }

    @Override
    public String getShapeName(){
        return name;
    }

    @Override
    public double getField(){
        double field = (a * h)/2;
        return field;
    }
}
