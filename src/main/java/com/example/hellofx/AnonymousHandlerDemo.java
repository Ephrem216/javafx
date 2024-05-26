package com.example.hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousHandlerDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox = new HBox(10);
        Button button1 = new Button("New");
        Button button2 = new Button("Open");
        Button button3 = new Button("Save");
        Button button4 = new Button("print");
        hBox.setAlignment(Pos.CENTER);
        button1.setOnAction(event -> System.out.println("New"));
        button2.setOnAction(event -> System.out.println("Open"));
        button3.setOnAction(event -> System.out.println("Save"));
        button4.setOnAction(event -> System.out.println("Print"));
        hBox.getChildren().addAll(button1,button2,button3,button4);
        Scene scene = new Scene(hBox,300,100);
        primaryStage.setTitle("Anonymous Handler Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
