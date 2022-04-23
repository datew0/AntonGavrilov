package hw3.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MaterialsGroup {

    @FindAll({
            @FindBy(xpath = "//label[contains(.,\"Gold\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Silver\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Bronze\")]/input"),
            @FindBy(xpath = "//label[contains(.,\"Selen\")]/input")
    })
    private List<WebElement> variants;

    public MaterialsGroup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCBox(String label) {
        switch (label) {
            case "Gold":
                return variants.get(0);
            case "Silver":
                return variants.get(1);
            case "Bronze":
                return variants.get(2);
            case "Selen":
                return variants.get(3);
            default:
                System.err.println("No RadioButton with such label: " + label);
                return null;
        }
    }
}
