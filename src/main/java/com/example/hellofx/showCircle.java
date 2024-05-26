package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class showCircle extends Application {
    @Override
    public void start(Stage primaryStage){
        Circle circle = new Circle();
        Pane pane = new Pane();
//        circle.setCenterX(250);
//        circle.setCenterY(200);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(100);
        circle.setStroke(Color.DARKRED);
        circle.setStyle("-fx-fill:red");
        //circle.setFill(Color.RED);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane,600,400);
        primaryStage.setTitle("Show Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
