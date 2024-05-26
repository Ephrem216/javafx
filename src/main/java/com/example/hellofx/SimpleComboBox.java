package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SimpleComboBox extends Application {
    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Item1", "Item2", "Item3", "Item4");
        comboBox.setVisibleRowCount(3);
        comboBox.setValue("Item1");
        comboBox.setStyle("-fx-color:red");
        comboBox.setEditable(false);
        Scene scene = new Scene(comboBox);
        primaryStage.setTitle("A simple combobox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
