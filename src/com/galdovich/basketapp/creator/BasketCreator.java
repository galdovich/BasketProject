package com.galdovich.basketapp.creator;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.Basket;
import com.galdovich.basketapp.exception.CustomException;

import java.util.List;

public class BasketCreator {

    public Basket createBasket (List<Ball> ballList, int spaceCapacity) throws CustomException {
        Basket basket = new Basket(spaceCapacity);
        if (!checkAvailableVolume(basket, ballList)){
            throw new CustomException("BallList volume more than Basket spaceCapacity>");
        }else {
            for (Ball ball: ballList){
                basket.addBall(ball);
            }
        }
        return basket;
    }

    private boolean checkAvailableVolume(Basket basket, List<Ball> ballList){
        if (basket == null){
            return false;
        }
        double volume = 0;
        for (Ball ball: ballList){
            volume += ball.getVolume();
        }
        return volume <= basket.getSpaceCapacity();
    }
}
