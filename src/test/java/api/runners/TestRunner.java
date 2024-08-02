package api.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",// Path to feature files
        glue = "api/stepdefinitions",// Package for step definitions
        plugin = {
                "pretty", // Print logs to console
                "html:target/cucumber-reports.html", // Generate HTML report
                "json:target/cucumber-reports/Cucumber.json" // Generate JSON report for further processing
        }
        //tags = "@smoke" // Tags to include
)
public class TestRunner {

}
