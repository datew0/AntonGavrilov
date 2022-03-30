package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
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
        return new Object[][]{{24, 6, 4}, {321, 3, 107}};
    }

    @Test(dataProvider = "testIntegerData")
    public void testInteger(long op1, long op2, long res) {
        long actual = calc.div(op1,op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testDoubleData() {
        return new Object[][]{{9.9, 3.3, 3}, {15.3, 3.3, 4.636}};
    }

    @Test(dataProvider = "testDoubleData")
    public void testDouble(double op1, double op2, double res) {
        double actual = calc.div(op1, op2);
        double delta = 0.001;
        Assert.assertEquals(actual, res, delta);
    }

    @DataProvider
    public static Object[][] testByZeroData() {
        return new Object[][]{{9, 0, 0}, {0, 0, 0}};
    }

    @Test(dataProvider = "testByZeroData")
    public void testByZero(long op1, long op2, long res) {
        Assert.assertThrows(NumberFormatException.class, ()->{calc.div(op1,op2);});
    }
}
