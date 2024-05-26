package com.example.hellofx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    protected final int O_TURN = 0;
    protected final int X_TURN = 1;
    protected final int TERMINATE = 2;
    protected int turn = O_TURN;

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();
        Text[] text = {new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),
                new Text(""),};
        Font font = Font.font("verdana", 160);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                flowPane.setStyle("-fx-border-color:#cc8a56;-fx-border-width:3");
                StackPane stackPane = new StackPane(text[i + j + i * 2]);
                stackPane.setPrefWidth(230);
                stackPane.setPrefHeight(230);
                stackPane.setStyle("-fx-border-color:#cc8a56;-fx-border-width:5;-fx-background-color:#ebe5d9");
                flowPane.getChildren().add(stackPane);
            }
        flowPane.setPadding(new Insets(1));
        Text messageText = new Text();
        HBox hBox = new HBox(messageText);
        flowPane.getChildren().add(hBox);
        Scene scene = new Scene(flowPane, 700, 750);
        ObservableList<Node> observableList = flowPane.getChildren();
        for (Node child : observableList) {
            child.setOnMouseClicked(mouseEvent -> {
                if (text[observableList.indexOf(child)].getText().isEmpty()) {
                    if (turn == O_TURN) {
                        text[observableList.indexOf(child)].setText("O");
                        text[observableList.indexOf(child)].setStyle("-fx-font-size:160;-fx-fill:#0359ae");
                        text[observableList.indexOf(child)].setFont(font);
                        turn = X_TURN;
                    } else if (turn == X_TURN) {
                        text[observableList.indexOf(child)].setText("X");
                        text[observableList.indexOf(child)].setStyle("-fx-font-size:160;-fx-fill:#14b09b");
                        text[observableList.indexOf(child)].setFont(font);
                        turn = O_TURN;
                    }
                }

                String winner = getWinner(text);
                if (winner.equals("X") || winner.equals("O") || winner.equals("D")) {
                    turn = TERMINATE;
                }

                if (turn == TERMINATE) {
                    String message;
                    if (winner.equals("X")) {
                        message = "X won! The game is over.";
                        messageText.setStyle("-fx-font-size:30;-fx-fill:#14b09b");
                    } else if (winner.equals("O")) {
                        message = "O won! The game is over.";
                        messageText.setStyle("-fx-font-size:30;-fx-fill:#0359ae");
                    }else{
                        message = "Draw! The game is over.";
                        messageText.setStyle("-fx-font-size:30;-fx-fill:#cc8a56");
                    }
                    messageText.setText(message);
                }
            });
        }
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getWinner(Text[] textList) {
        String[][] board = {
                {textList[0].getText(), textList[1].getText(), textList[2].getText()},
                {textList[3].getText(), textList[4].getText(), textList[5].getText()},
                {textList[6].getText(), textList[7].getText(), textList[8].getText()}
        };

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 1; j < 3; j++)
                if (!board[i][j].isEmpty() && board[i][j].equals(board[i][j - 1])) {
                    count++;
                }
            if (count == 2)
                return board[i][0];

        }

        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int i = 1; i < 3; i++)
                if (!board[i][j].isEmpty() && board[i][j].equals(board[i - 1][j])) {
                    count++;
                }
            if (count == 2)
                return board[0][j];

        }

        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
            return board[0][0];
        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
            return board[1][1];

        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!board[i][j].isEmpty())
                    count++;
        if (count == 9)
            return "D";

        return "N";
    }
}
