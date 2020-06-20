package com.galdovich.day2.entity;

public enum Color {
    BLUE("Blue"),
    RED("Red"),
    WHITE("White"),
    GREEN("Green"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    GOLD("Gold"),
    BLACK("Black");

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
