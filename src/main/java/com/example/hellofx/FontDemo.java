package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,18);
        Label label = new Label("JavaFX");
        label.setStyle("-fx-text-fill:white");
        label.setFont(font);
        Circle circle = new Circle();
        Pane pane = new StackPane();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setStyle("-fx-fill:green");
        circle.setRadius(50);
        pane.getChildren().addAll(circle, label);
        Scene scene = new Scene(pane,300,200);
        primaryStage.setTitle("Font Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
        System.out.println(Font.getFontNames());
    }
}
