package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class ShowRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rectangle1 = new Rectangle(40, 20, 200, 100);
        Rectangle rectangle2 = new Rectangle(40, 140, 200, 100);
        Rectangle rectangle3 = new Rectangle(40, 260, 200, 100);
        pane.getChildren().add(new Text(20, 60, "r1"));
        pane.getChildren().add(rectangle1);
        rectangle2.setStroke(Color.GREEN);
        rectangle2.setFill(Color.BEIGE);
        pane.getChildren().add(new Text(20, 190, "r2"));
        pane.getChildren().add(rectangle2);
        rectangle3.setStroke(Color.BLUE);
        rectangle3.setFill(Color.YELLOW);
        rectangle3.setArcWidth(50);
        rectangle3.setArcHeight(30);
        pane.getChildren().add(new Text(20, 310, "r3"));
        pane.getChildren().add(rectangle3);
        for (int i = 0; i < 4; i++) {
            Rectangle rect = new Rectangle(400, 50, 50, 300);
            rect.setRotate((double) (i * 360) / 8);
            rect.setFill(Color.color(Math.random(),Math.random(),Math.random()));
            rect.setStroke(Color.CORAL);
            pane.getChildren().add(rect);
        }
        Scene scene = new Scene(pane,600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Show Rectangle");
    }
}
