package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        HBox hBox = new HBox(30);
        hBox.getChildren().addAll(leftButton, rightButton);
        hBox.setStyle("-fx-border-color:black;-fx-border-width:2;");
        Text text = new Text("JavaFX programming");
        text.setStyle("-fx-font-size:18");
        hBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.getChildren().add(text);
        borderPane.setPadding(new Insets(10));
        Scene scene = new Scene(borderPane, 500, 150);
        CheckBox italicCheckBox = new CheckBox("Italic");
        CheckBox boldCheckBox = new CheckBox("Bold");
        VBox vBox = new VBox(italicCheckBox, boldCheckBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-border-color:black;-fx-border-width:2;");
        vBox.setPadding(new Insets(5));
        text.setX((borderPane.getWidth() - text.getLayoutBounds().getWidth() - vBox.getWidth()) / 2);
        text.setY((borderPane.getHeight() - text.getLayoutBounds().getHeight() - hBox.getHeight()) / 2);
        leftButton.setOnAction(event -> {
            //System.out.println(text.getX());
            if (text.getX() > 10)
                text.setX(text.getX() - 5);
        });
        rightButton.setOnAction(event -> {
            //System.out.println(text.getX() + " " + (borderPane.getWidth() - text.getLayoutBounds().getWidth()));
            if (text.getX() < borderPane.getWidth() - text.getLayoutBounds().getWidth() - vBox.getWidth() - 10)
                text.setX(text.getX() + 5);
        });
        italicCheckBox.setOnAction(event -> {
            if (text.getFont().toString().contains("Italic")) {
                if (text.getFont().toString().contains("Bold"))
                    text.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 18));
                else
                    text.setFont(Font.font("SansSerif", FontWeight.NORMAL, FontPosture.REGULAR, 18));
            } else {
                if (text.getFont().toString().contains("Bold"))
                    text.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.ITALIC, 18));
                else
                    text.setFont(Font.font("SansSerif", FontWeight.NORMAL, FontPosture.ITALIC, 18));
            }
        });
        boldCheckBox.setOnAction(event -> {
            if (text.getFont().toString().contains("Bold")) {
                if (text.getFont().toString().contains("Italic"))
                    text.setFont(Font.font("SansSerif", FontWeight.NORMAL, FontPosture.ITALIC, 18));
                else
                    text.setFont(Font.font("SansSerif", FontWeight.NORMAL, FontPosture.REGULAR, 18));
            } else {
                if (text.getFont().toString().contains("Italic"))
                    text.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.ITALIC, 18));
                else
                    text.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 18));
            }
        });
        RadioButton redRadioButton = new RadioButton("Red");
        RadioButton greenRadioButton = new RadioButton("Green");
        RadioButton blueRadioButton = new RadioButton("Blue");
        VBox vBox1 = new VBox(redRadioButton,greenRadioButton,blueRadioButton);
        vBox1.setSpacing(10);
        vBox1.setStyle("-fx-border-color:black;-fx-border-width:2;");
        ToggleGroup group = new ToggleGroup();
        redRadioButton.setToggleGroup(group);
        greenRadioButton.setToggleGroup(group);
        blueRadioButton.setToggleGroup(group);
        redRadioButton.setTextFill(Color.RED);
        redRadioButton.setStyle("-fx-color:red");
        greenRadioButton.setStyle("-fx-color:green");
        blueRadioButton.setStyle("-fx-color:blue");
        greenRadioButton.setTextFill(Color.GREEN);
        blueRadioButton.setTextFill(Color.BLUE);
        borderPane.setLeft(vBox1);
        borderPane.setRight(vBox);
        redRadioButton.setOnAction(event -> text.setFill(Color.RED));
        greenRadioButton.setOnAction(event -> text.setFill(Color.GREEN));
        blueRadioButton.setOnAction(event -> text.setFill(Color.BLUE));
        TextField textField = new TextField();
        Label label = new Label("Enter a new message:",textField);
        label.setContentDisplay(ContentDisplay.RIGHT);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setPrefColumnCount(30);
        textField.setOnAction(event -> text.setText(textField.getText()));
        borderPane.setTop(label);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Demo");
        primaryStage.show();
    }
}
