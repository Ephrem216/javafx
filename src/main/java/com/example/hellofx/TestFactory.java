package com.example.hellofx;

public class TestFactory {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
    }
}


interface Shape{
    public void draw();
}

 class Rectangle implements  Shape{
    @Override
    public void draw(){
        System.out.println("Rectangle object created");
    }
}

class Circle implements  Shape{
    @Override
    public void draw(){
        System.out.println("Circle object created");
    }
}

class Square implements  Shape{
    @Override
    public void draw(){
        System.out.println("Square object created");
    }
}

class ShapeFactory{
    private String shapeType;
    public ShapeFactory(){

        }

    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        else
            return null;
    }

}