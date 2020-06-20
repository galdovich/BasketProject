package com.galdovich.day2.service;

import com.galdovich.day2.entity.Ball;
import com.galdovich.day2.entity.Basket;
import com.galdovich.day2.entity.Color;
import com.galdovich.day2.exception.CustomException;

public class BasketService {

    public int countSameColorBalls(Basket basket, Color ballColor) throws CustomException{
        int count = 0;
        if (basket == null){
            throw new CustomException("Null Exception in \"countSameColorBalls\" method");
        }else {
            for (Ball boll: basket.getBallsArray()) {
                if (boll.getColor() == ballColor) {
                        count++;
                }
            }
        }
        return count;
    }

    public double countBallsWeight(Basket basket) throws CustomException{
        double weight = 0;
        if (basket == null){
            throw new CustomException("Null Exception in \"countBallsWeight\" method");}
        else {
            for (Ball ball: basket.getBallsArray()) {
                weight += ball.getWeight();
            }
        }
        return weight;
    }

    public double countBasketFreeSpace (Basket basket) throws CustomException{
        double usedSpace = 0;
        if (basket == null){
            throw new CustomException("Null Exception in \"countBasketFreeSpace\" method");}
        else {
            for (Ball ball: basket.getBallsArray()){
                usedSpace += ball.getVolume();
            }
        }
        return Math.round(basket.getSpaceCapacity() - usedSpace);
    }
}
