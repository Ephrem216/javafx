package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 230,100);
        primaryStage.setTitle("Button in pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
