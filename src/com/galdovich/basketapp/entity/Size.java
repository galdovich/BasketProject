package com.galdovich.basketapp.entity;

public enum Size {

    BIG(20), AVERAGE(15), SMALL(5);

    private double diameter;

    Size (double diameter){
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }
}
