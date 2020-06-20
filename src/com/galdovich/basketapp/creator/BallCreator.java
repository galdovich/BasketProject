package com.galdovich.basketapp.creator;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.Color;
import com.galdovich.basketapp.entity.Size;
import com.galdovich.basketapp.exception.CustomException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    private Random random = new Random();

    public List<Ball> createBallsList(int ballsAmont) throws CustomException{
        if (ballsAmont <= 0) {
            throw new CustomException("The variable mustn't be positive");
        }
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballsAmont; i++){
            balls.add(new Ball(getRandomColor(),getRandomSize(), getRandomWeight()));
        }
        return balls;
    }

    private Color getRandomColor(){
        Color[] colors = {Color.BLUE, Color.RED, Color.WHITE, Color.GREEN,
                Color.ORANGE, Color.PURPLE, Color.GOLD,
                Color.BLACK};
        int colorNumber = random.nextInt(colors.length);
        return colors[colorNumber];
    }

    private Size getRandomSize(){
        Size[] sizes = {Size.BIG, Size.AVERAGE, Size.SMALL};
        int sizeNumber = random.nextInt(sizes.length);
        return sizes[sizeNumber];
    }

    private int getRandomWeight(){
        double a = Math.random()*15 + 1;
        return (int) a;
    }
}
