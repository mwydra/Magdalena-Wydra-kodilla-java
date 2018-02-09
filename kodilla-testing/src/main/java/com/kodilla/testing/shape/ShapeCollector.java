package com.kodilla.testing.shape;

import java.util.ArrayList;

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

    public ArrayList<String> showFigures(){
        ArrayList<String> result = new ArrayList<String>();
        for (Shape shape: shapes){
             result.add(shape.getShapeName());
        }
        return result;
    }
}
