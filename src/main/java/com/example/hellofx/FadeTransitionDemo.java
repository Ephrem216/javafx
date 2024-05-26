package com.example.hellofx;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse(300,300,300,150);
        ellipse.setFill(Color.GREEN);
        pane.getChildren().add(ellipse);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(100),ellipse);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        ellipse.setOnMousePressed(mouseEvent -> fadeTransition.pause());
        ellipse.setOnMouseReleased(mouseEvent -> fadeTransition.play());
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setByValue(0.1);
        fadeTransition.play();
        Scene scene = new Scene(pane,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fade transition demo");
        primaryStage.show();
    }
}
