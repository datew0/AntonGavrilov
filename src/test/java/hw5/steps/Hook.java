package hw5.steps;

import hw5.pages.DifferentElementsPage;
import hw5.pages.IndexPage;
import hw5.pages.UserTablePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static hw5.steps.BaseStep.*;

public class Hook {
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        indexPage = PageFactory.initElements(driver, IndexPage.class);
        diffElemPage = PageFactory.initElements(driver, DifferentElementsPage.class);
        userTablePage = PageFactory.initElements(driver, UserTablePage.class);

        try {
            properties.load(new FileReader("src/test/resources/user.properties"));
        } catch (IOException e) {
            System.err.println("Loading properties from file failed!");
        }
    }

    @After
    public void clean() {
        driver.quit();
        driver = null;
    }
}
