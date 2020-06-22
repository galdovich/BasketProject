package com.galdovich.basketapp.entity;

public enum BallColor {
    BLUE("Blue"),
    RED("Red"),
    WHITE("White"),
    GREEN("Green"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    GOLD("Gold"),
    BLACK("Black");

    private final String colorName;

    BallColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
