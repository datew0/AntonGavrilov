package hw5.pages;

import hw5.pages.elements.LeftNavBar;
import hw5.pages.elements.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndexPage {
    final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private final WebDriver driver;
    private final LoginForm loginForm;
    private final LeftNavBar leftNavBar;
    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement username;
    @FindBy(css = "ul.nav > li")
    private List<WebElement> headerNavItems;
    @FindBy(className = "icons-benefit")
    private List<WebElement> icons;
    @FindBy(css = "span.benefit-txt")
    private List<WebElement> texts;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(css = "li.dropdown > a.dropdown-toggle")
    private WebElement serviceDropdownMenu;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        loginForm = new LoginForm(driver);
        leftNavBar = new LeftNavBar(driver);
    }

    public void login(String user, String password) {
        loginForm.login(user, password);
    }

    public WebElement getUsername() {
        return username;
    }

    public List<WebElement> getHeaderNavItems() {
        return headerNavItems;
    }

    public List<WebElement> getIcons() {
        return icons;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        driver.switchTo().frame(frame);
        WebElement button = driver.findElement(By.id("frame-button"));
        return button;
    }

    public LeftNavBar getLeftNavBar() {
        return leftNavBar;
    }

    public void clickDiffElementsPage() {
        serviceDropdownMenu.click();
        driver.findElement(By.cssSelector("ul.dropdown-menu > li > a[href=\"different-elements.html\"]")).click();
    }

    public String getUrl() {
        return url;
    }
}
