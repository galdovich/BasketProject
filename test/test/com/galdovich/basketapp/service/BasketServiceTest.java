package test.com.galdovich.day2.service;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.Basket;
import com.galdovich.basketapp.entity.Color;
import com.galdovich.basketapp.entity.Size;
import com.galdovich.basketapp.exception.CustomException;
import com.galdovich.basketapp.service.BasketService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {
    private BasketService basketService;

    @BeforeTest
    public void setUp(){
        basketService = new BasketService();
    }

    @DataProvider(name = "dataForCountBallsWeight")
    public Object[][] dataForCountBallsWeight() {
        Basket emptyBasket = new Basket();
        Basket fullBasket = new Basket();
        Basket average = new Basket();
        Ball balll = new Ball(Color.RED, Size.BIG, 3.9);
        Ball ball2 = new Ball(Color.GREEN, Size.BIG, 4.1);
        fullBasket.addBall(balll);
        fullBasket.addBall(ball2);
        average.addBall(balll);
        return new Object[][]{
                {emptyBasket, 0.0},
                {fullBasket, 8.0},
                {average, 3.9}
        };
    }

    @Test(dataProvider = "dataForCountBallsWeight")
    public void testCountBallsWeight(Basket basket, double expected) {
        try{
            double actual = basketService.countBallsWeight(basket);
            assertEquals(actual, expected);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test(priority = 2,
            expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Null Exception in \"countBallsWeight\" method")
    public void testCountBallsWeightException() throws CustomException{
        Basket basket = null;
        basketService.countBallsWeight(basket);
    }

    @DataProvider(name = "dataForCountSameColorBalls")
    public Object[][] dataForCountSameColorBalls() {
        Basket basket = new Basket();
        Ball balll = new Ball(Color.GREEN, Size.BIG, 4.4);
        Ball ball2 = new Ball(Color.RED, Size.BIG, 4.1);
        Ball ball3 = new Ball(Color.GOLD, Size.SMALL, 1.1);
        Ball ball4 = new Ball(Color.GREEN, Size.SMALL, 1.1);
        basket.addBall(balll);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        return new Object[][]{
                {basket, Color.BLUE, 0},
                {basket, Color.GOLD, 1},
                {basket, Color.GREEN, 2}
        };
    }

    @Test(dataProvider = "dataForCountSameColorBalls")
    public void testCountSameColorBalls(Basket basket, Color color, int expected) {
        try{
            int actual = basketService.countSameColorBalls(basket, color);
            assertEquals(actual, expected);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test(priority = 2,
            expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Null Exception in \"countSameColorBalls\" method")
    public void testCountSameColorBallsException() throws CustomException{
        Basket basket = null;
        basketService.countSameColorBalls(basket, Color.BLACK);
    }

    @DataProvider(name = "dataForCountBasketFreeSpace")
    public Object[][] dataForCountBasketFreeSpace() {
        Basket averageBasket = new Basket(20000);
        Basket bigBasket = new Basket(29000);
        Basket smallBasket = new Basket(11000);
        Ball ball1 = new Ball(Color.BLACK, Size.BIG, 4.2);
        Ball ball2 = new Ball(Color.GOLD, Size.AVERAGE, 2.3);
        Ball ball3 = new Ball(Color.PURPLE, Size.SMALL, 1.5);
        bigBasket.addBall(ball1);
        bigBasket.addBall(ball2);
        averageBasket.addBall(ball3);
        smallBasket.addBall(ball3);
        return new Object[][]{
                {bigBasket, 23044.0},
                {averageBasket, 19935.0},
                {smallBasket,  10935.0}
        };
    }

    @Test(dataProvider = "dataForCountBasketFreeSpace")
    public void testCountBasketFreeSpace(Basket  basket, double expected) {
        try{
            double actual = basketService.countBasketFreeSpace(basket);
            assertEquals(actual, expected);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test(priority = 2,
            expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Null Exception in \"countBasketFreeSpace\" method")
    public void testCountBasketFreeSpaceException() throws CustomException{
        Basket basket = null;
        basketService.countBasketFreeSpace(basket);
    }
}