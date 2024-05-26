package com.example.hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    public void start(Stage stage) {
        LoanPane pane = new LoanPane();
        pane.calculate.setOnAction(event -> pane.calculate());
        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Loan Calculator");
        stage.show();
    }
}

class LoanPane extends GridPane {
    TextField fieldRate;
    TextField fieldYears;
    TextField fieldAmount;
    TextField fieldMonthlyPayment;
    TextField fieldTotalPayment;
    Button calculate;

    public LoanPane() {
        super(6, 2);
        Label labelRate = new Label("Annual Interest Rate:");
        Label labelYears = new Label("Number of Years:");
        Label labelAmount = new Label("Loan Amount:");
        Label labelMonthlyPayment = new Label("Monthly Payment:");
        Label labelTotalPayment = new Label("Total Payment:");
        fieldRate = new TextField("4.5");
        fieldYears = new TextField("4");
        fieldAmount = new TextField("5000");
        fieldMonthlyPayment = new TextField("$114.02");
        fieldTotalPayment = new TextField("$5472.84");
        fieldMonthlyPayment.setEditable(false);
        fieldTotalPayment.setEditable(false);
        fieldTotalPayment.setAlignment(Pos.CENTER_RIGHT);
        fieldMonthlyPayment.setAlignment(Pos.CENTER_RIGHT);
        fieldRate.setAlignment(Pos.CENTER_RIGHT);
        fieldYears.setAlignment(Pos.CENTER_RIGHT);
        fieldAmount.setAlignment(Pos.CENTER_RIGHT);
        calculate = new Button("Calculate");
        add(labelRate, 0, 0);
        add(fieldRate, 1, 0);
        add(labelYears, 0, 1);
        add(fieldYears, 1, 1);
        add(labelAmount, 0, 2);
        add(fieldAmount, 1, 2);
        add(labelMonthlyPayment, 0, 3);
        add(fieldMonthlyPayment, 1, 3);
        add(labelTotalPayment, 0, 4);
        add(fieldTotalPayment, 1, 4);
        add(calculate, 1, 5);
        setHalignment(calculate, HPos.RIGHT);
        setAlignment(Pos.CENTER);
    }

    public void calculate() {
        double annualInterestRate = Double.parseDouble(fieldRate.getText());
        int numberOfYears = Integer.parseInt(fieldYears.getText());
        double loanAmount = Double.parseDouble(fieldAmount.getText());
        double monthlyPayment;
        double totalPayment;
        double monthlyInterestRate = annualInterestRate / 1200;
        monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        totalPayment = monthlyPayment * 12 * numberOfYears;
        fieldMonthlyPayment.setText(String.format("$%.2f",monthlyPayment));
        fieldTotalPayment.setText(String.format("$%.2f",totalPayment));
//        return new Payment(totalPayment, monthlyPayment);
    }
}

//class Payment {
//    double total;
//    double monthly;
//
//    Payment(double total, double monthly) {
//        this.total = total;
//        this.monthly = monthly;
//    }
//}