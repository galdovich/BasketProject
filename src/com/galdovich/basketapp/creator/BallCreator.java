package com.galdovich.basketapp.creator;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.BallColor;
import com.galdovich.basketapp.entity.BallSize;
import com.galdovich.basketapp.exception.CustomException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    private Random random = new Random();

    public List<Ball> createBallsList(int ballsAmount) throws CustomException{
        if (ballsAmount <= 0) {
            throw new CustomException("The variable mustn't be positive");
        }
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballsAmount; i++){
            balls.add(new Ball(getRandomColor(),getRandomSize(), getRandomWeight()));
        }
        return balls;
    }

    private BallColor getRandomColor(){
        BallColor[] ballColors = {BallColor.BLUE, BallColor.RED, BallColor.WHITE, BallColor.GREEN,
                BallColor.ORANGE, BallColor.PURPLE, BallColor.GOLD,
                BallColor.BLACK};
        int colorNumber = random.nextInt(ballColors.length);
        return ballColors[colorNumber];
    }

    private BallSize getRandomSize(){
        BallSize[] ballSizes = {BallSize.BIG, BallSize.AVERAGE, BallSize.SMALL};
        int sizeNumber = random.nextInt(ballSizes.length);
        return ballSizes[sizeNumber];
    }

    private int getRandomWeight(){
        double a = Math.random()*15 + 1;
        return (int) a;
    }
}
