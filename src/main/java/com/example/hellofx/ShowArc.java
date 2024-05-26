package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class ShowArc extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Arc arc1 = new Arc(200, 200, 100, 100, 45, 20);
        pane.getChildren().add(arc1);
        arc1.setType(ArcType.ROUND);
        Arc arc2 = new Arc(200, 200, 100, 100, 145, 20);
        pane.getChildren().add(arc2);
        arc2.setType(ArcType.OPEN);
        Arc arc3 = new Arc(200, 200, 100, 100, 245, 20);
        pane.getChildren().add(arc3);
        arc3.setType(ArcType.CHORD);
        Arc arc4 = new Arc(200, 200, 100, 100, 325, 20);
        pane.getChildren().add(arc4);
        arc4.setType(ArcType.CHORD);
        Text text1 = new Text(300,100,"arc1: round");
        pane.getChildren().add(text1);
        Text text2 = new Text(100,100,"arc2: open");
        pane.getChildren().add(text2);
        Text text3 = new Text(100,330,"arc3: chord");
        pane.getChildren().add(text3);
        Text text4 = new Text(300,300,"arc4: chord");
        pane.getChildren().add(text4);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show Arc");
        primaryStage.show();
    }
}
