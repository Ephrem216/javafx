package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipse extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        int n = 50;
        for (int i = 0; i < n; i++) {
            Ellipse ellipse = new Ellipse(250, 150, 100, 50);
            ellipse.setStroke(Color.GREEN);
            ellipse.setStrokeWidth(2);
            ellipse.setFill(Color.WHITE);
            ellipse.setRotate((double) (i * 360) /n);
            pane.getChildren().add(ellipse);
        }
        Scene scene = new Scene(pane,600,300);
        primaryStage.setTitle("Show ellipses");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
