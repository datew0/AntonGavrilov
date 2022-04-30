package hw5.ex2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5/ex2.feature"},
        glue = {"hw5.steps"},
        tags = "@table"
)

public class TableTest extends AbstractTestNGCucumberTests {
}