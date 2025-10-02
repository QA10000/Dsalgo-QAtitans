package com.qa.dsalgo.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.QueuePage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueueSteps {
	private WebDriver driver;
	QueuePage queuepage;
	Background background;
	TryEditorPage tryEditorPage;
	private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);

	public QueueSteps() {
		System.out.println(">> In QueueSteps constructor.");
		driver = Hooks.getDriver();
		background = new Background(driver);
		queuepage = new QueuePage(driver);
	}

	@Given("The user is on the home page after successful login")
	public void theUserIsOnTheHomePageAfterSuccessfulLogin() {
		logger.info("The user is on the home page after login");
	}

	@When("The user clicks the {string} button for Queue module on Home page")
	public void the_user_clicks_the_button_for_queue_module_on_home_page(String string) {
		logger.info("The user clicks the " + string + " button for Queue module on Home page");
		queuepage.clickQueueGetStarted();
	}

	@Then("The user should see the below following {string} links on the {string} Page")
	public void the_user_should_see_the_below_following_links_on_the_page(String string, String string2) {
		logger.info("The user lands on the " + string + " page");
		String expectedTitle = string;
		String actualTitle = queuepage.getQueueOptionHeaderText(expectedTitle);
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@When("The user select Queue item from the drop down menu")
	public void theUserSelectQueueItemFromTheDropDownMenu() {
		logger.info("The user select Queue item from the drop down menu");
		queuepage.SelectQueueFromDropDown();
	}

	@Given("The user is on Queue page after login")
	public void theUserIsOnQueuePageAfterLogin() {
		logger.info("The user is on Queue page after login");
		queuepage.clickQueueGetStarted();
	}

	@When("The user clicks on this {string} link") 
	public void theUserClicksOnThisLink(String OptionOnQueue) {
		logger.info("The user clicks on the '" + OptionOnQueue + "' link on the Queue page");
		queuepage.clickQueueOption(OptionOnQueue);
	}

	@When("The user clicks Run button after entering an invalid {string} in try editor")
	public void the_user_clicks_run_button_after_entering_an_invalid_in_try_editor(String string) {
		logger.info("The user clicks Run button after entering invalid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string);
		tryEditorPage.clickRunBtn();	
	}
		
	@When("The user clicks {string} button on this {string} page") 
	public void the_user_clicks_button_on_this_page(String button, String pageName) {
		queuepage.clickTryHere();
	}

	@When("The user clicks Run button after entering valid {string} in the try editor") 
	public void theUserClicksButtonAfterEnteringValidCodeInTheTryEditor(String code) {
		logger.info("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}

	@Then("The user should see an output {string} on TryEditor")
	public void TheusershouldseeanoutputonTryEditor(String expectedMessage) {
		logger.info("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	@When("The user clicks on the {string} link on the Queue page")
	public void theUserClicksOnTheLinkOnTheQueuePage(String string) {
		logger.info("The user clicks on the " + string + " link on the Queue page");
		queuepage.clickQueueOption(string);
	}

	@Then("The user should see an alert with error message {string} on TryEditor")
	public void theUserShouldSeeAnAlertWithErrorMessageOnTryEditor(String expectedMessage) {
		logger.info("The user should see alert with error message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	@Then("The user should see the following {string} on the Queue Page") 
	public void theUserShouldSeeTheFollowingOnTheQueuePage(String string) {
	logger.info("The user should see the following " + string + "  on the QueuePage"); 
	 String expectedTitle = string;
	 String actualTitle = queuepage.getQueueOptionHeaderText(expectedTitle);
	 Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!"); 
	 }
	 
	@Then("The user should see the respective following {string} links on the {string} Page")
	public void theUserShouldSeeTheRespectiveFollowingLinksOnQueuePage(String string1, String string2) {
		logger.info("The user should see the respective following " + string1 + "links on the " + string2 + " Page");
		String expectedTitle = string1; // "Queue";
		String actualTitle = queuepage.getQueueLinkOptionText(expectedTitle);
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}
	
}
