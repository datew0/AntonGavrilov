package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage {
    private WebDriver driver;
    final String url = "https://jdi-testing.github.io/jdi-light/index.html";

    public class LoginForm {

        @FindBy(id="user-icon")
        private WebElement userIcon;
        @FindBy(id = "name")
        private WebElement user;
        @FindBy(id = "password")
        private WebElement password;
        @FindBy(className = "btn-login")
        private WebElement loginBtn;

        public LoginForm(WebDriver driver){
            PageFactory.initElements(driver, this);
        }
    }
    private LoginForm loginForm;

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(css = "ul.nav > li")
    private List<WebElement> headerNavItems;

    @FindBy(className = "icons-benefit")
    private List<WebElement> icons;

    @FindBy(css = "span.benefit-txt")
    private List<WebElement> texts;

    @FindBy(id = "frame")
    private WebElement frame;

    public class LeftNavBar {

        @FindBy(css = "ul.sidebar-menu>li")
        private List<WebElement> buttons;

        public LeftNavBar(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

        public WebElement getButton(int index){
            return buttons.get(index);
        }
        public List<WebElement> getButtons() {
            return buttons;
        }
    }
    private LeftNavBar leftNavBar;

    @FindBy(css = "li.dropdown > a.dropdown-toggle")
    private WebElement serviceDropdownMenu;

    public IndexPage(WebDriver driver) {
        driver.get(url);
        this.driver = driver;
        loginForm = new LoginForm(driver);
        leftNavBar = new LeftNavBar(driver);
    }

    public void login(String user, String password){
        loginForm.userIcon.click();
        loginForm.user.sendKeys(user);
        loginForm.password.sendKeys(password);
        loginForm.loginBtn.click();
    }

    public WebElement getUsername(){
        return username;
    }

    public List<WebElement> getHeaderNavItems(){
        return headerNavItems;
    }

    public List<WebElement> getIcons(){
        return icons;
    }

    public List<WebElement> getTexts(){
        return texts;
    }

    public WebElement getFrame(){
        return frame;
    }

    public WebElement getFrameButton(){
        driver.switchTo().frame(frame);
        WebElement button = driver.findElement(By.id("frame-button"));
        return button;
    }

    public LeftNavBar getLeftNavBar() {
        return leftNavBar;
    }
    public void clickDiffElementsPage(){
        serviceDropdownMenu.click();
        driver.findElement(By.cssSelector("ul.dropdown-menu > li > a[href=\"different-elements.html\"]")).click();
    }
}
