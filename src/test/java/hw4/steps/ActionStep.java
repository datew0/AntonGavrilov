package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionStep extends BaseStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open index page")
    public void openIndexPage() {
        driver.get(indexPage.getUrl());
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        diffElemPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    @Step("Login as {user} with password {pass}")
    public void login(String user, String pass) {
        indexPage.login(user, pass);
    }

    @Step("Leave iframe")
    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    @Step("Move to Different Elements page")
    public void clickOnDiffElementsPage() {
        indexPage.clickDiffElementsPage();
    }

    @Step("Select {label} in elements group")
    public void selectElement(String label) {
        WebElement elementCBox = diffElemPage.getElements().getCBox(label);
        elementCBox.click();
    }

    @Step("Select {label} in materials group")
    public void selectMaterial(String label) {
        WebElement materialCBox = diffElemPage.getMaterials().getCBox(label);
        materialCBox.click();
    }

    @Step("Select {color} in dropdown menu")
    public void selectColor(String color) {
        Select dropdownMenu = new Select(diffElemPage.getDropdownMenu());
        dropdownMenu.selectByVisibleText("Yellow");
    }
}