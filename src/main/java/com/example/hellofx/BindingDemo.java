package com.example.hellofx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingDemo {
    public static void main(String[] args){
        DoubleProperty d1 = new SimpleDoubleProperty(7);
        DoubleProperty d2 = new SimpleDoubleProperty(3);
        System.out.println("d1 value is "+d1.getValue()+" and d2 value is "+d2.getValue());
        d1.bindBidirectional(d2);
        System.out.println("d1 value is "+d1.getValue()+" and d2 value is "+d2.getValue());
        d2.setValue(12);
        System.out.println("d1 value is "+d1.getValue()+" and d2 value is "+d2.getValue());
        d1.setValue(23);
        System.out.println("d1 value is "+d1.getValue()+" and d2 value is "+d2.getValue());
    }
}
