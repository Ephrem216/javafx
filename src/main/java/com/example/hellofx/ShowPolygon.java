package com.example.hellofx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class ShowPolygon extends Application {
    public void start(Stage primaryStage) {
//        Polygon polygon = new Polygon(100,100,200,100,250,150,200,200,100,200,50,150);
        Polyline polygon = new Polyline();
        polygon.setStroke(Color.BLUE);
        Pane pane = new Pane();
        pane.getChildren().add(polygon);
        double centerX = 300;
        double centerY = 300;
        double radius = 200;
        ObservableList<Double> list = polygon.getPoints();
        for (int i = 0; i < 6; i++) {
            list.add(centerX + (radius * Math.cos(2 * i * Math.PI / 6)));
            list.add(centerY + (radius * Math.sin(2 * i * Math.PI / 6)));
        }
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Show Polygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
