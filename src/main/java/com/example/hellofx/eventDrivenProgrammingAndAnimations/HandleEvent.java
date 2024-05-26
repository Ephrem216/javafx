package com.example.hellofx.eventDrivenProgrammingAndAnimations;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleEvent extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button okButton = new Button("OK");
        Button cancelButton = new Button("CANCEL");
        OKHandlerClass  okHandlerClass = new OKHandlerClass();
        CancelHandlerClass cancelHandlerClass = new CancelHandlerClass();
        okButton.setOnAction(okHandlerClass);
        cancelButton.setOnAction(cancelHandlerClass);
        hBox.getChildren().addAll(okButton,cancelButton);

        Scene scene = new Scene(hBox);
        primaryStage.setTitle("Simple Event Handling Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class OKHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){
        System.out.println("OK button clicked.");
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){
        System.out.println("Cancel button clicked.");
    }
}
