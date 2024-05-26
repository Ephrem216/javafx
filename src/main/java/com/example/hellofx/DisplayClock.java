package com.example.hellofx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DisplayClock extends Application {
    private ClockPane pane = new ClockPane();

    @Override
    public void start(Stage stage) {
        setupPane(pane.getW(),pane.getH());
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), event -> setupPane());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Scene scene = new Scene(pane, pane.getW(), pane.getH());
        stage.setScene(scene);
        stage.setTitle("Display Clock");
        stage.show();
        stage.setResizable(false);//cuz I am lazy....i am tired of setting up the window...30 mins wasted
    }

    public void setupPane(double... defaultWidth) {
        double width = defaultWidth.length > 0 ? defaultWidth[0] : pane.getWidth();
        double height = defaultWidth.length > 0 ? defaultWidth[1] : pane.getHeight();
        pane.getChildren().clear();
        pane.setCurrentTime();
        Circle circle = new Circle();
        circle.setCenterX(width / 2);
        circle.setCenterY(height / 2);
        circle.setRadius(300);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(30);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        Circle innerCircle = new Circle();
        innerCircle.setCenterX(width / 2);
        innerCircle.setCenterY(height / 2);
        innerCircle.setRadius(270);
        innerCircle.setFill(Color.WHITE);
        innerCircle.setStrokeWidth(30);
        innerCircle.setStroke(Color.color(.92, .92, .92));
        pane.getChildren().add(innerCircle);

        double t = 50;//strokeLength
        for (int i = 0; i < 60; i++) {
            double teta = (2 * Math.PI / 60) * i;
            double h = circle.getCenterX();
            double k = circle.getCenterY();
            double r = circle.getRadius();
            double x = h + r * Math.cos(teta);//stroke tip on the circumference for x
            double y = k + r * Math.sin(teta);//stroke tip on the circumference for y
            Line line;
            if (i % 5 == 0) {
                double p = x - ((t + 10) / r) * (x - h);//stroke tip on the other side for x
                double q = y - ((t + 10) / r) * (y - k);//stroke tip on the other side for y
                double u = x - ((t - 20) / r) * (x - h);//stroke near the tip on the circumference for x
                double v = y - ((t - 20) / r) * (y - k);//stroke near tip the circumference for y
                line = new Line(p, q, u, v);
                line.setStrokeWidth(5);
                int clockHour = (i / 5 + 3) % 12;
                if (clockHour == 0) clockHour = 12;
                double textCenterX = x - ((t + 50) / r) * (x - h);//center of the text for x
                double textCenterY = y - ((t + 50) / r) * (y - k);//center of the text for x
                Text text = new Text(clockHour + "");
                Font font = Font.font("Arial", 3);
                text.setFont(font);
                text.setScaleX(25);
                text.setScaleY(25);
                text.setLayoutX(textCenterX - (text.getLayoutBounds().getWidth()) / 2);
                text.setLayoutY(textCenterY - (text.getLayoutBounds().getHeight()) / 2);
                pane.getChildren().add(text);
            } else {
                double p = x - (t / r) * (x - h);//stroke tip on the other side for x
                double q = y - (t / r) * (y - k);//stroke tip on the other side for y
                double u = x - ((t - 20) / r) * (x - h);//stroke near the tip on the circumference for x
                double v = y - ((t - 20) / r) * (y - k);//stroke near tip the circumference for y
                line = new Line(p, q, u, v);
                line.setStrokeWidth(3);
            }
            Text quartzText = new Text("QUARTZ");
            Font quartzFont = Font.font("SansSerif Monospace", 24);
            quartzText.setFill(Color.color(.3, .3, .3));
            quartzText.setFont(quartzFont);
            quartzText.setLayoutX(circle.getCenterX() - (quartzText.getLayoutBounds().getWidth()) / 2);
            quartzText.setLayoutY(circle.getCenterY() + 100 - (quartzText.getLayoutBounds().getHeight()) / 2);
            pane.getChildren().add(quartzText);
            pane.getChildren().add(line);
        }

        double alpha = (((15 - pane.getHour()) % 12) * (Math.PI / 6));
        double sigma = ((double) (pane.getMinute()) / 60) * (Math.PI / 6);
        alpha -= sigma;
        double h = circle.getCenterX();
        double k = circle.getCenterY();
        double r = circle.getRadius();
        double x = h + r * Math.cos(alpha);//stroke tip on the circumference for x
        double xPrime = h - r * Math.cos(alpha);//stroke tip on the circumference for x
        double y = k - r * Math.sin(alpha);
        double yPrime = k + r * Math.sin(alpha);
        double endX = x - ((140) / r) * (x - h);
        double endY = y - ((140) / r) * (y - k);
        double startX = h + ((50) / r) * (xPrime - h);
        double startY = k + ((50) / r) * (yPrime - k);
        Line hourStick = new Line(startX, startY, endX, endY);
        hourStick.setStrokeWidth(15);
        pane.getChildren().add(hourStick);

        double betta = (Math.PI * (((75 - pane.getMinute()) % 60) * 6) / 180);
        double delta = ((double) (pane.getSecond()) / 60) * (Math.PI / 30);
        betta -= delta;
        x = h + r * Math.cos(betta);//stroke tip on the circumference for x
        xPrime = h - r * Math.cos(betta);//stroke tip on the circumference for x
        y = k - r * Math.sin(betta);
        yPrime = k + r * Math.sin(betta);
        endX = x - ((90) / r) * (x - h);
        endY = y - ((90) / r) * (y - k);
        startX = h + ((50) / r) * (xPrime - h);
        startY = k + ((50) / r) * (yPrime - k);
        Line minuteStick = new Line(startX, startY, endX, endY);
        minuteStick.setStrokeWidth(10);
        pane.getChildren().add(minuteStick);

        double gamma = (Math.PI * (((75 - pane.getSecond()) % 60) * 6) / 180);
        x = h + r * Math.cos(gamma);//stroke tip on the circumference for x
        xPrime = h - r * Math.cos(gamma);//stroke tip on the circumference for x
        y = k - r * Math.sin(gamma);
        yPrime = k + r * Math.sin(gamma);
        endX = x - ((70) / r) * (x - h);
        endY = y - ((70) / r) * (y - k);
        startX = h + ((80) / r) * (xPrime - h);
        startY = k + ((80) / r) * (yPrime - k);
        double startX1 = h + ((25) / r) * (xPrime - h);
        double startY2 = k + ((25) / r) * (yPrime - k);
        Line secondStick = new Line(startX, startY, endX, endY);
        Line trail = new Line(startX, startY, startX1, startY2);
        secondStick.setStrokeWidth(3);
        trail.setStrokeWidth(7);
        secondStick.setStroke(Color.color(0.8, 0, 0));
        trail.setStroke(Color.color(0.8, 0, 0));
        pane.getChildren().add(secondStick);
        pane.getChildren().add(trail);

        Circle dot = new Circle();
        dot.setCenterX(width / 2);
        dot.setCenterY(height / 2);
        dot.setRadius(10);
        dot.setFill(Color.color(0.8, 0, 0));
        dot.setStroke(Color.DARKRED);
        pane.getChildren().add(dot);
    }
}
