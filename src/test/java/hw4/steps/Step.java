package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Step {
    protected WebDriver driver;

    IndexPage indexPage;
    DifferentElementsPage diffElemPage;

    public Step(WebDriver driver) {
        this.driver = driver;
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        diffElemPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

}
