package hw5.steps;

import io.cucumber.java.en.Given;

import java.util.List;

public class GivenStep extends BaseStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        driver.get(indexPage.getUrl());
    }

    @Given("I login as user {string}")
    public void login(String user) {
        List<String> credentials = List.of(properties.getProperty(user.replace(' ', '_')).split(":"));
        indexPage.login(credentials.get(0), credentials.get(1));
    }


}