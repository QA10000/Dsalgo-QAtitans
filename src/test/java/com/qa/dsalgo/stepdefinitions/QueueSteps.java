package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.GraphPage;
import com.qa.dsalgo.pages.QueuePage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class QueueSteps {
	private WebDriver driver;
	QueuePage queuepage;
	Background background;
	TryEditorPage tryEditorPage;

	public QueueSteps() {
		System.out.println(">> In QueueSteps constructor.");
		driver = Hooks.getDriver();
		background = new Background(driver);
		queuepage = new QueuePage(driver);
	}

	/*
	 * // BACKGROUND PASSED - LOGGING IN AND LANDS ON DSALGO PORTAL HOME PAGE
	 * 
	 * @Given("The user lands on the home page after login") public void
	 * theUserLandsOnTheHomePageAfterLogin() {
	 * System.out.println("The user is on the home page after login"); }
	 */

	// BACKGROUND PASSED - LOGGING IN AND LANDS ON DSALGO PORTAL HOME PAGE
	@Given("The user is on the home page after successful login")
	public void theUserIsOnTheHomePageAfterSuccessfulLogin() {
		System.out.println("The user is on the home page after login");
	}

	// STEP1 PASSED- Main Queue Page Headers
	//#STEP4 (should be actually 2)--this is correct
	@When("The user clicks the {string} button for Queue module on Home page")
	public void the_user_clicks_the_button_for_queue_module_on_home_page(String string) {
		System.out.println("The user clicks the " + string + " button for Queue module on Home page");
		queuepage.clickQueueGetStarted();
	}

	
	// step2 MADE CORRECTION, in the public void, adding String string2- check it
	// XPATH NOT WORKING, HENCE GETTING FAILED
	
	@Then("The user should see the below following {string} links on the {string} Page") // changed d (added below)
	public void the_user_should_see_the_below_following_links_on_the_page(String string, String string2) {
		System.out.println("The user lands on the " + string + " page");
		String expectedTitle = string; // All headers
		String actualTitle = queuepage.getQueueOptionHeaderText(expectedTitle); // .getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@When("The user select Queue item from the drop down menu")
	public void theUserSelectQueueItemFromTheDropDownMenu() {
		System.out.println("The user select Queue item from the drop down menu");
		queuepage.SelectQueueFromDropDown();
	}

	@Given("The user is on Queue page after login")
	public void theUserIsOnQueuePageAfterLogin() {
		System.out.println("The user is on Queue page after login");
		queuepage.clickQueueGetStarted();
	}

	@When("The user clicks on this {string} link") // changed-d (changed the to this)
	public void theUserClicksOnThisLink(String OptionOnQueue) {
		System.out.println("The user clicks on the '" + OptionOnQueue + "' link on the Queue page");
		queuepage.clickQueueOption(OptionOnQueue);
	}

	
	
	//For invalid, this when is not working
	//When The user clicks Run button after entering an invalid "<code>" in try editor 
	
	/*
	 * @When("The user clicks {string} button after entering an invalid code {string} in try editor"
	 * ) // changed d (added an, changed Im to In publicvoid) public void
	 * theUserClicksButtonAfterEnteringAnInvalidCodeInTryEditor(String string,
	 * String string2) { System.out.println("The user clicks " + string +
	 * "  button after entering an invalid code " + string2 + " in try editor");
	 * TryEditorPage tryEditorPage = new TryEditorPage(driver);
	 * tryEditorPage.codeEditorSendKeys(string2); tryEditorPage.clickRunBtn(); }
	 */

	//need to add this for invalid When ---------------------------asking to add below snippet
	@When("The user clicks Run button after entering an invalid {string} in try editor")
	public void the_user_clicks_run_button_after_entering_an_invalid_in_try_editor(String string) {
		System.out.println("The user clicks Run button after entering invalid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string);
		tryEditorPage.clickRunBtn();	
	}
		
	
		
		
	@When("The user clicks {string} button on this {string} page") // changed-d (added this)
	public void the_user_clicks_button_on_this_page(String button, String pageName) {
		queuepage.clickTryHere();
	}

	@When("The user clicks Run button after entering valid {string} in the try editor") // changed-d
	public void theUserClicksButtonAfterEnteringValidCodeInTheTryEditor(String code) {
		System.out.println("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}

	@Then("The user should see an output {string} on TryEditor") // changed-d
	public void TheusershouldseeanoutputonTryEditor(String expectedMessage) {
		System.out.println("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	@When("The user clicks on the {string} link on the Queue page")
	public void theUserClicksOnTheLinkOnTheQueuePage(String string) {
		System.out.println("The user clicks on the " + string + " link on the Queue page");
		queuepage.clickQueueOption(string);
	}

	@Then("The user should see an alert with error message {string} on TryEditor") // changed-d (added An)
	public void theUserShouldSeeAnAlertWithErrorMessageOnTryEditor(String expectedMessage) {
		System.out.println("The user should see alert with error message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	// this is coming twice, check if needed- STEP1 THEN - headers------
	@Then("The user should see the following {string} on the Queue Page") 
	public void theUserShouldSeeTheFollowingOnTheQueuePage(String string) {
	 System.out.println("The user should see the following " + string + "  on the QueuePage"); 
	 String expectedTitle = string; //"Queue"; 
	 String actualTitle = queuepage.getQueueOptionHeaderText(expectedTitle);
	 Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!"); 
	 }
	 
	@Then("The user should see the respective following {string} links on the {string} Page")
	// changed-d(Added All,
	// but added// respective)---removed
	// all now
	public void theUserShouldSeeTheRespectiveFollowingLinksOnQueuePage(String string1, String string2) {
		System.out.println("The user should see the respective following " + string1 + "links on the " + string2 + " Page");
		String expectedTitle = string1; // "Queue";
		String actualTitle = queuepage.getQueueLinkOptionText(expectedTitle); // .getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}
	
	
}
