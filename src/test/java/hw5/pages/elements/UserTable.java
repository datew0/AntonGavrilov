package hw5.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class UserTable {

    @FindBy(css = "table#user-table > tbody > tr")
    List<WebElement> numbers;

    @FindBy(css = "table#user-table > tbody > tr > td > select")
    List<WebElement> types;
    @FindBy(css = "table#user-table > tbody > tr > td > div.user-descr > span")
    List<WebElement> descriptions;
    @FindBy(css = "table#user-table > tbody > tr > td > div.user-descr > input")
    List<WebElement> checkboxes;
    @FindBy(css = "table#user-table > tbody > tr > td > select")
    List<WebElement> droplists;
    @FindBy(css = "table#user-table > tbody > tr > td > a")
    List<WebElement> usernames;
    @FindBy(css = "table#user-table > tbody > tr")
    List<WebElement> rows;

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getDroplists() {
        return droplists;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public List<WebElement> getTypes() {
        return types;
    }

    public List<String> getRowData(int index) {
        List<String> result = new LinkedList<>();
        // Number
        result.add(rows.get(index - 1).findElement(By.cssSelector("td")).getText());
        // Username
        result.add(rows.get(index - 1).findElement(By.cssSelector("td > a")).getText());
        // Description
        result.add(rows.get(index - 1).findElement(By.cssSelector("td > div.user-descr > span")).getText().replace('\n', ' '));
        return result;
    }

    public WebElement getRowByUser(String name) {
        return rows.stream().filter(r -> r.findElement(By.cssSelector("td > a")).getText().equals(name)).findAny().orElse(null);
    }

    public void setVipAtRow(WebElement row) {
        row.findElement(By.cssSelector("td > div.user-descr > input")).click();
    }

}
