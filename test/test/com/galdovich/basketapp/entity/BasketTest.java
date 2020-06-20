package test.com.galdovich.day2.entity;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.Basket;
import com.galdovich.basketapp.entity.Color;
import com.galdovich.basketapp.entity.Size;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketTest {

    @DataProvider(name = "dataForTestAddBall")
    public Object[][] dataForTestAddBall() {
        Basket emptyBasket = new Basket( );
        Basket fullBasket = new Basket();
        Ball ball = new Ball(Color.RED, Size.BIG, 3.9);
        Ball bal2 = new Ball(Color.GREEN, Size.BIG, 4.1);
        fullBasket.addBall(ball);
        fullBasket.addBall(bal2);
        return new Object[][]{
                {new Ball(Color.BLACK, Size.BIG, 4.1),
                        fullBasket, false},
                {new Ball(Color.GREEN, Size.AVERAGE, 1.3),
                        emptyBasket, true},
                {new Ball(Color.PURPLE, Size.AVERAGE, 2.2),
                        fullBasket, false}
        };
    }

    @Test(dataProvider = "dataForTestAddBall")
    public void testAddBall(Ball ball, Basket basket,
                        boolean expectedResult) {
        boolean actualResult = basket.addBall(ball);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForRemoveBallTest")
    public Object[][] dataForRemoveTest() {
        Basket basket = new Basket();
        Ball ball = new Ball(Color.RED, Size.BIG, 3.9);
        Ball bal2 = new Ball(Color.GREEN, Size.BIG, 4.1);
        Ball bal3 = new Ball(Color.PURPLE, Size.SMALL, 1.1);
        basket.addBall(ball);
        basket.addBall(bal2);
        return new Object[][]{
                {basket, ball, true},
                {basket, bal2, true},
                {basket, bal3, false},
        };
    }

    @Test(dataProvider = "dataForRemoveBallTest")
    public void testRemove(Basket basket, Ball removableBall,
                           boolean expectedResult) {
        boolean actualResult = basket.removeBall(removableBall);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForGetBallTest")
    public Object[][] dataForGetBallTest() {
        Basket basket = new Basket(25000);
        Ball ball1 = new Ball(Color.RED, Size.SMALL, 2.1);
        Ball ball2 = new Ball(Color.GREEN, Size.AVERAGE, 3.1);
        Ball ball3 = new Ball(Color.PURPLE, Size.SMALL, 1.1);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        return new Object[][]{
                {basket, 0, ball1},
                {basket, 1, ball2},
                {basket, 2, ball3}
        };
    }

    @Test(dataProvider = "dataForGetBallTest")
    public void testGetBallTest(Basket basket, int index, Ball expectedResult) {
        Ball actualResult = basket.getBall(index);
        assertEquals(actualResult, expectedResult);
    }
}