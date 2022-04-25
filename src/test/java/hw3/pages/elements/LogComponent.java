package hw3.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogComponent {

    @FindBy(css = "ul.logs > li")
    List<WebElement> log;

    public LogComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLog() {
        return log;
    }
}
