package com.example.hellofx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class EventClass extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        Circle circle = new Circle();
        circle.setRadius(50);
        pane.setCenter(circle);
        Button button1 = new Button("Enlarge");
        Button button2 = new Button("Shrink");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(button1,button2);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        Scene scene = new Scene(pane,200,150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Event ...");
        primaryStage.show();
    }
}

class ShrinkHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event){

    }
}
