package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    private String name;
    double r;

    public Circle(String name, double r) {
        this.name = name;
        this.r = r;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.r, r) == 0 &&
                Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, r);
    }
}
