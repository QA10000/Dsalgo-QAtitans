package com.qa.dsalgo.stepdefinitions;

import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedList  extends DriverScripts {
	Background background;
/*
	@Given("The user is on the DSAlgo1 portal")
	public void the_user_is_on_the_ds_algo_portal1() {
		initializeApplication();// Initialize the page object with the current driver
		background = new Background(driver); // driver must not be null
	}


	@When("The user clicks \"GetStarted\" button")
		public void the_user_clicks(String string) {
	background = new Background(driver); // driver must not be null
	background.ClickGetStarted();
	}
	
	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
		RegisterPage registerpage = new RegisterPage(driver);
		String expectedTitle = "NumpyNinja";
		String actualTitle = registerpage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}
	*/
/*
	@Given("The user is on the home page after login")
	public void theUserIsOnTheHomePageAfterLogin() {
		throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks the {string} button  for Linked List module on Home page")
	public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user lands on the {string} page")
	public void theUserLandsOnThePage(String string) {
		throw new io.cucumber.java.PendingException();
	}
	*/
}

