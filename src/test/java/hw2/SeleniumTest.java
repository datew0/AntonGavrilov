package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class SeleniumTest {
    protected WebDriver driver;

    public SeleniumTest() {
        String driverPath = getClass().getClassLoader().getResource("chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void clean() {
        driver.close();
    }

    @AfterTest
    public void exit() {
        driver.quit();
        driver = null;
    }

}
