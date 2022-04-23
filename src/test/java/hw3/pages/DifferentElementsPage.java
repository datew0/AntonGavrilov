package hw3.pages;

import hw3.pages.elements.ElementsGroup;
import hw3.pages.elements.LogComponent;
import hw3.pages.elements.MaterialsGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    private final ElementsGroup elements;

    private final MaterialsGroup materials;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownMenu;

    private final LogComponent logComponent;

    public DifferentElementsPage(WebDriver driver) {
        elements = new ElementsGroup(driver);
        materials = new MaterialsGroup(driver);
        logComponent = new LogComponent(driver);
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public ElementsGroup getElements() {
        return elements;
    }

    public MaterialsGroup getMaterials() {
        return materials;
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }
}
