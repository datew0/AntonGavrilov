package hw5.pages;

import hw5.pages.elements.LogComponent;
import hw5.pages.elements.UserTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage {


    @FindBy(id = "user-table")
    UserTable userTable;
    LogComponent logComponent;

    public UserTablePage(WebDriver driver) {
        userTable = PageFactory.initElements(driver, UserTable.class);
        logComponent = PageFactory.initElements(driver, LogComponent.class);
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public UserTable getUserTable() {
        return userTable;
    }
}
