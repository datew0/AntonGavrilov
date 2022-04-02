package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends CalculatorTest {

    @DataProvider
    public static Object[][] testLongSumData() {
        return new Object[][]{{1, 2, 3}, {5, 9, 14}};
    }

    @Test(dataProvider = "testLongSumData")
    public void testLongSum(long op1, long op2, long res) {
        long actual = calc.sum(op1, op2);
        Assert.assertEquals(actual, res);
    }

    @DataProvider
    public static Object[][] testDoubleSumData() {
        return new Object[][]{{4.3, 2.2, 6.5}, {5.1, 3, 8.1}};
    }

    @Test(dataProvider = "testDoubleSumData")
    public void testDoubleSum(double op1, double op2, double res) {
        double actual = calc.sum(op1, op2);
        Assert.assertEquals(actual, res);
    }
}
