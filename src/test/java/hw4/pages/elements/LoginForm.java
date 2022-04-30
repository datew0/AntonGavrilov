package hw4.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm {

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(className = "btn-login")
    private WebElement loginBtn;

    public LoginForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String pass) {
        userIcon.click();
        user.sendKeys(username);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
