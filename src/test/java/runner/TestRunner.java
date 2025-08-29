package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.java.After;

//@CucumberOptions(
//		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
	//	monochrome=false,
		//		features = "src/test/resources/features",
    //glue = {"com.qa.dsalgo.myhooks","com.qa.dsalgo.stepdefinitions" },
    //dryRun = true)

//public class TestRunner extends AbstractTestNGCucumberTests {

  

  //  }

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.qa.dsalgo.myhooks","com.qa.dsalgo.stepdefinitions" },
    dryRun = false,
    plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

  

    }

