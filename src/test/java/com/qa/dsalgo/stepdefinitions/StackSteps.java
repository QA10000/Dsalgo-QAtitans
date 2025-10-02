package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.StackPage;
import com.qa.dsalgo.pages.TryEditorPage;
import utilities.CommonUtils;

public class StackSteps {
	private WebDriver driver;
	StackPage stackpage;
	Background background;
	TryEditorPage tryEditorPage ;
	private static final Logger logger = LogManager.getLogger(StackSteps.class);
	public StackSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		stackpage = new StackPage(driver);
	}
	
	@When("The user clicks the {string} button for Stack module on Home page")
	public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
		logger.info("The user clicks the " + string + " button  for Stack module on Home page");
		stackpage.clicklinkedListGetStarted();
	}

	@Given("The user is on Stack page after login")
	public void theUserIsOnStackPageAfterLogin() {
		logger.info("The user is on Stack page after login");
		stackpage.clicklinkedListGetStarted();
	}
	
	@When("The user clicks on the {string} link on Stack page")
	public void theUserClicksOnTheLinkOnStackPage(String OptionOnStack) {
		logger.info("The user clicks on the " + OptionOnStack + " link on  the Stack page");
		stackpage.clickLinkedListOption(OptionOnStack);
	}

	
	@Given("The user clicks {string} button in Operations in Stack")
	public void theUserClicksButtonInOperationsInStack(String string) {
		
	}
	
	@When("The user clicks on the Operations in Stack link on the Stack page")
	public void theUserClicksOnTheOperationsInStackLinkOnTheStackPage() {
		stackpage.clickOperationsinStackLink();
	}
	
	@When("The user clicks on the Implementation link on the Stack page")
	public void theUserClicksOnTheImplementationLinkOnTheStackPage() {
		stackpage.clickImplementationLink();
	}
	
	@When("The user clicks on the Applications link on the Stack page")
	public void theUserClicksOnTheApplicationsLinkOnTheStackPage() {
		stackpage.clickApplicationsLink();
	}
	
	@Then("All expected navigation links should be displayed")
	public void allexpectednavigationlinksshouldbedisplayed() {
	  Assert.assertTrue(stackpage.areAllExpectedLinksPresent(CommonUtils.STACKPAGE_LINKS));
	}

}