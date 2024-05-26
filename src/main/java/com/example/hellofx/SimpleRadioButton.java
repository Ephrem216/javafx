package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SimpleRadioButton extends Application {
    @Override
    public void start(Stage primaryStage){
        ImageView imageView = new ImageView("flag.jpg");
        imageView.setFitHeight(10);
        imageView.setFitWidth(19);
        RadioButton radioButton = new RadioButton("US");
        radioButton.setGraphic(imageView);
        radioButton.setStyle("-fx-border-color:blue;-fx-border-width:2;");
        radioButton.setContentDisplay(ContentDisplay.LEFT);
        radioButton.setSelected(true);
        Scene scene = new Scene(radioButton);
        primaryStage.setTitle("Simple checkbox demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
