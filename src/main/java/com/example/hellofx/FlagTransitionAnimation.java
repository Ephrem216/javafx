package com.example.hellofx;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagTransitionAnimation extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Image image = new Image("flag.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(190);
        Line line = new Line(0,600,600,0);
//        pane.getChildren().add(line);
        PathTransition pathTransition = new PathTransition(new Duration(2000),line,imageView);
        pathTransition.setCycleCount(10);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        pane.getChildren().add(imageView);
        Scene scene = new Scene(pane,600,600);
        primaryStage.setTitle("Flag transition animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
