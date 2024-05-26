package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Trial extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btn = new Button("OK");
        Scene scene = new Scene(btn, 300,399);
        Scene scene2 = new Scene(new Button("End with Beginnings"), 400,199);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Again...");
        secondaryStage.setScene(scene2);
        secondaryStage.setX(234);
        primaryStage.setResizable(false);
        secondaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
