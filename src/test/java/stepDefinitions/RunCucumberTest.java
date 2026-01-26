package stepDefinitions;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("stepDefinitions")
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features", glue = "stepDefinitions")
public class RunCucumberTest {
}