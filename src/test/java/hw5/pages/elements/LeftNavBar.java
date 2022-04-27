package hw5.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftNavBar {

    @FindBy(css = "ul.sidebar-menu>li")
    private List<WebElement> buttons;

    public LeftNavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getButton(int index) {
        return buttons.get(index);
    }

    public List<WebElement> getButtons() {
        return buttons;
    }
}
