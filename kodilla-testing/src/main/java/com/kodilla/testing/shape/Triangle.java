package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name;
    double a, h;

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
