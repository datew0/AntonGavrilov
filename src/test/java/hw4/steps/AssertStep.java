package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertStep extends BaseStep {

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step("Ensure that title is {expected}")
    public void checkTitle(String expected) {
        Assert.assertEquals(driver.getTitle(), expected);
    }

    @Step("Ensure that username {expected} is displayed")
    public void checkUsername(String expected) {
        Assert.assertEquals(indexPage.getUsername().getText(), expected);
        Assert.assertTrue(indexPage.getUsername().isDisplayed());
    }

    @Step("Ensure that header items are displayed and contain {expectedLabels}")
    public void checkHeaderItems(List<String> expectedLabels) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> navBarItems = indexPage.getHeaderNavItems();
        for (int i = 0; i < expectedLabels.size(); ++i) {
            softAssert.assertTrue((navBarItems.get(i)).isDisplayed());
            softAssert.assertEquals((navBarItems.get(i)).getText(), expectedLabels.get(i));
        }
        softAssert.assertEquals(navBarItems.size(), expectedLabels.size());

        softAssert.assertAll();
    }

    @Step("Ensure that {count} image(s) are displayed")
    public void checkImages(int count) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> icons = indexPage.getIcons();
        for (WebElement i : icons) {
            softAssert.assertTrue(i.isDisplayed());
        }
        softAssert.assertEquals(icons.size(), count);

        softAssert.assertAll();
    }

    @Step("Ensure that image legends are displayed and contain {expectedTexts}")
    public void checkTextsUnderIcons(List<String> expectedTexts) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> texts = indexPage.getTexts();
        softAssert.assertEquals(texts.size(), expectedTexts.size());
        for (int i = 0; i < expectedTexts.size(); ++i) {
            WebElement text = texts.get(i);
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertEquals(text.getText().replace("\n", " "), expectedTexts.get(i));
        }

        softAssert.assertAll();
    }

    @Step("Ensure that frame is presented")
    public void checkIFrame() {
        WebElement frame = indexPage.getFrame();
        Assert.assertTrue(frame.isDisplayed());
    }

    @Step("Ensure that frame button is presented")
    public void checkFrameButton() {
        WebElement frameButton = indexPage.getFrameButton();
        Assert.assertTrue(frameButton.isDisplayed());
    }

    @Step("Ensure that left navbar contains {expectedLabels}")
    public void checkLeftNavBar(List<String> expectedLabels) {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < expectedLabels.size(); ++i) {
            WebElement button = indexPage.getLeftNavBar().getButton(i);
            softAssert.assertEquals(button.getText(), expectedLabels.get(i));
            softAssert.assertTrue(button.isDisplayed());
        }
        softAssert.assertEquals(indexPage.getLeftNavBar().getButtons().size(), expectedLabels.size());

        softAssert.assertAll();
    }

    @Step("Ensure that {expectedEntries} are presented in logs")
    public void checkLogs(List<String> expectedEntries) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> log = diffElemPage.getLogComponent().getLog();
        for (int i = 0; i < expectedEntries.size(); ++i) {
            softAssert.assertTrue(log.get(i).getText().contains(expectedEntries.get(i)));
        }

        softAssert.assertAll();
    }
}
