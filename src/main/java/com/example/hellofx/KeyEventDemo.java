package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
    int xCoord = 250;
    int yCoord = 250;

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(250, 250, "*");
        text.setScaleX(5);
        text.setScaleY(5);
        text.setFont(Font.font("SansSerif", FontWeight.BOLD, 12));
        Pane pane = new Pane();
        pane.getChildren().add(text);
        text.setOnKeyPressed(keyEvent -> {
                switch (keyEvent.getCode()) {
                    case UP:
                        yCoord -= 10;
                        break;
                    case DOWN:
                        yCoord += 10;
                        break;
                    case LEFT:
                        xCoord -= 10;
                        break;
                    case RIGHT:
                        xCoord += 10;
                        break;
                    default:
                        try {
                            if (Character.isLetterOrDigit(keyEvent.getText().charAt(0))) {
                                text.setText(keyEvent.getText());
                            }
                            System.out.println(keyEvent.getText() + "   " + keyEvent.getCharacter());
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("keyEvent.getText()");
                        }
                        System.out.println(keyEvent.getText());
                        break;
                }

//            if (keyEvent.getCode() == KeyCode.UP) {
//                yCoord -= 10;
//            } else if (keyEvent.getCode() == KeyCode.DOWN) {
//                yCoord += 10;
//            }
//            if (keyEvent.getCode() == KeyCode.LEFT) {
//                xCoord -= 10;
//            }
//            if (keyEvent.getCode() == KeyCode.RIGHT) {
//                xCoord += 10;
//            } else {
//                try {
//                    if (Character.isLetterOrDigit(keyEvent.getText().charAt(0)))
//                        text.setText(keyEvent.getText());
//                    System.out.println(keyEvent.getText()+"   "+keyEvent.getCharacter());
//                } catch (StringIndexOutOfBoundsException e) {
//                    System.out.println("keyEvent.getText()");
//                }
//                System.out.println(keyEvent.getText());
//            }
            text.setX(xCoord);
            text.setY(yCoord);
        });
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Key Event Demo");
        primaryStage.show();
        text.requestFocus();
    }
}
