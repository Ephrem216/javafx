package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.shape.Line;

public class ShowLine extends Application {
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Line line1 = new Line(10,10,10,10);
        Line line2 = new Line(10,10,10,10);
        line1.endXProperty().bind(pane.widthProperty().subtract(10));
        line1.endYProperty().bind(pane.heightProperty().subtract(100));line1.endXProperty().bind(pane.widthProperty().subtract(10));
        line2.startYProperty().bind(pane.heightProperty().subtract(100));line1.endXProperty().bind(pane.widthProperty().subtract(10));
        line2.endXProperty().bind(pane.widthProperty().subtract(10));
        pane.getChildren().add(line1);
        pane.getChildren().add(line2);
        line1.setStrokeWidth(5);
        line2.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        line2.setStroke(Color.GREEN);
        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("Show Line");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
