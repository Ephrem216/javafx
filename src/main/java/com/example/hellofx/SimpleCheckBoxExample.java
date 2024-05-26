package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SimpleCheckBoxExample extends Application {
    @Override
    public void start(Stage primaryStage){
        ImageView imageView = new ImageView("flag.jpg");
        imageView.setFitHeight(10);
        imageView.setFitWidth(19);
        CheckBox checkBox = new CheckBox("US");
        checkBox.setGraphic(imageView);
        checkBox.setStyle("-fx-border-color:blue;-fx-border-width:2;");
        checkBox.setContentDisplay(ContentDisplay.LEFT);
        checkBox.setSelected(true);
        Scene scene = new Scene(checkBox);
        primaryStage.setTitle("Simple checkbox demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
