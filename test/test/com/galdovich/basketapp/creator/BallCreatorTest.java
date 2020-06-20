package test.com.galdovich.day2.creator;

import com.galdovich.basketapp.creator.BallCreator;
import com.galdovich.basketapp.entity.Ball;
import com.galdovich.basketapp.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {
    private BallCreator ballCreator;

    @BeforeTest
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @Test
    public void testCreateBallsListPositive() {
        try{
            List<Ball> list = ballCreator.createBallsList(4);
            int actual = list.size();
            int expected = 4;
            assertEquals(actual, expected);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test
    public void testCreateBallsListNegative() {
        try{
            List<Ball> list = ballCreator.createBallsList(4);
            int actual = list.size();
            int expected = 42;
            assertNotEquals(actual, expected);
        }catch (CustomException exc){fail(exc.getMessage());}
    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "The variable mustn't be positive")
    public void testCreateBallsListException () throws CustomException {
        ballCreator.createBallsList(-2);
    }
}