package hw5.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertStep extends BaseStep {

    @Then("Browser title is {string}")
    @Then("{string} page should be opened")
    public void checkTitle(String expected) {
        Assert.assertEquals(driver.getTitle(), expected);
    }

    @Then("Name is {string}")
    public void checkUsername(String expected) {
        Assert.assertEquals(indexPage.getUsername().getText(), expected);
        Assert.assertTrue(indexPage.getUsername().isDisplayed());
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void countNumberType(int expected) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> numbers = userTablePage.getUserTable().getNumbers();
        for (WebElement n : numbers) {
            softAssert.assertTrue(n.isDisplayed());
        }
        softAssert.assertEquals(numbers.size(), expected);
        List<WebElement> types = userTablePage.getUserTable().getTypes();
        for (WebElement t : types) {
            softAssert.assertTrue(t.isDisplayed());
        }
        softAssert.assertEquals(types.size(), expected);

        softAssert.assertAll();
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void countUsernames(int expected) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> names = userTablePage.getUserTable().getUsernames();
        for (WebElement n : names) {
            Assert.assertTrue(n.isDisplayed());
        }
        softAssert.assertEquals(names.size(), expected);

        softAssert.assertAll();
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void countDescriptions(int expected) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> descr = userTablePage.getUserTable().getDescriptions();
        for (WebElement d : descr) {
            softAssert.assertTrue(d.isDisplayed());
        }
        softAssert.assertEquals(descr.size(), expected);
        softAssert.assertAll();
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void countCheckboxes(int expected) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> cboxes = userTablePage.getUserTable().getCheckboxes();
        for (WebElement c : cboxes) {
            softAssert.assertTrue(c.isDisplayed());
        }
        softAssert.assertEquals(cboxes.size(), expected);

        softAssert.assertAll();
    }

    @Then("User table should contain following values:")
    public void checkTable(List<List<String>> expected) {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 1; i < expected.size(); ++i) {
            softAssert.assertEquals(userTablePage.getUserTable().getRowData(i), expected.get(i));
        }

        softAssert.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkRomanDroplist(List<String> expected) {
        SoftAssert softAssert = new SoftAssert();

        Select dropdownMenu = new Select(userTablePage.getUserTable().getDroplists().get(0));
        List<WebElement> options = dropdownMenu.getOptions();
        for (int i = 0; i < options.size(); ++i) {
            softAssert.assertEquals(options.get(i).getText(), expected.get(i + 1));
        }

        softAssert.assertAll();
    }

    @Then("I can see log entries")
    public void checkLogs(List<String> expectedEntries) {
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> log = diffElemPage.getLogComponent().getLog();
        for (int i = 0; i < expectedEntries.size(); ++i) {
            softAssert.assertTrue(log.get(i).getText().contains(expectedEntries.get(i)));
        }

        softAssert.assertAll();
    }

    @Then("{int} log row has {string} text in log section")
    public void countLogs(int expCount, String expString) {
        List<WebElement> log = userTablePage.getLogComponent().getLog();
        long count = log.stream().filter(e -> e.getText().contains(expString)).count();
        Assert.assertEquals(count, expCount);
    }
}
