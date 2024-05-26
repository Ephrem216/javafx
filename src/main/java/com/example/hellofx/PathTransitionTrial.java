package com.example.hellofx;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionTrial extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(200);
        circle.setStroke(Color.DARKCYAN);
        circle.setFill(Color.WHITE);
        Rectangle rectangle = new Rectangle(50, 50);
        rectangle.setFill(Color.BEIGE);
        rectangle.setStroke(Color.CORAL);
        PathTransition pathTransition = new PathTransition(new Duration(5000), circle, rectangle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        circle.setOnMouseClicked(mouseEvent -> {
            if (pathTransition.getStatus() == Animation.Status.RUNNING)
                pathTransition.pause();
            else if(pathTransition.getStatus() == Animation.Status.PAUSED ||
                    pathTransition.getStatus() == Animation.Status.STOPPED)
                pathTransition.play();
        });
        rectangle.setOnKeyPressed(keyEvent -> pathTransition.stop());
        pathTransition.setAutoReverse(true);
        pathTransition.setRate(4);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pane.getChildren().addAll(circle);
        pane.getChildren().addAll(rectangle);
        pathTransition.play();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Path transition trial");
        primaryStage.setScene(scene);
        primaryStage.show();
        rectangle.requestFocus();
    }
}
