package com.example.hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) {
        Button buttonEnlarge = new Button("Enlarge");
        Button buttonShrink = new Button("Shrink");
        HBox hBox = new HBox(10);
//        EnlargeCircleHandler enlargeCircleHandler = new EnlargeCircleHandler();
//        buttonEnlarge.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//                circlePane.enlarge();
//            }
//        });
//        buttonEnlarge.setOnAction(event -> circlePane.enlarge());
        buttonEnlarge.setOnAction(event -> {
            circlePane.enlarge();
            circlePane.requestFocus();
        });
//        ShrinkCircleHandler shrinkCircleHandler = new ShrinkCircleHandler();
//        buttonShrink.setOnAction(shrinkCircleHandler);
        buttonShrink.setOnAction(event -> {
            circlePane.shrink();
            circlePane.requestFocus();
        });
        hBox.getChildren().addAll(buttonEnlarge, buttonShrink);
        hBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        circlePane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY)
                circlePane.enlarge();
            if (mouseEvent.getButton() == MouseButton.SECONDARY)
                circlePane.shrink();
        });

        circlePane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.U)
                circlePane.enlarge();
            if (keyEvent.getCode() == KeyCode.D)
                circlePane.shrink();
        });
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        circlePane.requestFocus();
    }

    class EnlargeCircleHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.enlarge();
        }
    }

    class ShrinkCircleHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.shrink();
        }
    }

}

class CirclePane extends StackPane {
    private Circle circle;

    CirclePane() {
        circle = new Circle();
        circle.setRadius(50);
        getChildren().add(circle);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() * 1.15);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() / 1.15);
    }
}
