package com.galdovich.basketapp.entity;

public class Ball {
    private BallColor ballColor;
    private BallSize ballSize;
    private double weight;
    private static final BallColor DEFAULT_COLOR = BallColor.BLACK;
    private static final BallSize DEFAULT_SIZE = BallSize.AVERAGE;
    private static final int DEFAULT_WEIGHT = 2;

    public Ball() {
        ballColor = DEFAULT_COLOR;
        ballSize = DEFAULT_SIZE;
        weight = DEFAULT_WEIGHT;
    }

    public Ball(BallColor ballColor, BallSize ballSize, double weight) {
        this.ballColor = ballColor;
        this.ballSize = ballSize;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public BallSize getBallSize() {
        return ballSize;
    }

    public BallColor getBallColor(){
        return ballColor;
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
        return ballSize == ball.ballSize &&
                ballColor == ball.ballColor &&
                weight == ball.weight;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ballColor != null ? ballColor.hashCode() : 0;
        result = 31 * result + (ballSize != null ? ballSize.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("ballColor=").append(ballColor);
        sb.append(", ballSize=").append(ballSize);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
