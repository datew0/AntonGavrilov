package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class CalculatorTest {
    protected Calculator calc;

    @BeforeMethod
    public void init() {
        calc = new Calculator();
    }

    @AfterMethod
    public void clean() {
        calc = null;
    }
}
