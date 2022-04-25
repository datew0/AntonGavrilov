package hw3.ex2;

import hw3.SeleniumTest;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ControlsTest extends SeleniumTest {

    @Test
    public void testControls() {
        SoftAssert softAssert = new SoftAssert();

        // Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

        // Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // Perform login
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));

        // Assert Username is logged in
        softAssert.assertEquals(indexPage.getUsername().getText(), properties.getProperty("username"));

        // Open through the header menu Service -> Different Elements Page
        indexPage.clickDiffElementsPage();
        DifferentElementsPage diffElemPage = PageFactory.initElements(driver, DifferentElementsPage.class);

        // Select checkboxes: Water, Wind
        WebElement waterCBox = diffElemPage.getElements().getCBox("Water");
        waterCBox.click();
        softAssert.assertTrue(waterCBox.isSelected());
        WebElement windCBox = diffElemPage.getElements().getCBox("Wind");
        windCBox.click();
        softAssert.assertTrue(windCBox.isSelected());

        // Select radio: Selen
        WebElement selenRadioBtn = diffElemPage.getMaterials().getCBox("Selen");
        selenRadioBtn.click();
        softAssert.assertTrue(selenRadioBtn.isSelected());

        // Select in dropdown: Yellow
        Select dropdownMenu = new Select(diffElemPage.getDropdownMenu());
        dropdownMenu.selectByVisibleText("Yellow");
        softAssert.assertEquals(dropdownMenu.getFirstSelectedOption().getText(), "Yellow");

        // Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        List<WebElement> log = diffElemPage.getLogComponent().getLog();
        String expectedLogMsg[] = new String[]{"Yellow", "Selen", "Wind", "Water"};
        for (int i = 0; i < 4; ++i) {
            softAssert.assertTrue(log.get(i).getText().contains(expectedLogMsg[i]));
        }

        softAssert.assertAll();
    }
}
