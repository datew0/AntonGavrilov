package hw3.ex1;

import hw3.SeleniumTest;
import hw3.pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ElementsTest extends SeleniumTest {

    @Test
    public void testElements() {
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

        // Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> navBarItems = indexPage.getHeaderNavItems();
        String[] navBarLabels = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < 4; ++i) {
            softAssert.assertTrue((navBarItems.get(i)).isDisplayed());
            softAssert.assertEquals((navBarItems.get(i)).getText(), navBarLabels[i]);
        }

        // Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> icons = indexPage.getIcons();
        softAssert.assertEquals(icons.size(), 4);
        for (WebElement i : icons) {
            softAssert.assertTrue(i.isDisplayed());
        }
        // Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> texts = indexPage.getTexts();
        String[] expectedTexts = {
                "To include good practices and ideas from successful EPAM project",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"
        };
        softAssert.assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; ++i) {
            WebElement text = texts.get(i);
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertEquals(text.getText().replace("\n", " "), expectedTexts[i]);
        }

        // Assert that there is the iframe with “Frame Button” exist
        WebElement frame = indexPage.getFrame();
        softAssert.assertTrue(frame.isDisplayed());

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement frameButton = indexPage.getFrameButton();
        softAssert.assertTrue(frameButton.isDisplayed());

        // Switch to original window back
        driver.switchTo().defaultContent();

        // Assert that there are 5 items in the Left Section are displayed, and they have proper text
        IndexPage.LeftNavBar leftNavBar = indexPage.getLeftNavBar();
        String[] navLabels = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < 5; ++i) {
            WebElement button = leftNavBar.getButton(i);
            softAssert.assertEquals(button.getText(), navLabels[i]);
            softAssert.assertTrue(button.isDisplayed());
        }
        softAssert.assertEquals(leftNavBar.getButtons().size(), 5);

        softAssert.assertAll();
    }
}
