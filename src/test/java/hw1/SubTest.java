package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {
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
    public static Object[][] testLongData() {
        return new Object[][]{{5, 2, 3}, {1, 9, -8}};
    }

    @Test(dataProvider = "testLongData")
    public void testLong(long op1, long op2, long res) {
        long actual = calc.sub(op1,op2);
        Assert.assertEquals(actual, res);
    }

    @DataProvider
    public static Object[][] testDoubleData() {
        return new Object[][]{{5.5, 1.1, 4.4}, {-1.5, 4.9, -6.4}};
    }

    @Test(dataProvider = "testDoubleData")
    public void testDouble(double op1, double op2, double res) {
        double actual = calc.sub(op1, op2);
        Assert.assertEquals(actual, res);
    }
}
