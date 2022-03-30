package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {
    private Calculator calc;

    @BeforeMethod
    public void init() {
        calc = new Calculator();
    }

    @AfterMethod
    public void clean() {
        calc = null;
    }

    @DataProvider
    public static Object[][] testIntegerData() {
        return new Object[][]{{5, 7, 35}, {3, 3, 9}};
    }

    @Test(dataProvider = "testIntegerData")
    public void testInteger(long op1, long op2, long res) {
        long actual = calc.mult(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testDoubleData() {
        /* Considering that the result should be rounded */
        return new Object[][]{{1.1, 2.2, 2}, {5.1, 3.0, 15}};
    }

    @Test(dataProvider = "testDoubleData")
    public void testDouble(double op1, double op2, double res) {
        double actual = calc.mult(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }
}
