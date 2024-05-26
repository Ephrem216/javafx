package com.example.hellofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimeLineDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text(100, 100, "Programming is fun");
        text.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), event -> {
            if (text.getText().isEmpty())
                text.setText("Programming is fun");
            else
                text.setText("");
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        pane.setOnMouseClicked(mouseEvent -> {
            if (timeline.getStatus().equals(Animation.Status.RUNNING))
                timeline.pause();
            else
                timeline.play();
        });
        pane.getChildren().add(text);
        timeline.play();
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("TimeLineDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
