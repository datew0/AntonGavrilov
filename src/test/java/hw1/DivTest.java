package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest extends CalculatorTest {

    @DataProvider
    public static Object[][] testIntegerDivData() {
        return new Object[][]{{24, 6, 4}, {321, 3, 107}};
    }

    @Test(dataProvider = "testIntegerDivData")
    public void testIntegerDiv(long op1, long op2, long res) {
        long actual = calc.div(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testDoubleDivData() {
        return new Object[][]{{9.9, 3.3, 3}, {15.3, 3.3, 4.636}};
    }

    @Test(dataProvider = "testDoubleDivData")
    public void testDoubleDiv(double op1, double op2, double res) {
        double actual = calc.div(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testByZeroDivData() {
        return new Object[][]{{9, 0, 0}, {0, 0, 0}};
    }

    @Test(dataProvider = "testByZeroDivData")
    public void testByZeroDiv(long op1, long op2, long res) {
        Assert.assertThrows(NumberFormatException.class, () -> {
            calc.div(op1, op2);
        });
    }
}
