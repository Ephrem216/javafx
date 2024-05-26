package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowGridPane extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setVgap(5);
        pane.setHgap(5);
        Label nameLabel = new Label("First Name:");
        Label middleLabel = new Label("MI:");
        Label lastLabel = new Label("Last Name:");
        TextField nameField = new TextField("First name");
        TextField middleField = new TextField();
        middleField.setPrefColumnCount(1);
        TextField lastField = new TextField("Last name");
        Button button = new Button("Add Name");
        pane.addRow(0,nameLabel,nameField);
        pane.addRow(1,middleLabel,middleField);
        pane.addRow(2,lastLabel,lastField);
        pane.add(button,1,3);
        GridPane.setHalignment(button, HPos.RIGHT);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show grid pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
