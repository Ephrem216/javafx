package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class SimpleListViewExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Item1", "Item2", "Item3", "Item4");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty().addListener(observable -> {
            System.out.println(listView.getSelectionModel().getSelectedIndex());
            System.out.println(listView.getSelectionModel().getSelectedItems());
            System.out.println(listView.getSelectionModel().getSelectionMode());
        });
        Scene scene = new Scene(listView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple listview demo");
        primaryStage.show();
    }
}

//ObservableList<String> items = FXCollections.observableArrayList("Item1", "Item2", "Item3", "Item4", "Item5", "Item6");
//        ListView<String> itemsList = new ListView<>(items);
//        itemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);