package hw5.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsGroup {

    @FindAll({
            @FindBy(xpath = "//label[contains(.,\"Water\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Earth\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Wind\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Fire\")]/input")
    })
    private List<WebElement> variants;


    public ElementsGroup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCBox(String label) {
        switch (label) {
            case "Water":
                return variants.get(0);
            case "Earth":
                return variants.get(1);
            case "Wind":
                return variants.get(2);
            case "Fire":
                return variants.get(3);
            default:
                System.err.println("No checkbox with such label: " + label);
                return null;
        }
    }
}
