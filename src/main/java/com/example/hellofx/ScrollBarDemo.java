package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    double x = 0;
    double y = 0;

    @Override
    public void start(Stage primaryStage) {
        ScrollBar horizontalScrollBar = new ScrollBar();
        ScrollBar verticalScrollBar = new ScrollBar();
        verticalScrollBar.setOrientation(Orientation.VERTICAL);
        horizontalScrollBar.setStyle("-fx-color:green");
        verticalScrollBar.setStyle("-fx-color:red");
        Text text = new Text(30, 30, "Programming is fun!");
        text.setStyle("-fx-font-size:18");
        BorderPane borderPane = new BorderPane();
        Pane textPane = new Pane(text);
        borderPane.setCenter(textPane);
        borderPane.setBottom(horizontalScrollBar);
        borderPane.setRight(verticalScrollBar);
        horizontalScrollBar.setValue(horizontalScrollBar.getMax() / 2);
        verticalScrollBar.setValue(verticalScrollBar.getMax() / 2);
        System.out.println(horizontalScrollBar.getValue());
        System.out.println(verticalScrollBar.getValue());
        horizontalScrollBar.valueProperty().addListener(observable -> {
            double bound = text.getX() + horizontalScrollBar.getValue() - x + text.getLayoutBounds().getWidth();
            if (bound < textPane.getWidth() && bound >= 0) {
                text.setX(text.getX() + (horizontalScrollBar.getValue() - x) * 2);
                x = horizontalScrollBar.getValue();
            } else {
                horizontalScrollBar.setValue(x);
            }
        });
        verticalScrollBar.valueProperty().addListener(observable -> {
            double bound = text.getY() + verticalScrollBar.getValue() - y + text.getLayoutBounds().getHeight();
            System.out.println(bound);
            if (bound < textPane.getHeight() && bound >= 40) {
                text.setY(text.getY() + (verticalScrollBar.getValue() - y) * 2);
                y = verticalScrollBar.getValue();
            } else {
                verticalScrollBar.setValue(y);
            }
        });
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scroll bar demo");
        primaryStage.show();
        text.setX((textPane.getWidth() - text.getLayoutBounds().getWidth()) / 2);
        text.setY((textPane.getHeight() - text.getLayoutBounds().getHeight()) / 2);
        x = horizontalScrollBar.getValue();
        y = verticalScrollBar.getValue();
    }
}
