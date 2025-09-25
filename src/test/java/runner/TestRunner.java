package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	 plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},

    features = "src/test/resources/features",
    glue = {"com.qa.dsalgo.stepdefinitions.Hooks","com.qa.dsalgo.stepdefinitions" },
    dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

  

    }

