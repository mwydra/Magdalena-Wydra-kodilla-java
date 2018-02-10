package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String name;
    double a;

    public Square(String name, double a) {
        this.name = name;
        this.a = a;
    }

    @Override
    public String getShapeName(){
        return name;
    }

    @Override
    public double getField(){
        double field = a * a;
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0 &&
                Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, a);
    }
}
