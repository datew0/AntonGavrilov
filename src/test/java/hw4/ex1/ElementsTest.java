package hw4.ex1;

import hw4.SeleniumTest;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;

@Story("User can login, elements are displaying")
public class ElementsTest extends SeleniumTest {

    @Feature("Checking elements")
    @Test(description = "Elements are visible for authorized user")
    public void testElements() {
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

        // Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertStep.checkHeaderItems(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // Assert that there are 4 images on the Index Page, and they are displayed
        assertStep.checkImages(4);

        // Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertStep.checkTextsUnderIcons(Arrays.asList(
                "To include good practices and ideas from successful EPAM project",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"));

        // Assert that there is the iframe with “Frame Button” exist
        assertStep.checkIFrame();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        assertStep.checkFrameButton();

        // Switch to original window back
        actionStep.switchToOriginalWindow();

        // Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertStep.checkLeftNavBar(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    }
}
