package hw5.pages;

import hw5.pages.elements.ElementsGroup;
import hw5.pages.elements.LogComponent;
import hw5.pages.elements.MaterialsGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    private final ElementsGroup elements;

    private final MaterialsGroup materials;
    private final LogComponent logComponent;
    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownMenu;

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
