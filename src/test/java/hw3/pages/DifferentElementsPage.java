package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[contains(.,\"Water\")]/input")
    private WebElement waterCBox;


    @FindBy(xpath = "//label[contains(.,\"Wind\")]/input")
    private WebElement windCBox;

    @FindBy(xpath = "//label[contains(.,\"Selen\")]/input")
    private WebElement selenRadioBtn;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownMenu;

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
    private LogComponent logComponent;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        logComponent = new LogComponent(driver);
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public WebElement getWaterCBox() {
        return waterCBox;
    }

    public WebElement getWindCBox() {
        return windCBox;
    }

    public WebElement getSelenRadioBtn() {
        return selenRadioBtn;
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }
}
