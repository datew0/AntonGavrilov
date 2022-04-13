package hw2.ex1;

import hw2.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ElementsTest extends SeleniumTest {

    @Test
    public void testElements() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        // Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.className("btn-login")).click();

        // Assert Username is logged in
        WebElement username = driver.findElement(By.id("user-name"));
        softAssert.assertEquals(username.getText(), "ROMAN IOVLEV");

        // Assert that there are 4 items on the header section are displayed, and they have proper texts
        Object navBarItems[] = driver.findElements(By.cssSelector("ul.nav > li")).toArray();
        String[] navBarLabels = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i=0; i<4; ++i){
            softAssert.assertTrue(((WebElement)navBarItems[i]).isDisplayed());
            softAssert.assertEquals(((WebElement)navBarItems[i]).getText(),navBarLabels[i]);
        }


        // Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> icons = driver.findElements(By.className("icons-benefit"));
        softAssert.assertEquals(icons.size(), 4);
        for (WebElement i : icons)
            softAssert.assertTrue(i.isDisplayed());

        // Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> texts = driver.findElements(By.cssSelector("span.benefit-txt"));
        String[] expectedTexts = {
                "To include good practices and ideas from successful EPAM project",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"
        };
        ListIterator<WebElement> it = texts.listIterator();
        for (int i = 0; i < 4; ++i) {
            WebElement text = it.next();
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertEquals(text.getText().replace("\n", " "), expectedTexts[i]);
        }

        // Assert that there is the iframe with “Frame Button” exist
        WebElement frame = driver.findElement(By.id("frame"));
        softAssert.assertTrue(frame.isDisplayed());

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(frame);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());

        // Switch to original window back
        driver.switchTo().defaultContent();

        // Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> navButtons = new LinkedList<>();
        String[] navLabels = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < 5; ++i) {
            WebElement button = driver.findElement(By.cssSelector("div#mCSB_1_container > ul > li[index='" + (i + 1) + "']"));
            softAssert.assertEquals(button.getText(), navLabels[i]);
            softAssert.assertTrue(button.isDisplayed());
            navButtons.add(button);
        }
        softAssert.assertEquals(navButtons.size(), 5);
    }
}
