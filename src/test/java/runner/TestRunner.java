package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	 plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "html:target/cucumber.html"},

    features = "src/test/resources/features",
    glue = {"com.qa.dsalgo.stepdefinitions.Hooks" },
    dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

  

}

