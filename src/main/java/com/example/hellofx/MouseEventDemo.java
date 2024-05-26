package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MouseEventDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Label label = new Label("Programming is fun!");
        label.setFont(Font.font("SansSerif", FontWeight.BOLD,18));
        Pane pane = new Pane();
        pane.getChildren().addAll(label);
        label.setOnMouseDragged(mouseEvent -> {
            label.setLayoutX(mouseEvent.getSceneX());
            label.setLayoutY(mouseEvent.getSceneY());
        });
        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("Mouse event demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
