package com.example.hellofx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BounceBallControl extends Application {
    int x = 50;
    int change = 1;

    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5), actionEvent -> {
            ballPane.setX(x);
            x += change;
            if (x >= 1400 || x <= 0)
                change *= -1;
        });
        Slider slider = new Slider();
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(slider);
        borderPane.setCenter(ballPane);
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        ballPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.U)
                timeline.setRate(timeline.getRate() * 1.1);
            else if (keyEvent.getCode() == KeyCode.D)
                timeline.setRate(timeline.getRate() * 0.9);
        });
        slider.setValue(10);
//        slider.valueProperty().addListener(observable -> {
//            timeline.setRate(slider.getValue() / 10);
//        });
        timeline.rateProperty().bind(slider.valueProperty().divide(10));
        Scene scene = new Scene(borderPane, ballPane.getW(), ballPane.getH());
        scene.setFill(Color.color(.063, .094, .0125));
        primaryStage.setTitle("Bouncing ball animation control");
        primaryStage.setScene(scene);
        primaryStage.show();
        ballPane.requestFocus();
    }
}
