package com.galdovich.day2.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final double spaceCapacity;
    private final List<Ball> ballsArray;

    /** Default volumeCapacity equals 10000 cubic centimeters.
     * Can put 2 BIG size balls or 5 AVERAGE size balls or 19 SMALL size balls. */
    public Basket() {
        this.ballsArray = new ArrayList<>();
        this.spaceCapacity = 10000;
    }

    /** SpaceCapacity measured in cubic centimeters */
    public Basket(int spaceCapacity) {
        this.ballsArray = new ArrayList<>();
        this.spaceCapacity = spaceCapacity;
    }

    public Basket (List<Ball> balls, double spaceCapacity){
        ballsArray = balls;
        this.spaceCapacity = spaceCapacity;
    }

    public boolean addBall(Ball newBall) {
        if (possibleToAdd(newBall)) {
            ballsArray.add(newBall);
            return true;
        } else {
            return false;
        }
    }

    /** Return false if adding Ball volume more than basket free space */
    private boolean possibleToAdd(Ball newBall){
        double usedSpace = 0;
        for (Ball ball: ballsArray){
            usedSpace += ball.getVolume();
        }
        if (newBall == null){
            return false;
        }
        return newBall.getVolume() + usedSpace <= spaceCapacity;
    }

    public boolean removeBall(Ball removableBall) {
        if (removableBall == null || ballsArray.indexOf(removableBall) == -1){
            return false;
        }else {
            ballsArray.remove(removableBall);
            return true;
        }
    }

    public void clearBasket() {
        this.ballsArray.clear();
    }

    public Ball getBall(int index) {
        return ballsArray.get(index);
    }

    public List<Ball> getBallsArray (){
        return ballsArray;
    }

    public double getSpaceCapacity() {
        return spaceCapacity;
    }

    /** Method compares baskets by capacity */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket newBasket = (Basket) o;
        return spaceCapacity == newBasket.spaceCapacity;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(spaceCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ballsArray != null ? ballsArray.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("spaceCapacity=").append(spaceCapacity);
        sb.append(", ballsArray=").append(ballsArray);
        sb.append('}');
        return sb.toString();
    }
}
