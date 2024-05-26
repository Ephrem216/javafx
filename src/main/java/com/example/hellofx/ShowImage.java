package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {
    @Override
    public void start(Stage stage){
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(10,10,10,10));
        Image image = new Image("ephrem.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(100);
        pane.getChildren().add(imageView);
        Image image1 = new Image("ephrem.jpg");
        ImageView imageView1 = new ImageView(image);
        imageView1.setFitWidth(150);
        imageView1.setRotate(33);
        imageView1.setFitHeight(100);
        imageView1.setRotate(90);
        pane.getChildren().add(imageView1);
        Image image2 = new Image("ephrem.jpg");
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(100);
        pane.getChildren().add(imageView2);
        Scene scene = new Scene(pane, 300,250);
        stage.setScene(scene);
        stage.setTitle("Show Fucking Bitch Images");
        stage.show();
    }
}
