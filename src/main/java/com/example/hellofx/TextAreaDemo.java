package com.example.hellofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(20);
        textArea.setPrefRowCount(5);
        textArea.setWrapText(true);
        ImageView imageView = new ImageView("flag.jpg");
        imageView.setFitWidth(190);
        imageView.setFitHeight(100);
        Label label = new Label("USA", imageView);
        textArea.setText("USA's national flag...");
        label.setStyle("-fx-font-size:18");
        label.setContentDisplay(ContentDisplay.TOP);
        textArea.setStyle("-fx-font-size:18");
        ScrollPane scrollPane = new ScrollPane(textArea);
        HBox hBox = new HBox(label, scrollPane);
        hBox.setSpacing(10);
        String[] countries = {"United Kingdom", "Russia", "Spain", "Italy", "France", "India", "Canada", "China", "Germany", "Japan"};
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(countries));
        Label label1 = new Label("Select a Country:", comboBox);
        label1.setContentDisplay(ContentDisplay.RIGHT);
        label1.setStyle("-fx-font-size:16;-fx-font-weight:bold");
        comboBox.setPrefWidth(355);
        comboBox.setVisibleRowCount(5);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(label1);
        borderPane.setCenter(hBox);
        comboBox.setOnAction(event -> {
            String imgFileName = comboBox.getValue().toLowerCase() + ".png";
            if (imgFileName.startsWith("united"))
                imgFileName = imgFileName.replace("united kingdom", "uk");
            ImageView imageView1 = new ImageView(imgFileName);
            imageView1.setFitWidth(190);
            imageView1.setFitHeight(100);
            label.setGraphic(imageView1);
            label.setText(comboBox.getValue());
            textArea.setText(comboBox.getValue() + "'s national flag...");
            System.out.println(comboBox.getValue());
        });
        Scene scene = new Scene(borderPane, 500, 170);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.show();
    }
}
