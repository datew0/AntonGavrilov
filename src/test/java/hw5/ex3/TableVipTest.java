package hw5.ex3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5/ex3.feature"},
        glue = {"hw5.steps"},
        tags = "@vip"
)

public class TableVipTest extends AbstractTestNGCucumberTests {
}