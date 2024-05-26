package com.example.hellofx;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class ListViewDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        String[] countries = {"Canada", "United Kingdom", "Japan", "Russia", "India", "Germany", "Italy", "France", "Spain", "China"};
        ListView<String> listView = new ListView<>(FXCollections.observableArrayList(countries));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ScrollPane scrollPane = new ScrollPane(listView);
        FlowPane flowPane = new FlowPane(10, 10);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(scrollPane);
        borderPane.setCenter(flowPane);
        listView.getSelectionModel().selectedItemProperty().addListener(observable -> {
            flowPane.getChildren().clear();
            ObservableList<String> observableList = listView.getSelectionModel().getSelectedItems();
            String[] images = new String[observableList.size()];
            images = observableList.toArray(images);
            for (String image : images) {
                String imgFileName = image + ".png";
                System.out.println(imgFileName);
                if (imgFileName.startsWith("United"))
                    imgFileName = imgFileName.replace("United Kingdom", "uk");
                ImageView imageView = new ImageView(imgFileName);
                imageView.setFitHeight(100);
                imageView.setFitWidth(190);
                flowPane.getChildren().add(imageView);
                System.out.println(listView.getSelectionModel().getSelectedItems());
                System.out.println(flowPane.getChildren().toString());
            }
        });
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("List View Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
