package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

public class LabelWithGraphic extends Application {
    @Override
    public void start(Stage primaryStage){
        ImageView imageView = new ImageView("flag.jpg");
        imageView.setFitWidth(190);
        imageView.setFitHeight(100);
        String string = "US\n50States";
        Label label = new Label(string,imageView);
        label.alignmentProperty().set(Pos.CENTER);
        label.setStyle("-fx-border-color:green;-fx-border-width:2");
        label.setTextFill(Color.GREEN);
        label.setContentDisplay(ContentDisplay.BOTTOM);
        Label label1 = new Label("Circle",new Circle(30));
        label1.setContentDisplay(ContentDisplay.TOP);
        Label label2 = new Label("Rectangle",new Rectangle(100,50));
        label2.setContentDisplay(ContentDisplay.RIGHT);
        Ellipse ellipse = new Ellipse(50,25);
        Label label3 = new Label("Ellipse",new Ellipse(50,25));
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        Label label4 = new Label("JavaFX",ellipse);
        label4.setContentDisplay(ContentDisplay.CENTER);
        Pane pane =new Pane(label4);
        Label label5 = new Label("A pane inside a label",pane);
        label5.setContentDisplay(ContentDisplay.BOTTOM);
        HBox hBox = new HBox(label,label1,label2,label3,label5);
        hBox.setSpacing(30);
        Scene scene = new Scene(hBox,800,150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label with graphic");
        primaryStage.show();
    }
}
