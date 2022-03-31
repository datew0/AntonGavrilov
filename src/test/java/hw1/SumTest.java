package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends CalculatorTest {

    @DataProvider
    public static Object[][] testLongData() {
        return new Object[][]{{1, 2, 3}, {5, 9, 14}};
    }

    @Test(dataProvider = "testLongData")
    public void testLong(long op1, long op2, long res) {
        long actual = calc.sum(op1, op2);
        Assert.assertEquals(actual, res);
    }

    @DataProvider
    public static Object[][] testDoubleData() {
        return new Object[][]{{4.3, 2.2, 6.5}, {5.1, 3, 8.1}};
    }

    @Test(dataProvider = "testDoubleData")
    public void testDouble(double op1, double op2, double res) {
        double actual = calc.sum(op1, op2);
        Assert.assertEquals(actual, res);
    }
}
