package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinition", "Utilities", "Pages"},
        plugin = {"json:target/cucumber.json"
        }


)

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}