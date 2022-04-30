package hw5.steps;

import hw5.pages.DifferentElementsPage;
import hw5.pages.IndexPage;
import hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public abstract class BaseStep {
    public static WebDriver driver;
    public static Properties properties = new Properties();

    public static IndexPage indexPage;
    public static DifferentElementsPage diffElemPage;
    public static UserTablePage userTablePage;

    public BaseStep() {
    }
}
