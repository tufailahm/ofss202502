package runners;

import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "com.training",
        plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class TestRunner {


}