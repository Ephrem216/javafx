package com.example.hellofx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
    private double w;
    private double h;
    private double radius;
    private double x;
    private double y;
    private Circle ball;

    public BallPane(double w, double h, double radius, double x) {
        this.w = w;
        this.h = h;
        this.radius = radius;
        this.x = x;
        setY();
        ball = new Circle(x,this.h - y + radius,radius);
        ball.setStroke(Color.color(	.063, .094, .0125));
        ball.setFill(Color.color(.996, .906, .082));
        getChildren().add(ball);
    }

    public BallPane() {
        this(1400, 700, 50, 50);
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setX(double x) {
        this.x = x;
        setY();
        relocateBall();
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private void setY() {
        y = (h * ((w - x + 50) / w)) * Math.abs(Math.cos(Math.PI * (x - 50) / 180)) + 100;
    }

    public void relocateBall(){
        ball.setCenterX(x);
        ball.setCenterY(this.h - y + radius);
    }
}
