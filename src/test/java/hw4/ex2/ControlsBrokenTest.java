package hw4.ex2;

import hw4.SeleniumTest;
import hw4.listeners.ScreenShotListener;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({ScreenShotListener.class})
@Story("User can login and interact with controls")
public class ControlsBrokenTest extends SeleniumTest {

    @Feature("Checking controls")
    @Test(description = "Test form elements and logs")
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
        assertStep.checkLogs(List.of("Blue")); // Wrong
    }
}
