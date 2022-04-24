package hw4.ex2;

import hw4.SeleniumTest;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import org.testng.annotations.Test;

import java.util.Arrays;

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