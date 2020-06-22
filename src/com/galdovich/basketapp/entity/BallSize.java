package com.galdovich.basketapp.entity;

public enum BallSize {

    BIG(20), AVERAGE(15), SMALL(5);

    private double diameter;

    BallSize(double diameter){
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }
}
