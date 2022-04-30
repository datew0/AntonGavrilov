package hw5.ex1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5/ex1.feature"},
        glue = {"hw5.steps"},
        tags = "@controls"
)

public class ControlsTest extends AbstractTestNGCucumberTests {
}