package test.com.galdovich.day2.creator;

import com.galdovich.basketapp.creator.BasketCreator;
import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.Basket;
import com.galdovich.basketapp.entity.Color;
import com.galdovich.basketapp.entity.Size;
import com.galdovich.basketapp.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    private BasketCreator basketCreator;

    @BeforeTest
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @DataProvider(name = "dataForCreateBasket")
    @Test
    public Object[][] dataForCreateBasket() {
        Basket basket1 = new Basket(20000);
        Basket basket2 = new Basket(19000);
        Basket basket3 = new Basket(15000);
        Ball ball1 = new Ball(Color.BLACK, Size.BIG, 5.4);
        Ball ball2 = new Ball(Color.GREEN, Size.AVERAGE, 4.1);
        Ball ball3 = new Ball(Color.PURPLE, Size.SMALL, 1.0);
        basket1.addBall(ball1);
        basket2.addBall(ball2);
        basket3.addBall(ball3);
        List <Ball> ballList1 = new ArrayList<>();
        List <Ball> ballList2 = new ArrayList<>();
        List <Ball> ballList3 = new ArrayList<>();
        ballList1.add(ball1);
        ballList2.add(ball2);
        ballList3.add(ball3);
        return new Object[][]{
                {ballList1, 20000, basket1},
                {ballList2, 19000, basket2},
                {ballList3, 15000, basket3}
        };
    }

    @Test(dataProvider = "dataForCreateBasket")
    public void testCreateBasket(List<Ball> ballList, int spaceCapacity, Basket expectedBasket) {
        try{
            Basket basket = basketCreator.createBasket(ballList, spaceCapacity);
            assertEquals(basket, expectedBasket);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "BallList volume more than Basket spaceCapacity>")
    public void testCreateBasketException() throws CustomException {
        List<Ball> ballList = new ArrayList<>(){};
        ballList.add(new Ball(Color.BLACK, Size.BIG, 4));
        ballList.add(new Ball(Color.GREEN, Size.BIG, 2));
        ballList.add(new Ball(Color.PURPLE, Size.BIG, 5));
        basketCreator.createBasket(ballList, 11000);
    }
}