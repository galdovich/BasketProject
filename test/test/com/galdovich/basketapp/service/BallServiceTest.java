package test.com.galdovich.basketapp.service;

import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.entity.BallColor;
import com.galdovich.basketapp.entity.BallSize;
import com.galdovich.basketapp.service.BallService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BallServiceTest {
    private BallService ballService;

    @BeforeTest
    public void setUp(){
        ballService = new BallService();
    }

    @DataProvider(name = "dataForCountBallVolume")
    public Object[][] dataForCountBallVolume() {
        Ball ball1 = new Ball(BallColor.GREEN, BallSize.AVERAGE, 2);
        Ball ball2 = new Ball(BallColor.RED, BallSize.BIG, 2);
        Ball ball3 = new Ball(BallColor.BLACK, BallSize.SMALL, 1.0);
        return new Object[][]{
                {ball1, 1767.0},
                {ball2, 4189.0},
                {ball3, 65.0}
        };
    }

    @Test(dataProvider = "dataForCountBallVolume")
    public void testCountBallVolume(Ball ball, double expected){
        double actual = ballService.countBallVolume(ball);
        assertEquals(actual, expected);
    }
}
