package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

import java.awt.*;

public class ShowBorderPane extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPane("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        pane.setCenter(new CustomPane("Center"));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowGridPane");
        primaryStage.show();
    }
}

class CustomPane extends StackPane{
    public CustomPane(String text){
        Font font = Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,18);
        Label label = new Label(text);
        label.setFont(font);
        getChildren().add(label);
        setStyle("-fx-border-color:red;-fx-background-color:beige");
        setPadding(new Insets(11,12,13,14));
    }
}
