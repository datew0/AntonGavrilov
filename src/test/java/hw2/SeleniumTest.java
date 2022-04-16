package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class SeleniumTest {
    protected WebDriver driver;

    @BeforeSuite
    public void initSuite() {
        String driverPath = getClass().getClassLoader().getResource("chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
