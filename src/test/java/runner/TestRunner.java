package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.qa.dsalgo.myhooks","com.qa.dsalgo.stepdefinitions" },
    dryRun = false,
    plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

  

    }



