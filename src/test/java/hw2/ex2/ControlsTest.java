package hw2.ex2;

import hw2.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ControlsTest extends SeleniumTest {

    @Test
    public void testControls(){
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
        WebElement waterCBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main[1]/div[2]/div[1]/div[2]/label[1]/input[1]"));
        waterCBox.click();
        softAssert.assertTrue(waterCBox.isSelected());
        WebElement windCBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main[1]/div[2]/div[1]/div[2]/label[3]/input[1]"));
        windCBox.click();
        softAssert.assertTrue(windCBox.isSelected());
        int a = 10;

        // Select radio: Selen
        WebElement selenRadioBtn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main[1]/div[2]/div[1]/div[3]/label[4]/input[1]"));
        selenRadioBtn.click();
        softAssert.assertTrue(selenRadioBtn.isSelected());

        // Select in dropdown: Yellow
        Select dropdownMenu = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        dropdownMenu.selectByVisibleText("Yellow");
        softAssert.assertEquals(dropdownMenu.getFirstSelectedOption().getText(), "Yellow");

        // Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        WebElement log[] = new WebElement[4];
        for(int i=0; i<4; ++i)
            log[i] = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div[1]/ul[1]/li[" + (i+1) + "]"));
        softAssert.assertTrue(log[0].getText().contains("Yellow"));
        softAssert.assertTrue(log[1].getText().contains("Selen"));
        softAssert.assertTrue(log[2].getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(log[3].getText().contains("Water: condition changed to true"));
    }
}
