package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {
    @Override
    public void start(Stage primaryStage){
        FlowPane pane = new FlowPane(5,5);
        pane.setPadding(new Insets(10,10,10,10));
        Label nameLabel = new Label("First Name:");
        Label middleLabel = new Label("MI:");
        Label lastLabel = new Label("Last Name:");
        TextField nameField = new TextField("First name");
        TextField middleField = new TextField();
        middleField.setPrefColumnCount(1);
        TextField lastField = new TextField("Last name");
        pane.getChildren().addAll(nameLabel, nameField,middleLabel, middleField,lastLabel, lastField);
        Scene scene = new Scene(pane,300,100);
        primaryStage.setTitle("Flow pane demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
