package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends CalculatorTest {

    @DataProvider
    public static Object[][] testIntegerMultData() {
        return new Object[][]{{5, 7, 35}, {3, 3, 9}};
    }

    @Test(dataProvider = "testIntegerMultData")
    public void testIntegerMult(long op1, long op2, long res) {
        long actual = calc.mult(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testDoubleMultData() {
        return new Object[][]{{1.1, 2.2, 2.42}, {5.1, 3.0, 15.3}};
    }

    @Test(dataProvider = "testDoubleMultData")
    public void testDouble(double op1, double op2, double res) {
        double actual = calc.mult(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }
}
