package com.qa.dsalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions(features = "src/test/resources/features"
		, glue = {"com.qa.dsalgo.stepdefinitions" } 
		, dryRun = false
		, plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
)*/

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"src/test/java/com/qa/dsalgo/stepdefinitions"},
	    dryRun = false,
	    plugin = {"pretty"}
	)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}