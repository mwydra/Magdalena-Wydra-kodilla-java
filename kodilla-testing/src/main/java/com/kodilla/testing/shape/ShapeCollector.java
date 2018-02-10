package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = shapes.remove(shape);
        return result;
    }

    public Shape getFigure(int n){
        return shapes.get(n);
    }

    public List<String> showFigures(){
        ArrayList<String> result = new ArrayList<String>();
        for (Shape shape: shapes){
             result.add(shape.getShapeName());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeCollector collector = (ShapeCollector) o;
        return Objects.equals(shapes, collector.shapes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapes);
    }
}
