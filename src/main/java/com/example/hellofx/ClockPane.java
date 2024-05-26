package com.example.hellofx;

import javafx.scene.layout.Pane;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private double w;
    private double h;

    public ClockPane() {
        setCurrentTime();
        w = 700;
        h = 700;
    }

    public ClockPane(int hour, int minute, int second, double w, double h) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.w = w;
        this.h = h;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public double getH() {
        return h;
    }

    public double getW() {
        return w;
    }

    public void setCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }
}
