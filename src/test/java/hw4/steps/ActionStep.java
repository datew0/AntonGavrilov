package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionStep extends Step {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public void openIndexPage() {
        driver.get(indexPage.getUrl());
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        diffElemPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    public void login(String user, String pass) {
        indexPage.login(user, pass);
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public void clickOnDiffElementsPage() {
        indexPage.clickDiffElementsPage();
    }

    public void selectElement(String label) {
        WebElement elementCBox = diffElemPage.getElements().getCBox(label);
        elementCBox.click();
    }

    public void selectMaterial(String label) {
        WebElement materialCBox = diffElemPage.getMaterials().getCBox(label);
        materialCBox.click();
    }

    public void selectColor(String color) {
        Select dropdownMenu = new Select(diffElemPage.getDropdownMenu());
        dropdownMenu.selectByVisibleText("Yellow");
    }
}