package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class ShowText extends Application {
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        Text text1 = new Text(10,30,"Programming is fun");
        text1.setFont(Font.font("Times New Roman", FontWeight.BOLD,24));
        Text text2 = new Text(50,80,"Programming is fun\nDisplay text");
        text2.setFont(Font.font("SansSerif",24));
        Text text3 = new Text(10,150,"Programming is fun\nDisplay text");
        text3.setStrikethrough(true);
        text3.setUnderline(true);
        text3.setStyle("-fx-fill:grey");
        text3.setFont(Font.font("SansSerif",24));
        pane.getChildren().addAll(text1,text2,text3);
        Scene scene = new Scene(pane,300,190);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show Text");
        primaryStage.show();
    }
}
