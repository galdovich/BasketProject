package com.galdovich.basketapp.entity;

public class Ball {
    private Color color;
    private Size size;
    private double weight;

    /** Default color is Black, default size is Average and default weight is 2*/
    public Ball() {
        color = Color.BLACK;
        size = Size.AVERAGE;
        weight = 2;
    }

    public Ball(Color color, Size size, double weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    /** Method by a given diameter calculates the volume of the ball*/
    public double getVolume() {
        double volume = Math.pow(size.getDiameter(),3)*Math.PI/6;
        return Math.round(volume);
    }

    public double getWeight(){
        return weight;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor (){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return size == ball.size &&
                color == ball.color &&
                weight == ball.weight;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = color != null ? color.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("color=").append(color);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
