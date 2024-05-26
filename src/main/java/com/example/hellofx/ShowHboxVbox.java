package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class ShowHboxVbox extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox = new HBox(5);
        Button label1 = new Button("Computer Science");
        Button label2 = new Button("Chemistry");
        ImageView imageView = new ImageView("flag.jpg");
        imageView.setFitWidth(100);
        imageView.setFitHeight(50);
        hBox.getChildren().addAll(label1,label2,imageView);
        hBox.setStyle("-fx-background-color:cyan");
        hBox.setPadding(new Insets(10));

        VBox vBox = new VBox(5);
        Label label3 = new Label("Courses");
        Label[] courses = {new Label("CSCI 1301"),new Label("CSCI 1302"),new Label("CSCI 1303"),new Label("CSCI 1304")};
        Font font1 = Font.font("Courier", FontWeight.BOLD,20);
        label3.setFont(font1);
        vBox.getChildren().add(label3);
        Font font2 = Font.font("Courier", FontWeight.LIGHT, FontPosture.ITALIC,16);
        for(Label label:courses){
            label.setFont(font2);
            vBox.getChildren().add(label);
            VBox.setMargin(label,new Insets(0,0,0,15));
        }

        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setLeft(vBox);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show HBox VBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
