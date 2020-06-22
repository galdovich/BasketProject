package com.galdovich.basketapp.service;

import com.galdovich.basketapp.entity.Ball;

public class BallService {

    public double countBallVolume(Ball ball) {
        double diameter = ball.getBallSize().getDiameter();
        double volume = Math.pow(diameter,3) * Math.PI/6;
        return Math.round(volume);
    }
}
