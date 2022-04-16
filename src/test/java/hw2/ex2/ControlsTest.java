package hw2.ex2;

import hw2.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        // Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector("li.dropdown > a.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("ul.dropdown-menu > li > a[href=\"different-elements.html\"]")).click();

        // Select checkboxes: Water, Wind
        WebElement waterCBox = driver.findElement(By.xpath("//label[contains(.,\"Water\")]/input"));
        waterCBox.click();
        softAssert.assertTrue(waterCBox.isSelected());
        WebElement windCBox = driver.findElement(By.xpath("//label[contains(.,\"Wind\")]/input"));
        windCBox.click();
        softAssert.assertTrue(windCBox.isSelected());

        // Select radio: Selen
        WebElement selenRadioBtn = driver.findElement(By.xpath("//label[contains(.,\"Selen\")]/input"));
        selenRadioBtn.click();
        softAssert.assertTrue(selenRadioBtn.isSelected());

        // Select in dropdown: Yellow
        Select dropdownMenu = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        dropdownMenu.selectByVisibleText("Yellow");
        softAssert.assertEquals(dropdownMenu.getFirstSelectedOption().getText(), "Yellow");

        // Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        List<WebElement> log = driver.findElements(By.cssSelector("ul.logs > li"));
        String expectedLogMsg[] = new String[]{"Yellow", "Selen", "Wind", "Water"};
        for (int i = 0; i < 4; ++i) {
            softAssert.assertTrue(log.get(i).getText().contains(expectedLogMsg[i]));
        }

        softAssert.assertAll();
    }
}
