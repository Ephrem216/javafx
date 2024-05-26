package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NodeStyleRotateDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Button btn = new Button("Button");
        btn.setStyle("-fx-border-color:blue;-fx-text-fill:red;");
        btn.setRotate(-45);
        pane.getChildren().add(btn);
        pane.setStyle("-fx-border-color:red;-fx-background-color:green");
        pane.setRotate(45);
        Scene scene = new Scene(pane, 200,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Node style rotate demo");
        primaryStage.show();
    }
}
