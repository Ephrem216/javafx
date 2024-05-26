package com.example.hellofx;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Recap extends Application {
    @Override
    public void start(Stage primaryStage) {
        DoubleProperty doubleProperty = new SimpleDoubleProperty(4);
        DoubleProperty doubleProperty1 = new SimpleDoubleProperty(5);
       // doubleProperty1.bind(doubleProperty.multiply(2));
        doubleProperty.addListener(observable -> doubleProperty1.setValue(100));
        System.out.println(doubleProperty.getValue() + " ... " + doubleProperty1.getValue());
        doubleProperty.setValue(0);
        System.out.println(doubleProperty.getValue() + " ... " + doubleProperty1.getValue());
//        System.out.println("DoubleProperty content is "+doubleProperty.getValue());
//        System.out.println("DoubleProperty content is "+doubleProperty);
//        System.out.println("DoubleProperty1 content is "+doubleProperty1.getValue());
//        System.out.println("DoubleProperty1 content is "+doubleProperty1);
//        doubleProperty.setValue(10);
//        System.out.println("DoubleProperty content is "+doubleProperty.getValue());
//        System.out.println("DoubleProperty content is "+doubleProperty);
//        System.out.println("DoubleProperty1 content is "+doubleProperty1.getValue());
//        System.out.println("DoubleProperty1 content is "+doubleProperty1);


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
