package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class SeleniumTest {
    protected WebDriver driver;
    protected Properties properties = new Properties();

    @BeforeSuite
    public void initSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            properties.load(new FileReader("src/test/resources/user.properties"));
        } catch (IOException e) {
            System.err.println("Loading properties from file failed!");
        }
    }

    @AfterMethod
    public void clean() {
        driver.quit();
        driver = null;
    }
}
