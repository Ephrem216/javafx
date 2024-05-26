package com.example.hellofx;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AlseraAleEko extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        Button okButton = new Button("F");
        Button cancelButton = new Button("Tell me the time");
        OKHandler okHandlerClass = new OKHandler();
        CancelHandler cancelHandlerClass = new CancelHandler();
        okButton.setOnAction(okHandlerClass);
        cancelButton.setOnAction(cancelHandlerClass);
        hBox.getChildren().addAll(okButton,cancelButton);

        Scene scene = new Scene(hBox,300,200);
        primaryStage.setTitle("Simple Event Handling Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class OKHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){
        System.out.println("Y.");
    }
}

class CancelHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){
        new DisplayClock().start(new Stage());
    }
}
