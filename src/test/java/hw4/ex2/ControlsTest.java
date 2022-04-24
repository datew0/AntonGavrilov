package hw4.ex2;

import hw4.SeleniumTest;
import hw4.pages.DifferentElementsPage;
import hw4.pages.IndexPage;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class ControlsTest extends SeleniumTest {

    @Test
    public void testControls() {
        ActionStep actionStep = new ActionStep(driver);
        AssertStep assertStep = new AssertStep(driver);

        // Open test site by URL
        actionStep.openIndexPage();

        // Assert browser title
        assertStep.checkTitle("Home Page");

        // Perform login
        actionStep.login(properties.getProperty("login"), properties.getProperty("password"));

        // Assert Username is logged in
        assertStep.checkUsername(properties.getProperty("username"));

        // Open through the header menu Service -> Different Elements Page
        actionStep.clickOnDiffElementsPage();

        // Select checkboxes: Water, Wind
        actionStep.selectElement("Water");
        actionStep.selectElement("Wind");

        // Select radio: Selen
        actionStep.selectMaterial("Selen");

        // Select in dropdown: Yellow
        actionStep.selectColor("Yellow");

        // Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertStep.checkLogs(Arrays.asList("Yellow", "Selen", "Wind", "Water"));

    }
}
