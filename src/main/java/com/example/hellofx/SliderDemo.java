package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderDemo extends Application {
    double x = 0;
    double y = 0;

    @Override
    public void start(Stage primaryStage) {
        Slider horizontalSlider = new Slider();

        Slider verticalSlider = new Slider();
        verticalSlider.setOrientation(Orientation.VERTICAL);
        horizontalSlider.setStyle("-fx-color:green");
        verticalSlider.setStyle("-fx-color:red");
        Text text = new Text(30, 30, "Programming is fun!");
        text.setStyle("-fx-font-size:18");
        BorderPane borderPane = new BorderPane();
        Pane textPane = new Pane(text);
        borderPane.setCenter(textPane);
        borderPane.setBottom(horizontalSlider);
        borderPane.setRight(verticalSlider);
        horizontalSlider.setValue(horizontalSlider.getMax() / 2);
        verticalSlider.setValue(verticalSlider.getMax() / 2);
        System.out.println(horizontalSlider.getValue());
        System.out.println(verticalSlider.getValue());
        horizontalSlider.valueProperty().addListener(observable -> {
            double bound = text.getX() + horizontalSlider.getValue() - x + text.getLayoutBounds().getWidth();
            if (bound < textPane.getWidth() && bound >= 0) {
                text.setX(text.getX() + (horizontalSlider.getValue() - x) * 2);
                x = horizontalSlider.getValue();
            } else {
                horizontalSlider.setValue(x);
            }
        });
        verticalSlider.valueProperty().addListener(observable -> {
            double bound = text.getY() + verticalSlider.getValue() - y + text.getLayoutBounds().getHeight();
            System.out.println(bound);
            if (bound < textPane.getHeight() && bound >= 40) {
                text.setY(text.getY() + (verticalSlider.getValue() - y) * 2);
                y = verticalSlider.getValue();
            } else {
                verticalSlider.setValue(y);
            }
        });
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider demo");
        primaryStage.show();
        horizontalSlider.setShowTickMarks(true);
        horizontalSlider.setShowTickLabels(true);
        verticalSlider.setShowTickMarks(true);
        verticalSlider.setShowTickLabels(true);
        text.setX((textPane.getWidth() - text.getLayoutBounds().getWidth()) / 2);
        text.setY((textPane.getHeight() - text.getLayoutBounds().getHeight()) / 2);
        x = horizontalSlider.getValue();
        y = verticalSlider.getValue();
    }
}
