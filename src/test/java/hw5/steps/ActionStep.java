package hw5.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class ActionStep extends BaseStep {

    @When("I click on {string} button in Header")
    public void clickOnButtonHeader(String label) {
        List<WebElement> navItems = indexPage.getHeaderNavItems();
        WebElement button = navItems.stream().filter(elem -> elem.getText().contains(label.toUpperCase(Locale.ROOT))).findAny().orElse(null);
        if (button != null) {
            button.click();
        } else System.err.printf("Button with label: %s not found!%n", label);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonServices(String label) {
        String href = null;
        switch (label) {
            case "Different elements":
                href = "different-elements.html";
                break;
            case "User Table":
                href = "user-table.html";
                break;
            default:
                System.err.println("Unknown page specified!");
        }
        driver.findElement(By.cssSelector("ul.dropdown-menu > li > a[href=\"" + href + "\"]")).click();
    }

    @When("I select materials on Different Elements page")
    public void selectMaterials(List<String> labels) {
        for (String l : labels) {
            WebElement materialCBox = diffElemPage.getMaterials().getCBox(l);
            materialCBox.click();
        }
    }

    @When("I select elements on Different Elements page")
    public void selectElements(List<String> labels) {
        for (String l : labels) {
            WebElement elementCBox = diffElemPage.getElements().getCBox(l);
            elementCBox.click();
        }
    }

    @When("I select {string} in dropdown menu on Different Elements page")
    public void selectColor(String color) {
        Select dropdownMenu = new Select(diffElemPage.getDropdownMenu());
        dropdownMenu.selectByVisibleText(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVip(String user) {
        WebElement row = userTablePage.getUserTable().getRowByUser(user);
        userTablePage.getUserTable().setVipAtRow(row);
    }
}