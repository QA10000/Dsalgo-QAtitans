package com.qa.dsalgo.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features/register.feature",
	    glue = {"com.qa.dsalgo.stepdefinitions"},
	    dryRun= true,
	    plugin= {"pretty"}
	)

public class TestRunner {

}
