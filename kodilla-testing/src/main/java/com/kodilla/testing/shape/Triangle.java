package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private String name;
    double a, h;

    public Triangle(String name, double a, double h) {
        this.name = name;
        this.a = a;
        this.h = h;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 &&
                Double.compare(triangle.h, h) == 0 &&
                Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, a, h);
    }
}
